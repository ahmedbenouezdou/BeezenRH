import { Injectable } from '@angular/core';
import { SERVER_API_URL } from 'app/app.constants';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Activity } from 'app/entities/activite';
import { createRequestOption } from 'app/shared/util/request-util';
import { Observable, of } from 'rxjs';
@Injectable({
    providedIn: 'root'
})
export class ActivityService {
    private resourceUrl = SERVER_API_URL + 'api/activities';

    constructor(private http: HttpClient) {}

    create(activity: Activity): Observable<HttpResponse<Activity>> {
        return this.http.post<Activity>(this.resourceUrl, activity, { observe: 'response' });
    }

    update(user: Activity): Observable<HttpResponse<Activity>> {
        return this.http.put<Activity>(this.resourceUrl, user, { observe: 'response' });
    }

    find(login: string): Observable<HttpResponse<Activity>> {
        return this.http.get<Activity>(`${this.resourceUrl}/${login}`, { observe: 'response' });
    }

    query(req?: any): Observable<HttpResponse<Activity[]>> {
        const options = createRequestOption(req);
        return this.http.get<Activity[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    /* delete(login: string): Observable<HttpResponse<any>> {
  
     return this.http.delete(`${this.resourceUrl}/${login}`, { observe: 'response' }); 
} */

    getAllActivities(): Observable<Activity[]> {
        return this.http.get<Activity[]>(SERVER_API_URL + 'api/users/activities');
    }
}
