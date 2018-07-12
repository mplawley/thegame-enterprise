import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Inventory } from '../data/inventorySheet';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  private inventoryUrl = 'http://localhost:8080/inventory/getInventory';
  private updateInventoryUrl = 'http://localhost:8080/inventory/updateInventory';

  getInventory(inventoryId: string): Observable<any> {
    inventoryId = inventoryId.trim();
    const options = inventoryId ? { params: new HttpParams().set('inventoryId', inventoryId) } : {};
    return this.http.get<Inventory>(this.inventoryUrl, options)
      .pipe(
        tap(inventoryObject => this.log(`Fetched inventory with inventoryId=${inventoryId}`)),
        catchError(this.handleError('getInventory', []))
      );
  }

  /** PUT: update the inventory on the server. Returns the updated inventory upon success. */
  updateInventory(inventory: Inventory): Observable<Inventory> {
    return this.http.put<Inventory>(this.updateInventoryUrl, inventory, httpOptions)
      .pipe(
        catchError(this.handleError('updateInventory', inventory))
      );
  }
  
  constructor(private http: HttpClient,
    private messageService: MessageService) { }

  private log(message: string) {
    this.messageService.add('CharacterService: ' + message);
  }

  /**
 * Handle Http operation that failed and let the app continue.
 * @param operation name of the operation that failed
 * @param result optional value to return as the observable result
 */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
