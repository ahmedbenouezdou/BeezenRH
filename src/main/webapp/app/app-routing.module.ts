import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
/* import { errorRoute, navbarRoute } from './layouts'; */
import { DEBUG_INFO_ENABLED } from 'app/app.constants';
import { LoginComponent } from 'app/login/login.component';
import { DashboardComponent, HomComponent, CraComponent, LeaveComponent } from 'app/dashboard';
import { RegisterComponent } from 'app/register/register.component';
import { dashboardState } from 'app/dashboard/dashboard.route';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { OthersComponent } from 'app/dashboard/others/others.component';
/* import { DashboardComponent } from 'app/dashboard/dashboard.component';
import { RegisterComponent } from 'app/register/register.component'; */
// //const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                dashboardState,

                //// ...LAYOUT_ROUTES,
                { path: '', component: LoginComponent },
                /*     { path: 'dashboard', component: DashboardComponent }, */
                { path: 'regist', component: RegisterComponent }
            ],
            { useHash: true, enableTracing: DEBUG_INFO_ENABLED }
        )
    ],
    exports: [RouterModule]
})
export class BeezenRhAppRoutingModule {}
