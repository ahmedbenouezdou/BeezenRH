import { Routes } from '@angular/router';

import { homeRoute, craRoute, leaveRoute } from './';

const DASHBOARD_ROUTES = [homeRoute, craRoute, leaveRoute];

export const dashboardState: Routes = [
    {
        path: 'dashboard',
        component: DashboardComponent,
        children: DASHBOARD_ROUTES
    }
];
