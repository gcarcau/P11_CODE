import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HopitauxComponent } from './hopitaux/hopitaux.component';
import { SpecialisationsComponent } from './specialisations/specialisations.component';
import { RechercheComponent } from './recherche/recherche.component';
import { DemandesComponent } from './demandes/demandes.component';

const routes: Routes = [
  {path : '',component:LandingPageComponent},
  {path : 'hopitaux',component:HopitauxComponent},
  {path : 'specialisations', component:SpecialisationsComponent},
  {path : 'recherche',component:RechercheComponent},
  {path : 'demandes',component:DemandesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
