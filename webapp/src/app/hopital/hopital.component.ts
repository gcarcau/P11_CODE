import { Component, OnInit, Input } from '@angular/core';
import { Hopitaux } from '../models/hopitaux.models';
import { HopitauxService } from '../services/hopitaux.services';
import { ActivatedRoute } from '@angular/router';
import { Observable, tap } from 'rxjs';

@Component({
  selector: 'app-hopitaux',
  templateUrl: './hopital.component.html',
  styleUrls: ['./hopital.component.scss']
})
export class HopitalComponent implements OnInit {
  hopitaux$!: Observable<Hopitaux[]>;
    constructor(private hopitauxService: HopitauxService,
    private route: ActivatedRoute) { }
  ngOnInit(): void {
  
  }

  onItinairaire(adresse: string) {

  }
}