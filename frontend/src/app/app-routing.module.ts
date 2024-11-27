import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MessageListComponent } from './messages/message-list/message-list.component';
import { MessageDetailComponent } from './messages/message-detail/message-detail.component';
import { PartnerListComponent } from './partners/partner-list/partner-list.component';
import { PartnerFormComponent } from './partners/partner-form/partner-form.component';

const routes: Routes = [
  { path: '', redirectTo: '/messages', pathMatch: 'full' },  // Redirige vers la liste des messages par défaut

  // Route pour la liste des messages
  { path: 'messages', component: MessageListComponent },

  // Route pour les détails d'un message (si vous souhaitez afficher un message spécifique)
  { path: 'messages/:id', component: MessageDetailComponent },

  // Route pour la gestion des partenaires
  { path: 'partners', component: PartnerListComponent },

  // Route pour le formulaire d'ajout/modification d'un partenaire
  { path: 'partners/add', component: PartnerFormComponent },

  // Route pour l'édition d'un partenaire (si nécessaire)
  { path: 'partners/edit/:id', component: PartnerFormComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Utilisation des routes importées
  exports: [RouterModule]
})
export class AppRoutingModule { }
