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

    getAllHopitaux() : Observable<Hopitaux[]> {
        return this.http.get<Hopitaux[]>('/api/hopitaux');
    }

    getHopitauxById(hopitalId:number): Observable<Hopitaux>{
        return this.http.get<Hopitaux>(`/api/hopitaux/${hopitalId}`);
    }

    rechercheHopital(rechercheHopital:RechercheHopital) : Observable<Hopitaux> {
        return this.http.get<Hopitaux>(`/api/hopitaux/${rechercheHopital.idSpecialisations}/${rechercheHopital.adresse}`);
    }
}