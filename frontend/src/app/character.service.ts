import { Injectable } from '@angular/core';
import { CharacterSheet, CharacterSheetVitals, CharacterSheetDataObject } from './characterSheet'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from './message.service';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class CharacterService {
  private getCharacterVitalsUrl = 'http://localhost:8080/vitals/getVitals'; //For mocking: 'api/CHARACTER_VITALS';
  private updateCharacterVitalsUrl = 'http://localhost:8080/vitals/saveVitals';
  private characterStatsUrl = 'api/BASE_STATS';
  private characterSkillsUrl = 'api/SKILLS';
  private testSpringBootBackendUrl = 'http://localhost:8080/characterSheet/getCharacterSheet';

  getVitals(headers?: HttpHeaders | null): Observable<any> {
    const expandedHeaders = this.prepareHeader(headers);
    return this.http.get<CharacterSheetVitals>(this.getCharacterVitalsUrl, expandedHeaders)
      .pipe(
        tap(vitals => this.log('Fetched vitals')),
        catchError(this.handleError('getVitals', []))
      );
  }

  updateVitals(characterSheetVitals: CharacterSheetVitals): Observable<any> {
    return this.http.put(this.updateCharacterVitalsUrl, characterSheetVitals)
      .pipe(
        tap(_ => this.log(`updated character vitals with currentLife=${characterSheetVitals.currentLife}`)),
        catchError(this.handleError<any>('updateVitals'))
      );
  }

  getStats(): Observable<CharacterSheetDataObject[]> {
    return this.http.get<CharacterSheetDataObject[]>(this.characterStatsUrl)
      .pipe(
        tap(stats => this.log('Fetched stats')),
        catchError(this.handleError('getStats', []))
      );
  }

  getSkills(): Observable<CharacterSheetDataObject[]> {
    return this.http.get<CharacterSheetDataObject[]>(this.characterSkillsUrl)
      .pipe(
        tap(skills => this.log('Fetched skills')),
        catchError(this.handleError('getSkills', []))
      );
  }

  getSpringBootBackendRESTResponse(): Observable<any> {
    console.log("In character service's getSpringzBoot() response");
    return this.http.get<string>(this.testSpringBootBackendUrl) //was string[]
      .pipe(
        tap(string => this.log('Fetched Spring Boot Backend REST Response: ' + string)),
        catchError(this.handleError('getSpringBootBackendRESTResponse', []))
      );
      // return this.http.get<string>(this.testSpringBootBackendUrl);
  }

  constructor(
    private http: HttpClient,
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

  private prepareHeader(headers: HttpHeaders | null): object {
    headers = headers || new HttpHeaders();

    headers = headers.set('Content-Type', 'application/json');
    headers = headers.set('Accept', 'application/json');

    return {
        headers: headers
    }
}
}
