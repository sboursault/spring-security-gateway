import { Component } from '@angular/core';

import { Router } from '@angular/router';
//import 'rxjs/add/operator/finally';
import { HttpClient } from '@angular/common/http';
import { Http } from '@angular/http';
import { AppService } from './service/app.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-ui';
  result = '';

  constructor(private app: AppService, private httpClient: HttpClient, private http: Http, private router: Router) {
    this.app.authenticate(undefined, undefined);
  }

  logout() {
    // TODO to implement  
    /*this.httpClient.post('logout', {}).finally(() => {
        //this.app.authenticated = false;
        this.router.navigateByUrl('/login');
    }).subscribe();
    */
    // finally from rxjs ?? and then subscribe ???
  }

  private sayHello(): void {
    this.result = 'loading...';
    // TODO this seems to be an old http api
    this.http.get(`/api/hello-world`).subscribe(response => this.result = response.text());
  }
}
