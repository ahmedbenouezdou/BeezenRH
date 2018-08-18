import { Component, OnInit } from '@angular/core';

import { Principal } from 'app/core';
import { Session } from 'app/account/sessions/session.model';
import { SessionsService } from 'app/account/sessions/sessions.service';

@Component({
    selector: 'jhi-sessions',
    templateUrl: './sessions.component.html'
})
export class SessionsComponent implements OnInit {
    account: any;
    error: string;
    success: string;
    sessions: Session[];

    constructor(private sessionsService: SessionsService, private principal: Principal) {}

    ngOnInit() {
        this.sessionsService.findAll().subscribe(sessions => (this.sessions = sessions));

        this.principal.identity().then(account => {
            this.account = account;
        });
    }

    invalidate(series) {
        this.sessionsService.delete(encodeURIComponent(series)).subscribe(response => {
            if (response.status === 200) {
                this.error = null;
                this.success = 'OK';
                this.sessionsService.findAll().subscribe(sessions => (this.sessions = sessions));
            } else {
                this.success = null;
                this.error = 'ERROR';
            }
        });
    }
}
