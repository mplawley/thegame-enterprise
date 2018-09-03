import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

export const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };