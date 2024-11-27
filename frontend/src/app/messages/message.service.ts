import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class MessageService {


  private baseUrl = environment.backendURL+'/messages';

  constructor(private http: HttpClient) {}

  /**
   * Récupère la liste de tous les messages
   * @returns Observable d'un tableau de messages
   */
  getMessages(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl + '/all');
  }


}
