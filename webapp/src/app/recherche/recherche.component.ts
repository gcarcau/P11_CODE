import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map, tap } from 'rxjs';
import { RechercheHopital } from '../models/recherchehopital.models';
import { Hopitaux } from '../models/hopitaux.models';
import { SpecialisationsService } from '../services/specialisations.services';
import { HopitauxService } from '../services/hopitaux.services';
import { Specialisations } from '../models/specialisations.models';


@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.scss']
})
export class RechercheComponent implements OnInit {
  specialisations$!: Observable<Specialisations[]>;
  rechercheForm!: FormGroup;
  hopital$!: Observable<Hopitaux>;
  urlRegex!: RegExp;
  booked:boolean = false;
  buttonText:string='Réservez un lit';
  geoloc!:String;
  constructor(private formBuilder: FormBuilder,
    private hopitauxService: HopitauxService,
    private router: Router,
    private specialisationsService: SpecialisationsService) { }

  ngOnInit(): void {
    this.specialisations$ = this.specialisationsService.getAllSpecialisations();
    this.rechercheForm = this.formBuilder.group({
      adresse: [null, Validators.required],
      idSpecialisations: [null, Validators.required]
    }, {
      updateOn: 'blur'
    });

    
  }

  onSubmitForm() {
    this.rechercheForm.value.adresse = this.formateAdresse(this.rechercheForm.value.adresse);
    this.hopital$ = this.hopitauxService.rechercheHopital(this.rechercheForm.value);
  }

  onItinairaire(localisation: string): void {
    localisation = this.formateAdresse(localisation);
    window.open(`https://maps.google.com/maps?q=${localisation}`, '_blank');
  }

  formateAdresse(adresse: string = ""): string {
    adresse = adresse?.replaceAll(',', '+');
    adresse = adresse?.replaceAll(' ', '+');
    adresse = adresse?.replaceAll(';', '+');
    adresse = adresse?.replaceAll('?', '+');
    adresse = adresse?.replaceAll('&', '+');
    //adresse = adresse?.replaceAll('%20','');
    return adresse;
  }
  reserverUnLit(idHopital:number) {
    console.log(this.booked,idHopital);
    this.hopital$ = this.hopitauxService.reserveUnHopital(idHopital,(this.booked ? "unBook" : "book")).pipe(
      tap(() => {
        this.booked = !this.booked;
        this.buttonText=this.booked ? 'Annulez votre réservation' : 'Réservez un lit'
      })
    );
  }
}
