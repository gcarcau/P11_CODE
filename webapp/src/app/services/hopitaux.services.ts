import { Injectable } from "@angular/core";
import {Hopitaux} from "../models/hopitaux.models.js";
import { HttpClient } from '@angular/common/http';
import {Observable, map,switchMap} from 'rxjs';
import { RechercheHopital } from "../models/recherchehopital.models.js";
@Injectable({
    providedIn : 'root'
})
export class HopitauxService {
    
    constructor(private http:HttpClient){

    }
    hopitaux: Hopitaux[]= [];
    apiKey:string = "almaisthebest";
    getAllHopitaux() : Observable<Hopitaux[]> {
        return this.http.get<Hopitaux[]>('/api/hopitaux');
    }

    getHopitauxById(hopitalId:number): Observable<Hopitaux>{
        return this.http.get<Hopitaux>(`/api/hopitaux/${hopitalId}`);
    }

    rechercheHopital(rechercheHopital:RechercheHopital) : Observable<Hopitaux> {
        return this.http.get<Hopitaux>(`/api/hopitaux/idspec=${rechercheHopital.idSpecialisations}&adresse=${rechercheHopital.adresse}&apikey=${this.apiKey}`);
    }

    reserveUnHopital(hopitalId:number, reserver: 'book' | 'unBook'): Observable<Hopitaux> {
        return this.http.put<Hopitaux>(`/api/hopitaux/id=${hopitalId}&book=${(reserver === 'book' ? 1 : 0)}&apikey=${this.apiKey}`,'')
    }
    
}