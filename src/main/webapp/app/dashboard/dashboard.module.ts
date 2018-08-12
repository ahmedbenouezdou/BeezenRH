import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BeezenRhSharedModule } from 'app/shared';

import { CraComponent, dashboardState, DashboardComponent, HomComponent } from './';

@NgModule({
    imports: [BeezenRhSharedModule, RouterModule.forChild(dashboardState)],
    declarations: [CraComponent, DashboardComponent, HomComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BeezenRhDashboardModule {}
