import './vendor.ts';
/*
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
        LeaveComponent,
        dashboardState,
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
 */
import './vendor.ts';

import { NgModule, Injector } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Ng2Webstorage } from 'ngx-webstorage';
import { JhiEventManager } from 'ng-jhipster';

import { AuthExpiredInterceptor } from 'app/blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from 'app/blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from 'app/blocks/interceptor/notification.interceptor';
import { BeezenRhSharedModule } from 'app/shared';
import { BeezenRhCoreModule } from 'app/core';
import { BeezenRhAppRoutingModule } from 'app/app-routing.module';
import { BeezenRhHomeModule } from 'app/home/home.module';
import { BeezenRhAccountModule } from 'app/account/account.module';
import { BeezenRhEntityModule } from 'app/entities/entity.module';
import { StateStorageService } from 'app/core/auth/state-storage.service';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent, FooterComponent, PageRibbonComponent, ActiveMenuDirective, ErrorComponent } from 'app/layouts';
//import { NavigationComponent } from 'app/dashboard/navigation/navigation.component';
//import { TopnavbarComponent } from 'app/dashboard/topnavbar/topnavbar.component';
import { DashboardComponent } from 'app/dashboard/dashboard.component';
import { LoginComponent } from 'app/login/login.component';
import { RegisterComponent } from 'app/register/register.component';
//import { HomeComponent } from 'app/home';
import { OthersComponent } from 'app/dashboard/others/others.component';
//import { HomComponent } from 'app/dashboard/home/home.component';
//import { ActivityComponent } from 'app/dashboard/activity/activity.component';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { LeaveComponent } from 'app/dashboard';
import { APP_BASE_HREF } from '@angular/common';
import { BeezenRhDashboardModule } from 'app/dashboard/dashboard.module';
@NgModule({
    imports: [
        BrowserModule,
        BeezenRhAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-' }),
        BeezenRhSharedModule,
        BeezenRhCoreModule,
        BeezenRhHomeModule,
        BeezenRhAccountModule,
        BeezenRhEntityModule,
        BeezenRhDashboardModule
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        // ActivityComponent,
        //  HomComponent,
        LeaveComponent,
        OthersComponent,
        JhiMainComponent,
        //  NavigationComponent,
        // TopnavbarComponent,
        LoginComponent,
        RegisterComponent,
        // NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        NgbActiveModal,
        { provide: APP_BASE_HREF, useValue: '/' },
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
