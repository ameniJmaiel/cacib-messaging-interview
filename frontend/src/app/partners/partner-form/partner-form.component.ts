import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PartnerService } from '../partner.service';

@Component({
  selector: 'app-partner-form',
  templateUrl: './partner-form.component.html'
})
export class PartnerFormComponent {
  partnerForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private partnerService: PartnerService,
    private dialogRef: MatDialogRef<PartnerFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    // Initialisation du formulaire
    this.partnerForm = this.fb.group({
      alias: ['', Validators.required],
      type: ['', Validators.required],
      direction: ['', Validators.required],
      application: [''],
      proceedFlowType: ['', Validators.required],
      description: ['']
    });
  }

  /**
   * Fonction appelée lors de la soumission du formulaire
   */
  onSubmit(): void {
    if (this.partnerForm.valid) {
      const partnerData = this.partnerForm.value;
      this.partnerService.addPartner(partnerData).subscribe({
        next: (newPartner) => {
          console.log('Partenaire ajouté avec succès', newPartner);
          this.dialogRef.close(newPartner);
        },
        error: (err) => {
          console.error('Erreur lors de l\'ajout du partenaire', err);
        }
      });
    }
  }
}
