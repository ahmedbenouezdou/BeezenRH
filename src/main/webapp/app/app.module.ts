import './vendor.ts';

import { NgModule, Injector } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { Ng2Webstorage } from 'ngx-webstorage';
import { JhiEventManager } from 'ng-jhipster';

import { AuthExpiredInterceptor } from './blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from './blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from './blocks/interceptor/notification.interceptor';
import { BeezenRhSharedModule } from 'app/shared';
import { BeezenRhCoreModule } from 'app/core';
import { BeezenRhAppRoutingModule } from './app-routing.module';
import { BeezenRhHomeModule } from './home/home.module';
import { BeezenRhAccountModule } from './account/account.module';
import { BeezenRhEntityModule } from './entities/entity.module';
import { StateStorageService } from 'app/core/auth/state-storage.service';
import { JhiMainComponent, NavbarComponent, FooterComponent, PageRibbonComponent, ActiveMenuDirective, ErrorComponent } from './layouts';
import { LoginComponent } from 'app/login/login.component';
import { RegisterComponent } from 'app/register/register.component';
import { HomeComponent } from 'app/home';
import { BeezenRhDashboardModule } from 'app/dashboard/dashboard.module';

@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        BeezenRhAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-' }),
        BeezenRhSharedModule,
        BeezenRhCoreModule,
        BeezenRhHomeModule,
        BeezenRhAccountModule,
        BeezenRhEntityModule,
        BeezenRhDashboardModule
    ],
    declarations: [
        JhiMainComponent,
        LoginComponent,
        RegisterComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthExpiredInterceptor,
            multi: true,
            deps: [StateStorageService, Injector]
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorHandlerInterceptor,
            multi: true,
            deps: [JhiEventManager]
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: NotificationInterceptor,
            multi: true,
            deps: [Injector]
        }
    ],
    bootstrap: [JhiMainComponent]
})
export class BeezenRhAppModule {}
