import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'app/entities/user';

@Component({
    selector: 'navigation',
    templateUrl: './navigation.component.html'
})
export class NavigationComponent implements OnInit {
    @Input() loginInfo: User;
    constructor(private router: Router) {}
    ngOnInit() {}
    activeRoute(routename: string): boolean {
        return this.router.url.indexOf(routename) > -1;
    }
}
