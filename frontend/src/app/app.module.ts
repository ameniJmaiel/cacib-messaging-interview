import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms'; // Pour les formulaires réactifs
import { AppComponent } from './app.component'; // Composant principal
import { MatTableModule } from '@angular/material/table'; // Module de table pour la liste des messages et partenaires
import { MatDialogModule } from '@angular/material/dialog'; // Module de dialogue (popin) pour les détails des messages
import { MatInputModule } from '@angular/material/input'; // Module pour les champs de texte
import { MatFormFieldModule } from '@angular/material/form-field'; // Module pour les champs de formulaire
import { MatSelectModule } from '@angular/material/select'; // Module pour les menus déroulants
import { PartnerListComponent } from './partners/partner-list/partner-list.component';
import { PartnerFormComponent } from './partners/partner-form/partner-form.component';
import { MessageListComponent } from './messages/message-list/message-list.component';
import { MessageDetailComponent } from './messages/message-detail/message-detail.component';
import { PartnerService } from './partners/partner.service';
import { MessageService } from './messages/message.service';
import { MatToolbarModule } from '@angular/material/toolbar'; // Import du module MatToolbarModule
import { MatButtonModule } from '@angular/material/button'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // Nécessaire pour les animations
import { AppRoutingModule } from './app-routing.module';
import { MatTabsModule } from '@angular/material/tabs';


@NgModule({
  declarations: [
    PartnerListComponent,
    PartnerFormComponent,
    MessageListComponent,
    MessageDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,  // Permet l'accès aux API REST
    ReactiveFormsModule, // Support pour les formulaires réactifs
    MatTableModule, // Pour afficher les données dans une table
    MatDialogModule, // Pour afficher les dialogues modaux (popins)
    MatButtonModule, // Pour les boutons
    MatInputModule, // Pour les champs de saisie
    MatFormFieldModule, // Pour les champs de formulaire
    MatSelectModule, // Pour les menus déroulants (select)
    BrowserAnimationsModule, // Assurez-vous d'importer ce module pour que Angular Material fonctionne
    MatToolbarModule,         // Ajout du module MatToolbarModule
    MatButtonModule,           // Ajout de MatButtonModule si vous utilisez des boutons Angular Material
    MatTabsModule
  ],

  providers: [
    PartnerService,  // Service pour les partenaires
    MessageService   // Service pour les messages
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
