import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { AppService } from './service/app.service';
import { XhrInterceptor } from './interceptor/xhr.interceptor';
import { WhiskyCardComponent } from './whisky-card/whisky-card.component';
import { WhiskyListComponent } from './whisky-list/whisky-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    WhiskyCardComponent,
    WhiskyListComponent
  ],
  imports: [
    RouterModule.forRoot([
      { path: '', pathMatch: 'full', redirectTo: 'home'},
      { path: 'home', component: HomeComponent},
      { path: 'login', component: LoginComponent}
    ]),
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AppService, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }



