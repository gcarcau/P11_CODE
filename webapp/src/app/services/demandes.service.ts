import { Injectable } from "@angular/core";
import {Demandes} from "../models/demandes.models.js";
import { HttpClient } from '@angular/common/http';
import {Observable, map,switchMap} from 'rxjs';
@Injectable({
    providedIn : 'root'
})
export class DemandesService {

    constructor(private http:HttpClient){

    }
    demandes: Demandes[]= [];

    getDemandes() : Observable<Demandes[]> {
        return this.http.get<Demandes[]>('/api/demandes');
    }
}