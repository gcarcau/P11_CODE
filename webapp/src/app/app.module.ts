import { NgModule,LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import * as fr from '@angular/common/locales/fr'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HeaderComponent } from './header/header.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HopitauxComponent } from './hopitaux/hopitaux.component';
import { SpecialisationsComponent } from './specialisations/specialisations.component';
import { RechercheComponent } from './recherche/recherche.component';
import { DemandesComponent } from './demandes/demandes.component';
import { FooterComponent } from './footer/footer.component';
import { HopitalComponent } from './hopital/hopital.component';

import { registerLocaleData } from '@angular/common';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LandingPageComponent,
    HopitauxComponent,
    SpecialisationsComponent,
    RechercheComponent,
    DemandesComponent,
    FooterComponent,
    HopitalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue :  'fr-FR' }
     ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    registerLocaleData(fr.default);
  }

 }
