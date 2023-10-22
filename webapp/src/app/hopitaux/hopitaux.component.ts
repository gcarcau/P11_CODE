import { Component, OnInit, Input } from '@angular/core';
import { Hopitaux } from '../models/hopitaux.models';
import { HopitauxService } from '../services/hopitaux.services';
import { ActivatedRoute } from '@angular/router';
import { Observable, tap } from 'rxjs';

@Component({
  selector: 'app-hopitaux',
  templateUrl: './hopitaux.component.html',
  styleUrls: ['./hopitaux.component.scss']
})
export class HopitauxComponent implements OnInit {
  hopitaux$!: Observable<Hopitaux[]>;
  snaped!: boolean;
  buttonText!: string;
  constructor(private hopitauxService: HopitauxService,
    private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.buttonText = "Oh snaps!"
    this.snaped = false;
    this.hopitaux$ = this.hopitauxService.getAllHopitaux();
  }

  onItinairaire(adresse: string) {
    adresse = this.formateAdresse(adresse);
    window.open(`https://maps.google.com/maps?q=${adresse}`, '_blank');
  }

  formateAdresse(adresse:string = "") : string {
    adresse = adresse?.replaceAll(',','%20');
    adresse = adresse?.replaceAll(' ','%20');
    adresse = adresse?.replaceAll(';','%20');
    adresse = adresse?.replaceAll('?','%20');
    adresse = adresse?.replaceAll('&','%20');
    //adresse = adresse?.replaceAll('%20','');
    return adresse;
  }
}