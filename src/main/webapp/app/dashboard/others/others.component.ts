import { Component, OnInit } from '@angular/core';
import { Login } from 'app/entities/login';

@Component({
    selector: 'app-others',
    templateUrl: './others.component.html'
})
export class OthersComponent implements OnInit {
    loginInfo: Login = {
        first_name: 'Andrew',
        last_name: 'Yang',
        avatar: 'ay.jpeg',
        title: 'Senior Developer'
    };
    constructor() {}

    ngOnInit() {}
}
