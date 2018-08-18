import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { LeaveComponent } from 'app/dashboard/leave/leave.component';

export const leaveRoute: Route = {
    path: 'leave',
    component: LeaveComponent
    /*    data: {
        authorities: []
    },
    canActivate: [UserRouteAccessService] */
};
