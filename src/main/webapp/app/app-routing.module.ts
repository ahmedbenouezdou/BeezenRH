import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { errorRoute, navbarRoute } from 'app/layouts';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';
import { LoginComponent } from 'app/login/login.component';
import { DashboardComponent } from 'app/dashboard/dashboard.component';

const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                /*   ...LAYOUT_ROUTES,
                {
                    path: 'admin',
                    loadChildren: './admin/admin.module#ProjetRhAdminModule'
                } */
                { path: 'login', component: LoginComponent },
                { path: '', component: DashboardComponent }
            ],
            { useHash: true, enableTracing: DEBUG_INFO_ENABLED }
        )
    ],
    exports: [RouterModule]
})
export class ProjetRhAppRoutingModule {}
