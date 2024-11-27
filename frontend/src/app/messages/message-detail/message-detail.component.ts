import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-message-detail',
  templateUrl: './message-detail.component.html'
})
export class MessageDetailComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}
}