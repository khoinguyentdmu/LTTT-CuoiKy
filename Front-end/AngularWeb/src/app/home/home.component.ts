import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private logedon: boolean;
  public arrPhones = [];
  constructor(private httpClient: HttpClient) {
    this.logedon = false;
  }

  ngOnInit() {
    if (localStorage.getItem('username') !== null) {
      this.logedon = true;
      this.httpClient.get(environment.backend_url + '/rs?idUser=' + localStorage.getItem('username') + '&numberOfPhone=3').subscribe((data:any) => {
        this.arrPhones = data;
      });
    }
  }

}
