import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Observable } from 'rxjs';
import { Deliveryroute } from './deliveryroute';

@Injectable({
  providedIn: 'root'
})
export class DriverDashboardService {

  constructor(private http: HttpClient) { }

  getDeliveryRoute(date, vehicleId, timeslot): Observable<Deliveryroute>{
    let uri= environment.apiUrl + ":8086/dashboard/getNextDeliveryRoute?date=" + date + "&vehicleId=" + vehicleId + "&timeslot=" + timeslot;
    return this.http.get<Deliveryroute>(uri);
  }

  acceptDelivery(vehicleId: String){
    let uri=environment.apiUrl + ":8086/dashboard/accept";
    let data = {"vehicleId": vehicleId};

    return this.http.post(uri, JSON.stringify(data), {headers:{'Content-Type': 'application/json'}});
  }

  rejectDelivery(vehicleId: String){
    let uri=environment.apiUrl + ":8086/dashboard/reject";
    let data = {"vehicleId": vehicleId};

    return this.http.post(uri, JSON.stringify(data), {headers:{'Content-Type': 'application/json'}});
  }
}
