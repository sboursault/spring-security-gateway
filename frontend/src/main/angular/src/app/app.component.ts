import { Component } from '@angular/core';

import { Router } from '@angular/router';
//import 'rxjs/add/operator/finally';
import { HttpClient } from '@angular/common/http';
import { AppService } from './service/app.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-ui';

  constructor(private app: AppService, private http: HttpClient, private router: Router) {
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

}
