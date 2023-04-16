import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Clase } from '../models/clase';

@Injectable({
  providedIn: 'root',
})
export class ClaseService {
  //Declarando variables
  claseURL = environment.apiRestURL + '/Clase';
  constructor(private http: HttpClient) {}

  // Método lista de las clases
  public list(): Observable<Clase[]> {
    return this.http.get<Clase[]>(this.claseURL);
  }

  // Método detalles de las clases
  public detail(id: number): Observable<Clase> {
    return this.http.get<Clase>(this.claseURL + `/${id}`);
  }

  // Método clase
  public obtenerClase(id: string): Observable<any> {
    return this.http.get(this.claseURL + id);
  }

  // Método creación de clase
  public create(clase: Clase): Observable<any> {
    return this.http.post<any>(this.claseURL, clase);
  }

  // Método actualización de clase
  public update(id: number, clase: Clase): Observable<any> {
    return this.http.put<any>(this.claseURL + `/${id}`, clase);
  }

  // Método eliminación de clase
  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this.claseURL + `/${id}`);
  }
}

// Autor: Miguel Hernández
