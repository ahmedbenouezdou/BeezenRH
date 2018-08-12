import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { CraComponent } from './cra.component';

export const craRoute: Route = {
    path: 'cra',
    component: CraComponent,
    data: {
        authorities: []
    },
    canActivate: [UserRouteAccessService]
};