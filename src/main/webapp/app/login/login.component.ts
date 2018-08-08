import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../../node_modules/@angular/router';

@Component({
    selector: 'jhi-login',
    templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
    constructor(private router: Router) {}

    ngOnInit() {}

    public login() {
        console.log('login OK !! ');
        this.router.navigate(['dashboard']);
    }
}
