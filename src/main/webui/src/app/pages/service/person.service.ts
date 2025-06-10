import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {DataService} from "../../services/data.service";
import {Country} from "./country.service";

export interface People {
    persons?: Person[];
}

export interface Person {
    id?: number;
    first_name?: string;
    last_name?: string;
    country?: Country;
    user_id?: string;
    external_id?: string;
}

@Injectable()
export class PersonService {

    constructor(private http: HttpClient, private dataService: DataService) {}

    getPeople() {
        return this.dataService.getPeople();
    }

    savePerson(person: Person) {
        if (person.id) {
            return this.dataService.editPerson(person)
        } else {
            return this.dataService.createPerson(person);
        }
    }
}
