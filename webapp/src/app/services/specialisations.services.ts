import { Injectable } from "@angular/core";
import { HttpClient,HttpHeaders } from '@angular/common/http';
import {Observable, map,switchMap} from 'rxjs';
import { Specialisations } from "../models/specialisations.models.js";

const optionRequete = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*'
    })
  };
@Injectable({
    providedIn : 'root'
})
export class SpecialisationsService {

    constructor(private http:HttpClient){

    }
    getAllSpecialisations() : Observable<Specialisations[]> {
        return this.http.get<Specialisations[]>('/api/specialisations',optionRequete);
    }
}