import {Component, OnInit, signal, ViewChild} from '@angular/core';
import {ConfirmationService, MessageService} from 'primeng/api';
import {Table, TableModule} from 'primeng/table';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import {RippleModule} from 'primeng/ripple';
import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {RatingModule} from 'primeng/rating';
import {InputTextModule} from 'primeng/inputtext';
import {TextareaModule} from 'primeng/textarea';
import {SelectModule} from 'primeng/select';
import {RadioButtonModule} from 'primeng/radiobutton';
import {InputNumberModule} from 'primeng/inputnumber';
import {DialogModule} from 'primeng/dialog';
import {TagModule} from 'primeng/tag';
import {InputIconModule} from 'primeng/inputicon';
import {IconFieldModule} from 'primeng/iconfield';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {Country} from '../service/country.service';
import {Person, PersonService} from "../service/person.service";

interface Column {
    field: string;
    header: string;
    customExportHeader?: string;
}

interface ExportColumn {
    title: string;
    dataKey: string;
}

@Component({
    selector: 'app-person',
    standalone: true,
    imports: [
        CommonModule,
        TableModule,
        FormsModule,
        ButtonModule,
        RippleModule,
        ToastModule,
        ToolbarModule,
        RatingModule,
        InputTextModule,
        TextareaModule,
        SelectModule,
        RadioButtonModule,
        InputNumberModule,
        DialogModule,
        TagModule,
        InputIconModule,
        IconFieldModule,
        ConfirmDialogModule
    ],
    template: `
        <p-toolbar styleClass="mb-6">
            <ng-template #start>
                <p-button label="New" icon="pi pi-plus" severity="secondary" class="mr-2" (onClick)="openNew()"/>
                <p-button severity="secondary" label="Delete" icon="pi pi-trash" outlined
                          (onClick)="deleteSelectedProducts()" [disabled]="!selectedPeople || !selectedPeople.length"/>
            </ng-template>

            <ng-template #end>
                <p-button label="Refresh" icon="pi pi-refresh" severity="secondary" (onClick)="refresh()"/>
                <p-button label="Export" icon="pi pi-upload" severity="secondary" (onClick)="exportCSV()"/>
            </ng-template>
        </p-toolbar>

        <p-table
            #dt
            [value]="people()"
            [rows]="10"
            [columns]="cols"
            [paginator]="true"
            [globalFilterFields]="['name', 'country.name', 'representative.name', 'status']"
            [tableStyle]="{ 'min-width': '75rem' }"
            [(selection)]="selectedPeople"
            [rowHover]="true"
            dataKey="id"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords} countries"
            [showCurrentPageReport]="true"
            [rowsPerPageOptions]="[10, 20, 30]"
        >
            <ng-template #caption>
                <div class="flex items-center justify-between">
                    <h5 class="m-0">People</h5>
                    <p-iconfield>
                        <p-inputicon styleClass="pi pi-search"/>
                        <input pInputText type="text" (input)="onGlobalFilter(dt, $event)" placeholder="Search..."/>
                    </p-iconfield>
                </div>
            </ng-template>
            <ng-template #header>
                <tr>
                    <th style="width: 3rem">
                        <p-tableHeaderCheckbox/>
                    </th>
                    <th pSortableColumn="firstName" style="min-width:16rem">
                        First name
                        <p-sortIcon field="firstName"/>
                    </th>
                    <th pSortableColumn="LastName" style="min-width:16rem">
                        Last name
                        <p-sortIcon field="LastName"/>
                    </th>
                </tr>
            </ng-template>
            <ng-template #body let-person>
                <tr>
                    <td style="width: 3rem">
                        <p-tableCheckbox [value]="person"/>
                    </td>
                    <td style="min-width: 16rem">{{ person.first_name }}</td>
                    <td style="min-width: 16rem">{{ person.last_name }}</td>
                    <td>
                        <p-button icon="pi pi-pencil" class="mr-2" [rounded]="true" [outlined]="true"
                                  (click)="editProduct(person)"/>
                        <p-button icon="pi pi-trash" severity="danger" [rounded]="true" [outlined]="true"
                                  (click)="deleteProduct(person)"/>
                    </td>
                </tr>
            </ng-template>
        </p-table>

        <p-dialog [(visible)]="countryDialog" [style]="{ width: '650px' }" header="Hotel details" [modal]="true">
            <ng-template #content>
                <div class="flex flex-col gap-6">
                    <div>
                        <label for="name" class="block font-bold mb-3">First Name</label>
                        <input type="text" pInputText id="name" [(ngModel)]="person.first_name" required autofocus
                               fluid/>
                        <small class="text-red-500" *ngIf="submitted && !person.first_name">Name is required.</small>
                    </div>
                    <div>
                        <label for="name" class="block font-bold mb-3">Last Name</label>
                        <input type="text" pInputText id="name" [(ngModel)]="person.last_name" required autofocus fluid/>
                        <small class="text-red-500" *ngIf="submitted && !person.last_name">Name is required.</small>
                    </div>
<!--                    <div>-->
<!--                        <label for="name" class="block font-bold mb-3">Country</label>-->
<!--                        <input type="text" pInputText id="name" [(ngModel)]="person!.country!.name" required autofocus-->
<!--                               fluid/>-->
<!--                    </div>-->
                    <div>
                        <label for="name" class="block font-bold mb-3">External id</label>
                        <input type="text" pInputText id="name" [(ngModel)]="person.external_id" required autofocus fluid/>
                    </div>
                    <div>
                        <label for="name" class="block font-bold mb-3">Id</label>
                        <input type="text" pInputText id="name" [(ngModel)]="person.user_id" required autofocus fluid/>
                    </div>
                </div>
            </ng-template>

            <ng-template #footer>
                <p-button label="Cancel" icon="pi pi-times" text (click)="hideDialog()"/>
                <p-button label="Save" icon="pi pi-check" (click)="saveProduct()"/>
            </ng-template>
        </p-dialog>

        <p-confirmdialog [style]="{ width: '450px' }"/>
    `,
    providers: [MessageService, PersonService, ConfirmationService]
})
export class PersonComponent implements OnInit {
    countryDialog: boolean = false;

