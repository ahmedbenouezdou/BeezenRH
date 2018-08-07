import './vendor.ts';

import { NgModule, Injector } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Ng2Webstorage } from 'ngx-webstorage';
import { JhiEventManager } from 'ng-jhipster';

import { AuthExpiredInterceptor } from 'app/blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from 'app/blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from 'app/blocks/interceptor/notification.interceptor';
import { ProjetRhSharedModule } from 'app/shared';
import { ProjetRhCoreModule } from 'app/core';
import { ProjetRhAppRoutingModule } from 'app/app-routing.module';
import { ProjetRhHomeModule } from 'app/home/home.module';
import { ProjetRhAccountModule } from 'app/account/account.module';
import { ProjetRhEntityModule } from 'app/entities/entity.module';
import { StateStorageService } from 'app/core/auth/state-storage.service';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent, NavbarComponent, FooterComponent, PageRibbonComponent, ActiveMenuDirective, ErrorComponent } from 'app/layouts';
import { DashboardComponent } from 'app/dashboard/dashboard.component';
import { NavigationComponent } from 'app/dashboard/navigation/navigation.component';
import { LoginComponent } from 'app/login/login.component';
import { TopnavbarComponent } from 'app/dashboard/topnavbar/topnavbar.component';

@NgModule({
    imports: [
        BrowserModule,
        ProjetRhAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-' }),
        ProjetRhSharedModule,
        ProjetRhCoreModule,
        ProjetRhHomeModule,
        ProjetRhAccountModule,
        ProjetRhEntityModule
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        LoginComponent,
        DashboardComponent,
        NavigationComponent,
        TopnavbarComponent,
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
export class ProjetRhAppModule {}
