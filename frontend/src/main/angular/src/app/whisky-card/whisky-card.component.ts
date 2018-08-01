import { Component, OnInit, Input } from '@angular/core';
import { AppService } from '../service/app.service';

@Component({
  selector: 'app-whisky-card',
  templateUrl: './whisky-card.component.html',
  styleUrls: ['./whisky-card.component.css']
})
export class WhiskyCardComponent implements OnInit {

  @Input() whisky: Whisky;

  constructor(private app: AppService) { }

  ngOnInit() {
  }

}
