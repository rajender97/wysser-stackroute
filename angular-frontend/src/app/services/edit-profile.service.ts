import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class EditProfileService {

  constructor(public http: HttpClient) {
  }

  public saveRetailerData(data) {

    let url = environment.apiUrl + ':8082/retailerProfile/saveDetailOfRetailer';
    // console.log(url);
    console.log('profile data = ')
    console.log(data);

    setTimeout(() => {
      this.http.post(url, data).subscribe();
      alert('Profile Saved');
    }, 350);


  }



  public getProfileFromEmail(data) {

    let url = environment.apiUrl + ':8082/retailerProfile/getRetailerFromEmail?email=' + data;

    return this.http.get(url);

  }


}
