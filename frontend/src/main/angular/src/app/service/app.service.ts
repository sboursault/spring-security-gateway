import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  authenticated = false;

  constructor(private http: HttpClient) {
  }

  authenticate(credentials, callback) {
    const headers = new HttpHeaders(
      credentials ? { authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password) } : {}
    );
    this.http.get('user', {headers: headers})
      .subscribe(response => {
        if (response['name']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
      });
  }

  sayHello(): Observable<string> {
    return this.http.get(`/api/hello-world`, {responseType: 'text'});
  }

  getBanner(): Observable<Banner> {
    return this.http
      .get<Banner>(`http://localhost:8095/v1/banners/001`);
  }

  getWhiskies(): Observable<Array<Whisky>> {
    return this.http
      .get<Array<Whisky>>(`http://localhost:8080/whiskies`);
  }

}
