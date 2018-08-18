import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BeezenRhSharedModule } from 'app/shared';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import {
    CraComponent /* , dashboardState */,
    DashboardComponent,
    HomComponent,
    NavigationComponent,
    TopnavbarComponent
} from 'app/dashboard';
import { NavbarComponent } from 'app/layouts';
import { ActivityComponent } from 'app/dashboard/activity/activity.component';

@NgModule({
    schemas: [NO_ERRORS_SCHEMA],
    imports: [BeezenRhSharedModule, RouterModule /* RouterModule.forChild(dashboardState) */],
    declarations: [
        CraComponent,
        DashboardComponent,
        HomComponent,
        NavbarComponent,
        NavigationComponent,
        TopnavbarComponent,
        ActivityComponent
    ]
})
export class BeezenRhDashboardModule {}
