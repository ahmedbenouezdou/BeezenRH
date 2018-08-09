import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../../node_modules/@angular/router';

@Component({
    selector: 'jhi-register',
    templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {
    constructor(private router: Router) {}

    ngOnInit() {}

    public register() {
        console.log('register OK !! ');
        this.router.navigate(['dashboard']);
    }
}
