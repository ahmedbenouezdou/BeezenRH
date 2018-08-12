import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { HomComponent } from './home.component';

export const homeRoute: Route = {
    path: 'home',
    component: HomComponent,
    data: {
        authorities: []
    },
    canActivate: [UserRouteAccessService]
};
