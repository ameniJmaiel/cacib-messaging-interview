import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PartnerService } from '../partner.service';
import { PartnerFormComponent } from '../partner-form/partner-form.component';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-partner-list',
  templateUrl: './partner-list.component.html'
})
export class PartnerListComponent implements OnInit {
  partners:any[]=[]; 
  displayedColumns: string[] = ['alias', 'type', 'direction', 'application', 'proceedFlowType', 'description', 'actions'];

  constructor(private partnerService: PartnerService, private dialog: MatDialog,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadPartners();
  }

  /**
   * Charge la liste des partenaires depuis le service
   */
  loadPartners(): void {
      this.partnerService.getPartners().subscribe({
        next: (data) => {
          this.partners = data;
        },
    error: (err) => {
        this.cdr.detectChanges();
         console.error('Erreur lors du chargement des partenaires', err);
       }
      });
  }

  /**
   * Supprime un partenaire
   * @param id Identifiant du partenaire à supprimer
   */
  deletePartner(id: number): any {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce partenaire ?')) {
      this.partnerService.deletePartner(id).subscribe({
        next: () => {
          this.partners = this.partners.filter((partner) => partner.id !== id);
          console.log('Partenaire supprimé avec succès.');
        },
        error: (err) => {
          console.error('Erreur lors de la suppression du partenaire', err);
        }
      });
    }
  }

  /**
   * Ouvre le formulaire pour ajouter un partenaire
   */
  addPartner(): void {
    const dialogRef = this.dialog.open(PartnerFormComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        // Si un nouveau partenaire a été ajouté, rafraîchir la liste
        this.loadPartners();
      }
    });
  }
}
