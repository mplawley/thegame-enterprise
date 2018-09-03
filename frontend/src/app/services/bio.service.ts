import { Injectable } from '@angular/core';
import { Bio } from '../data/bio';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BioService {
  bioUpdateUrl = "http://localhost:8080/bio/updateBio";
  getBioUrl = "http://localhost:8080/bio/getBio";

  updateBio(bio: Bio): Observable<Bio> {
    return this.http.put<Bio>(this.bioUpdateUrl, bio, httpOptions)
      .pipe(
        catchError(this.handleError('updateBio', bio))
      );
  }

  getBio(bioId: string): Observable<any> {
    bioId = bioId.trim();
    const options = bioId ? { params: new HttpParams().set('bioId', bioId)} : {};
    return this.http.get<Bio>(this.getBioUrl, options)
      .pipe(
        tap(bioObject => this.log('Fetched bio')),
        catchError(this.handleError('getBio', []))
      );
  }

  constructor(private http: HttpClient,
    private messageService: MessageService) { }

  private log(message: string) {
    this.messageService.add('BioService: ' + message);
  }

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
