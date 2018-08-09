import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { errorRoute, navbarRoute } from './layouts';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';
import { LoginComponent } from 'app/login/login.component';
import { DashboardComponent } from 'app/dashboard/dashboard.component';
import { RegisterComponent } from 'app/register/register.component';

import { OthersComponent } from 'app/dashboard/others/others.component';
import { HomComponent } from 'app/dashboard/home/home.component';
//const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                /*    ...LAYOUT_ROUTES,
                {
                    path: 'admin',
                    loadChildren: './admin/admin.module#BeezenRhAdminModule'
                } */
                { path: '', component: LoginComponent },
                {
                    path: 'dashboard',
                    component: DashboardComponent,
                    children: [
                        {
                            path: 'hom',
                            component: HomComponent
                        },
                        {
                            path: 'others',
                            component: OthersComponent
                        }
                    ]
                },
                { path: 'regist', component: RegisterComponent }
            ],
            { useHash: true, enableTracing: DEBUG_INFO_ENABLED }
        )
    ],
    exports: [RouterModule]
})
export class BeezenRhAppRoutingModule {}
