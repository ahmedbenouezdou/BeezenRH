import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';

export interface IActivity {
    id?: number;
    activityLabel?: string;
    dateDebut?: Moment;
    dateFin?: Moment;
    isValide?: boolean;
    activityType?: number;
    user?: IUser;
}

export class Activity implements IActivity {
    constructor(
        public id?: number,
        public activityLabel?: string,
        public dateDebut?: Moment,
        public dateFin?: Moment,
        public isValide?: boolean,
        public activityType?: number,
        public user?: IUser
    ) {
        this.isValide = false;
    }
}
