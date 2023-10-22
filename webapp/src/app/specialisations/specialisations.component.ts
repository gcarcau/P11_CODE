import { Component, OnInit, Input } from '@angular/core';
import { Specialisations } from '../models/specialisations.models';
import { SpecialisationsService } from '../services/specialisations.services';
import { ActivatedRoute } from '@angular/router';
import { Observable, tap } from 'rxjs';
@Component({
  selector: 'app-specialisations',
  templateUrl: './specialisations.component.html',
  styleUrls: ['./specialisations.component.scss']
})
export class SpecialisationsComponent implements OnInit {
  specialisations$!: Observable<Specialisations[]>;
  constructor(private specialisationsService: SpecialisationsService,
    private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.specialisations$ = this.specialisationsService.getAllSpecialisations();
  }

  onItinairaire(adresse: string) {

  }
}