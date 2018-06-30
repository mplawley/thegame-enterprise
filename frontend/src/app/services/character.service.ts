import { Injectable } from '@angular/core';
import { CharacterSheet, CharacterSheetVitals, CharacterSheetDataObject } from '../data/characterSheet'
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class CharacterService {
  private getCharacterVitalsUrl = 'http://localhost:8080/vitals/getVitals'; //For mocking: 'api/CHARACTER_VITALS';
  private updateCharacterVitalsUrl = 'http://localhost:8080/vitals/saveVitals';
  private characterStatsUrl = 'api/BASE_STATS';
  private characterSkillsUrl = 'api/SKILLS';
  private characterSheetUrl = 'http://localhost:8080/characterSheet/getCharacterSheet';
  private updateCharacterSheetUrl = 'http://localhost:8080/characterSheet/updateCharacterSheet';

  getVitals(): Observable<any> {
    return this.http.get<CharacterSheetVitals>(this.getCharacterVitalsUrl)
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

  getCharacterSheet(characterId: string): Observable<any> {
    characterId = characterId.trim();
    const options = characterId ? { params: new HttpParams().set('characterId', characterId) } : {};
    return this.http.get<CharacterSheet>(this.characterSheetUrl, options)
      .pipe(
        tap(characterSheetObject => this.log(`Fetched character sheet for ${characterSheetObject.characterName} with characterId=${characterId}`)),
        catchError(this.handleError('getCharacterSheet', []))
      );
  }

    /** PUT: update the characterSheet on the server. Returns the updated hero upon success. */
  updateCharacterSheet(characterSheet: CharacterSheet): Observable<CharacterSheet> {
    return this.http.put<CharacterSheet>(this.updateCharacterSheetUrl, characterSheet, httpOptions)
      .pipe(
        catchError(this.handleError('updateCharacterSheet', characterSheet))
      );
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
}