    people = signal<Person[]>([]);

    person!: Person;

    selectedPeople!: Person[] | null;

    submitted: boolean = false;

    statuses!: any[];

    @ViewChild('dt') dt!: Table;

    exportColumns!: ExportColumn[];

    cols!: Column[];

    constructor(
        private peopleService: PersonService,
        private messageService: MessageService,
        private confirmationService: ConfirmationService
    ) {}

    exportCSV() {
        this.dt.exportCSV();
    }

    ngOnInit() {
        this.loadDemoData();
    }

    refresh() {
        console.log('refresh');
        this.loadDemoData();
    }

    loadDemoData() {
        this.peopleService.getPeople().subscribe((data) => {
            console.log('result');
            console.log(data);
            this.people.set(data.persons || []);
        });

        this.statuses = [
            { label: 'INSTOCK', value: 'instock' },
            { label: 'LOWSTOCK', value: 'lowstock' },
            { label: 'OUTOFSTOCK', value: 'outofstock' }
        ];

        this.cols = [
            { field: 'code', header: 'Code', customExportHeader: 'Product Code' },
            { field: 'name', header: 'Name' },
            { field: 'image', header: 'Image' },
            { field: 'price', header: 'Price' },
            { field: 'category', header: 'Category' }
        ];

        this.exportColumns = this.cols.map((col) => ({ title: col.header, dataKey: col.field }));
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
    }

    openNew() {
        this.person = {};
        this.submitted = false;
        this.countryDialog = true;
    }

    editProduct(product: Person) {
        this.person = { ...product };
        this.countryDialog = true;
    }

    deleteSelectedProducts() {
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete the selected products?',
            header: 'Confirm',
            icon: 'pi pi-exclamation-triangle',
            accept: () => {
                //this.products.set(this.products().filter((val) => !this.selectedProducts?.includes(val)));

                this.selectedPeople = null;
                this.messageService.add({
                    severity: 'success',
                    summary: 'Successful',
                    detail: 'Products Deleted',
                    life: 3000
                });
            }
        });
    }

    hideDialog() {
        this.countryDialog = false;
        this.submitted = false;
    }

    deleteProduct(hotel: Country) {
        //    this.confirmationService.confirm({
        //        message: 'Are you sure you want to delete ' + hotel.name + '?',
        //        header: 'Confirm',
        //        icon: 'pi pi-exclamation-triangle',
        //        accept: () => {
        //            //this.products.set(this.products().filter((val) => val.id !== product.id));
        //            this.country.deleteHotel(hotel).subscribe((res) => {
        //                this.refresh();
        //                this.product = {};
        //            });
        //
        //
        //            this.messageService.add({
        //                severity: 'success',
        //                summary: 'Successful',
        //                detail: 'Product Deleted',
        //                life: 3000
        //            });
        //        }
        //    });
    }

    findIndexById(id: string): number {
        let index = -1;
        //for (let i = 0; i < this.products().length; i++) {
        //    if (this.products()[i].id === id) {
        //        index = i;
        //        break;
        //    }
        //}

        return index;
    }

    createId(): string {
        let id = '';
        var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        for (var i = 0; i < 5; i++) {
            id += chars.charAt(Math.floor(Math.random() * chars.length));
        }
        return id;
    }

    getSeverity(status: string) {
        switch (status) {
            case 'INSTOCK':
                return 'success';
            case 'LOWSTOCK':
                return 'warn';
            case 'OUTOFSTOCK':
                return 'danger';
            default:
                return 'info';
        }
    }

    saveProduct() {
        this.submitted = true;
        this.peopleService.savePerson(this.person).subscribe((data) => {
            this.refresh();
        });
        this.countryDialog = false;
        this.person = {};
        //console.log('save clicked');
        //this.submitted = true;
        //this.countryService.saveHotel(this.country).subscribe((data) => {
        //    this.refresh();
        //});
        //this.countryDialog = false;
        //this.product = {};
    }
}
