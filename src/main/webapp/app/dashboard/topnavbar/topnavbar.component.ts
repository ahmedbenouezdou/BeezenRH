import { Component, OnInit } from '@angular/core';
import { smoothlyMenu } from '../../app.helpers';
import { LoginService } from 'app/core/login/login.service';
import { Router } from '@angular/router';
declare var jQuery: any;
@Component({
    selector: 'jhi-topnavbar',
    templateUrl: 'topnavbar.component.html'
})
export class TopnavbarComponent implements OnInit {
    constructor(private loginService: LoginService, private router: Router) {}
    ngOnInit() {}
    toggleNavigation(): void {
        jQuery('body').toggleClass('mini-navbar');
        smoothlyMenu();
    }

    logout() {
        // localStorage.clear();
        this.loginService.logout();
        this.router.navigate(['']);
    }
}
