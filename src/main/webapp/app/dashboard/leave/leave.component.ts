/**
 * Created by andrew.yang on 5/18/2017.
 */
import { OnInit, Component } from '@angular/core';
import { Login } from 'app/entities/login';

@Component({
    selector: 'jhi-leave',
    templateUrl: './leave.component.html'
})
export class LeaveComponent implements OnInit {
    loginInfo: Login = {
        first_name: 'Andrew',
        last_name: 'Yang',
        avatar: 'ay.jpeg',
        title: 'Senior Developer'
    };
    constructor() {}

    ngOnInit() {}
}
