import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class PartnerService {
  private baseUrl = environment.backendURL+'/partners';

  constructor(private http: HttpClient) {}

  /**
   * Récupère la liste de tous les partenaires
   * @returns Observable d'un tableau de partenaires
   */
  getPartners(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl+'/all');
  }

  /**
   * Supprime un partenaire en fonction de son ID
   * @param id Identifiant du partenaire à supprimer
   * @returns Observable void
   */
  deletePartner(id: number): Observable<string> {
    return this.http.delete<string>(`${this.baseUrl}/${id}`);
  }

  /**
   * Ajoute un nouveau partenaire
   * @param partner Objet représentant le partenaire à ajouter
   * @returns Observable du partenaire ajouté
   */
  addPartner(partner: any): Observable<any> {
    return this.http.post<any>(this.baseUrl + '/create', partner);
  }

}
