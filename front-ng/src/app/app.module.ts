import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomePageComponent } from './modules/pages/welcome-page/welcome-page.component';
import { HeaderComponent } from './modules/pages/welcome-page/header/header.component';
import { MainBannerComponent } from './modules/pages/welcome-page/main-banner/main-banner.component';
import { NewsSectionComponent } from './modules/pages/welcome-page/news-section/news-section.component';
import { FooterComponent } from './modules/pages/welcome-page/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {MatDividerModule} from "@angular/material/divider";
import {MatDialogModule} from '@angular/material/dialog';
import { LoginDialogComponent } from './modules/pages/widgets/login-dialog/login-dialog.component';
import { RegistrationDialogComponent } from './modules/pages/widgets/registeration-dialog/registration-dialog.component';
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AuthInterceptorService} from "./intercepters/auth-interceptor.service";
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {HttpClientModule } from '@angular/common/http';
import { OauthButtonsComponent } from './modules/pages/widgets/oauth-buttons/oauth-buttons.component';
import { AboutPageComponent } from './modules/pages/about-page/about-page/about-page.component';
import { AboutContentComponent } from './modules/pages/about-page/about-page/about-content/about-content.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    HeaderComponent,
    MainBannerComponent,
    NewsSectionComponent,
    FooterComponent,
    LoginDialogComponent,
    RegistrationDialogComponent,
    OauthButtonsComponent,
    AboutPageComponent,
    AboutContentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatDividerModule,
    MatDialogModule,
    MatInputModule,
    ReactiveFormsModule,
    MatIconModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
