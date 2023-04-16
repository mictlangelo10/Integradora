import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Clientes } from '../models/clientes';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  // Declarando Variables
  clienteURL=environment.apiRestURL+'/Cliente';
  constructor(private httpClient:HttpClient) { }

  // Método para obtener clientes
  public list():Observable<Clientes[]>{
    return this.httpClient.get<Clientes[]>(this.clienteURL);
  }

  // Método para obtener detalles de los clientes
  public detail(id: number):Observable<Clientes>{
    return this.httpClient.get<Clientes>(this.clienteURL + `/${id}`);
  }

  // Método para obtener clientes por medio de su nombre
  public listByNombreClase(nombreClase: String):Observable<Clientes[]>{
    return this.httpClient.get<Clientes[]>(this.clienteURL+ `/NombreClase/${nombreClase}`);
  }

  // Método para agregar clientes
  public save(cliente:Clientes):Observable<any>{
    return this.httpClient.post<any>(this.clienteURL,cliente);
  }

  //  Método para actualizar clientes
  public update(id: number,cliente:Clientes):Observable<any>{
    return this.httpClient.put<any>(this.clienteURL+`/${id}`,cliente);
  }

  // Método para eliminar clientes
  public delete(id: number):Observable<any>{
    return this.httpClient.delete<any>(this.clienteURL+`/${id}`);
  }
  
}

// Autor: Miguel Hernández
