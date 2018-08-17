import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';
import { LoginComponent } from 'app/login/login.component';
import { DashboardComponent, HomComponent, CraComponent, LeaveComponent } from 'app/dashboard';
import { RegisterComponent } from 'app/register/register.component';
import { dashboardState } from 'app/dashboard/dashboard.route';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { OthersComponent } from 'app/dashboard/others/others.component';

@NgModule({
    imports: [
        RouterModule.forRoot([dashboardState, { path: '', component: LoginComponent }, { path: 'regist', component: RegisterComponent }], {
            useHash: true,
            enableTracing: DEBUG_INFO_ENABLED
        })
    ],
    exports: [RouterModule]
})
export class BeezenRhAppRoutingModule {}
