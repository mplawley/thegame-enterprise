import { Injectable } from '@angular/core';
import { ModifierEntry, Modifiers } from '../data/Modifiers';
import { httpOptions} from '../data/httpOptions';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})

export class MeritsAndBuffsService {
  private updateMeritsAndBuffsUrl = "http://localhost:8080/modifiers/updateMeritsAndBuffsModifiers";

  // getMeritsAndBuffs(meritsAndBuffsId: string): Observable<any> {
  //   meritsAndBuffsId = meritsAndBuffsId.trim();
  //   const options = meritsAndBuffsId ? { params: new HttpParams().set('meritsAndBuffsId', meritsAndBuffsId) } : {};
  //   return this.http.get<ModifierEntry>(this.meritsAndBuffsUrl, options)
  //     .pipe(
  //       tap(meritsAndBuffsObject => this.log(`Fetched character merits and buffs for ${meritsAndBuffsObject.meritsAndBuffId} with meritsAndBuffId=${meritsAndBuffsId}`)),
  //       catchError(this.handleError('getMeritsAndBuffs', []))
  //     );
  // }

    /** PUT: update the characterSheet on the server. Returns the updated characterSheet upon success. */
  updateMeritsAndBuffs(meritsAndBuffs: Modifiers): Observable<Modifiers> {
    return this.http.put<Modifiers>(this.updateMeritsAndBuffsUrl, meritsAndBuffs, httpOptions)
      .pipe(
        catchError(this.handleError('updateMeritsAndBuffs', meritsAndBuffs))
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
