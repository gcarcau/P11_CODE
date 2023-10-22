import { Component, OnInit, Input } from '@angular/core';
import { Demandes } from '../models/demandes.models';
import { DemandesService } from '../services/demandes.service';
import { ActivatedRoute } from '@angular/router';
import { Observable, tap } from 'rxjs';

@Component({
  selector: 'app-demandes',
  templateUrl: './demandes.component.html',
  styleUrls: ['./demandes.component.scss']
})
export class DemandesComponent implements OnInit {
  demandes$!: Observable<Demandes[]>;
  deleteDemande$! :Observable<any>;
  
  constructor(private demandesService: DemandesService,
    private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.demandes$ = this.demandesService.getDemandes();
  }
}