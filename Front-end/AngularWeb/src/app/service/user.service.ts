import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  public API_URL = environment.backend_url;
  constructor(private http: HttpClient) { }

  // public login(username: string, password: string) Observable<any> {

  // }
}
