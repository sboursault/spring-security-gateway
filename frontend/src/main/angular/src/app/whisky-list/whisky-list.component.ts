import { Component, OnInit } from '@angular/core';
import { AppService } from '../service/app.service';

@Component({
  selector: 'app-whisky-list',
  templateUrl: './whisky-list.component.html',
  styleUrls: ['./whisky-list.component.css']
})
export class WhiskyListComponent implements OnInit {

  whiskies: Array<Whisky> = [];

  constructor(private app: AppService) { }

  ngOnInit() {
    this.app.getWhiskies()
       .subscribe(response => this.whiskies = response);
  }

}
