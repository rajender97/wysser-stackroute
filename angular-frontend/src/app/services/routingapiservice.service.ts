import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { forkJoin } from 'rxjs';  // RxJS 6 syntax
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RoutingapiserviceService {
  API_KEY='Am645nTS2rVqgDNr8UDKqZPdOL-X2_Z94sS5-GqjNBcoMfSOi_dVC6KTDGxL_jDb'
  responses=[];
  waypoints=[]
  constructor(private httpclient:HttpClient) {
      this.httpOptionsNoAuth = {
      headers: new HttpHeaders(),
      // headers1: new HttpHeaders().append('Access-Control-Allow-Origin', '*')
    };
       this.httpOptionsNoAuth.headers = this.httpOptionsNoAuth.headers.append('Content-Type', 'application/json');
    this.httpOptionsNoAuth.headers = this.httpOptionsNoAuth.headers.append('X-FD-Features', 'allow');
    this.httpOptionsNoAuth.headers = this.httpOptionsNoAuth.headers.append('X-FD-FLIGHT', 'null');
  }
  public getLatandLong(addresses):Observable<any>
    {
      for(var i=0;i<addresses.length;i++)
        {
          this.responses[i]=this.httpclient.get('http://dev.virtualearth.net/REST/v1/Locations?query='+addresses[i]+'&includeNeighborhood=1&include=1&maxResults=5&key='+this.API_KEY,{headers:this.httpOptionsNoAuth.header});
        }
        return forkJoin(this.responses)
    }
  public getGeoJsonLatLOng(coordinates,addresses)
    {
      for(var i=0;i<addresses.length-1;i++)
      {
        this.waypoints[i]=this.httpclient.get('http://dev.virtualearth.net/REST/V1/Routes?wp.0='+coordinates[i][0]+', '+coordinates[i][1]+'&wp.1='+coordinates[i+1][0]+','+ coordinates[i+1][1]+'&optmz=distance&routeAttributes=routePath&key=Am645nTS2rVqgDNr8UDKqZPdOL-X2_Z94sS5-GqjNBcoMfSOi_dVC6KTDGxL_jDb') 
      }
      return forkJoin(this.waypoints)
    }  
  public getRoutes(vehicleNumber)
    {
      var url = environment.apiUrl+':8091/api/v1/routes/'+vehicleNumber+'/slot1'
      return this.httpclient.get(url);
    }  
}
