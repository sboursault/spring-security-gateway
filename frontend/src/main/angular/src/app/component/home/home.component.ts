import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppService } from '../../service/app.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = 'Demo';
  banner: Banner = { html: '' };
  greeting = {};

  constructor(private app: AppService, private http: HttpClient) {
    
  }

  authenticated() { return this.app.authenticated; }

  ngOnInit() {
    this.http
      .get('resource')
      .subscribe(data => this.greeting = data);

    this.banner.html = 'loading...';
    this.app.getBanner()
      .subscribe(data => this.banner = data);
  }

}
