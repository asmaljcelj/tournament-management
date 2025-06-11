import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel, Hotels } from '../pages/service/product.service';
import { Countries } from '../pages/service/country.service';
import {People, Person} from "../pages/service/person.service";

@Injectable({
  providedIn: 'root'
})
export class DataService {
    // private apiUrl = 'http://localhost:8080/api/';
  private apiUrl = 'https://tournament-crm-fdd7486c3631.herokuapp.com/';

  constructor(private http: HttpClient) { }

  getHotels(): Observable<Hotels> {
    console.log('calling');
    return this.http.get<Hotels>(this.apiUrl + 'hotel');
  }

  createHotel(hotel: Hotel): Observable<Hotel> {
    return this.http.post<Hotel>(this.apiUrl + 'hotel', hotel);
  }

  editHotel(hotel: Hotel): Observable<Hotel> {
    return this.http.put<Hotel>(this.apiUrl + 'hotel/' + hotel.id, hotel);
  }

  deleteHotel(hotel: Hotel): Observable<any> {
    console.log('deleteing');
    console.log(hotel);
    return this.http.delete(this.apiUrl + 'hotel/' + hotel.id);
  }

  getCountries1(): Observable<Countries> {
    console.log('countries GET');
    return this.http.get<Countries>(this.apiUrl + 'country');
  }

  getPeople(): Observable<People> {
      return this.http.get<People>(this.apiUrl + 'person');
  }

    editPerson(person: Person): Observable<Person> {
        return this.http.put<Person>(this.apiUrl + 'person/' + person.id, person);
    }

    createPerson(person: Person): Observable<Person> {
        return this.http.post<Person>(this.apiUrl + 'person', person);
    }
}
