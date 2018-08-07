/**
 * Created by andrew.yang on 5/18/2017.
 */
import { OnInit, Component } from '@angular/core';
import { User } from 'app/entities/user';

@Component({
    selector: 'jhi-dashboard',
    templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
    loginInfo: User = {
        first_name: 'khadija',
        last_name: 'sejjil',
        avatar: 'ay.jpeg',
        title: 'Web Developer'
    };
    constructor() {}

    ngOnInit() {}
}
