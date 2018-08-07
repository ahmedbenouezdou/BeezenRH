import { Component } from '@angular/core';
import { smoothlyMenu } from 'app/app.helpers';
import { jQuery } from 'jquery/dist/jquery.js';

@Component({
    selector: 'topnavbar',
    templateUrl: 'topnavbar.component.html'
})
export class TopnavbarComponent {
    ngOnInit() {}
    toggleNavigation(): void {
        jQuery('body').toggleClass('mini-navbar');
        smoothlyMenu();
    }
    logout() {
        localStorage.clear();
        // location.href='http://to_login_page';
    }
}
