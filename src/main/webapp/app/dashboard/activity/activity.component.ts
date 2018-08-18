import { Component, OnInit } from '@angular/core';
import { Activity } from 'app/entities/activite';
import { ActivityService } from 'app/services/activity.service';
import { UserService } from 'app/core';
import { isTypeQueryNode } from '../../../../../../node_modules/typescript';

@Component({
    selector: 'jhi-activity',
    templateUrl: './activity.component.html',
    styles: []
})
export class ActivityComponent implements OnInit {
    public myactivities: Array<Activity> = [
        { id: 1, activityLabel: 'titre1', dateDebut: new Date(), dateFin: new Date(), isValide: true, activityType: 1, user: null },
        { id: 2, activityLabel: 'titre2', dateDebut: new Date(), dateFin: new Date(), isValide: true, activityType: 1, user: null },
        { id: 3, activityLabel: 'titre3', dateDebut: new Date(), dateFin: new Date(), isValide: true, activityType: 1, user: null },
        { id: 4, activityLabel: 'titre4', dateDebut: new Date(), dateFin: new Date(), isValide: true, activityType: 1, user: null }
    ];

    constructor(private activityService: ActivityService, private userService: UserService) {}

    ngOnInit() {
        this.activityService.getAllActivities().subscribe(
            activities => {
                this.myactivities = activities;
            },
            err => {
                console.log('error while retrieving data');
            }
        );
    }

    public createNew() {
        let a = new Activity();
        a.activityLabel = 'title1';
        a.activityType = 1;
        a.dateDebut = new Date();
        a.dateFin = new Date();
        a.isValide = true;
        /* a.user=new IUser(); */
        console.log('searching for user');
        this.userService.findAdmin('admin').subscribe(
            b => {
                // a.user=b;
                /* let a=new Activity();
 a.user = b.body; */

                console.log('user logged in', b.body);
            },
            err => {
                console.log('nooooooooooooooooooooooooooooooooooooooooo');
            }
        );
        /*   this.activityService.create(a).subscribe((ok)=>{
      console.log(ok,"okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    }, (err) => {
      console.log("nooooooooooooooooooooooooooooooooooooooooo")
    }); */
    }
}
