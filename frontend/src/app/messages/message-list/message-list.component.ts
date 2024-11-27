import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MessageService } from '../message.service';
import { MessageDetailComponent } from '../message-detail/message-detail.component';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html'
})
export class MessageListComponent implements OnInit {
  messages: any[] = [];
  displayedColumns: string[] = ['id', 'messageBody', 'timestamp', 'actions'];

  constructor(private messageService: MessageService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.messageService.getMessages().subscribe((data) => (this.messages = data));
  }

  viewDetails(message: any): void {
    this.dialog.open(MessageDetailComponent, {
      width: '400px',
      data: message
    });
  }
}
