import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Power } from './power';
import { MessageService } from './message.service';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class PowerService {
  private powersUrl = 'api/powers';
  
  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  getPowers(): Observable<Power[]> {
    return this.http.get<Power[]>(this.powersUrl)
      .pipe(
        tap(power => this.log('Fetched powers')),
        catchError(this.handleError('getPowers', []))
      );
  }

  /** GET power by id. Return `undefined` when id not found */
  getPower<Data>(powerId: number): Observable<Power> {
    const url = `${this.powersUrl}/?powerId=${powerId}`;
    return this.http.get<Power[]>(url)
      .pipe(
        map(powers => powers[0]), //returns a {0|1} element array
        tap(p => {
          const outcome = p ? `fetched` : `did not find`;
          this.log(`${outcome} powerId=${powerId}`);
        }),
        catchError(this.handleError<Power>(`getPower powerId=${powerId}`))
      );
  }

  /** PUT: update the power on the server */
  updatePower(power: Power): Observable<any> {
    return this.http.put(this.powersUrl, power, httpOptions)
      .pipe(
        tap ( _ => this.log(`updated power with powerId=${power.powerId}`)),
        catchError(this.handleError<any>('updatePower'))
      );
  }

  /** POST: add a new power to the server */
  addPower (power: Power): Observable<Power> {
    return this.http.post<Power>(this.powersUrl, power, httpOptions)
      .pipe(
        tap((power: Power) => this.log(`added power w/ id=${power.powerId}`)),
        catchError(this.handleError<Power>('addPower'))
      );
  }

  /** DELETE: delete the hero from the server */
  deletePower (power: Power | number): Observable<Power> {
    const id = typeof power === 'number' ? power : power.powerId;
    const url = `${this.powersUrl}/${id}`;

    return this.http.delete<Power>(url, httpOptions).pipe(
      tap( _ => this.log(`deleted power id=${id}`)),
      catchError(this.handleError<Power>('deletePower'))
    );
  }

  private log(message: string) {
    this.messageService.add("PowerService: " + message)
  }

  /**
   * Handle http operation that failed and let the app continue
   * @param operation name of the operation that failed
   * @param result optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(error); //TODO: log to remote logging infrastrcture instead of console
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T); //Let the app keep running by returning an empty result
    }
  }
}

