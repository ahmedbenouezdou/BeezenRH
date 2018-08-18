import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BeezenRhSharedModule } from 'app/shared';
import { HOME_ROUTE, HomeComponent } from 'app/home';

@NgModule({
    imports: [BeezenRhSharedModule, RouterModule.forChild([HOME_ROUTE])],
    declarations: [HomeComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BeezenRhHomeModule {}
