import { Routes } from '@angular/router';

import { homeRoute, craRoute, leaveRoute, DashboardComponent, HomComponent, LeaveComponent, CraComponent } from './';
import { OthersComponent } from 'app/dashboard/others/others.component';
import { ActivityComponent } from 'app/dashboard/activity/activity.component';

const DASHBOARD_ROUTES = [
    homeRoute,
    craRoute,
    leaveRoute,
    {
        path: 'others',
        component: OthersComponent
    },
    {
        path: 'activity',
        component: ActivityComponent
    }
];

export const dashboardState = {
    path: 'dashboard',
    /*   data: {
        authorities: ['ROLE_ADMIN']
    },
    canActivate: [UserRouteAccessService], */
    component: DashboardComponent,
    children: DASHBOARD_ROUTES
};
