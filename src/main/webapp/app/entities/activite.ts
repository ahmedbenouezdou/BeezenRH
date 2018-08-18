import { User, IUser } from 'app/core/user/user.model';

//import { User } from 'app/entities/User';

export class Activity {
    id: number;
    activityLabel: string;
    dateDebut?: Date;
    dateFin?: Date;
    isValide: boolean;
    activityType: number;
    user: IUser;

    constructor() {}
}
