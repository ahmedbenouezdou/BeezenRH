import { Component, OnInit } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import * as moment from 'moment';
import { Events, Action, StructureCss } from './event';

const n = new Date();

@Component({
    selector: 'brh-cra',
    templateUrl: './cra.component.html',
    styleUrls: ['./cra.component.css']
})
export class CraComponent implements OnInit {
    daysTitle: string[];
    days: string[];
    event: Events[];
    monthevents = new Action();
    monthYears: string;
    calendarMonth: any[];
    month: number;
    years: number;
    model = new Events();
    date: { year: number; month: number };
    now = moment().format('LLLL');

    constructor() {
        this.monthevents.events = [
            {
                title: 'Event 1',
                color: 'red',
                startsAt: moment(new Date(), 'DD/MM/YYYY'),
                endsAt: this.now,
                etat: 1
            },
            {
                title: 'Event 1',
                color: 'red',
                startsAt: moment(new Date('8/06/2018'), 'DD/MM/YYYY'),
                endsAt: this.now,
                etat: 0
            }
        ];
    }

    ngOnInit() {}
}
