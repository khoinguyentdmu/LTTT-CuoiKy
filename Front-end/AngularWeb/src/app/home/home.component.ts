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
  private arrPhones = [];
  private arrPhoneNames = [];
  private arrPhonePics = [];
  private phone1name;
  private phone2name;
  private phone3name;
  private phone1pic;
  private phone2pic;
  private phone3pic;
  constructor(private httpClient: HttpClient) {
    this.logedon = false;
  }

  ngOnInit() {
    if (localStorage.getItem('username') !== null) {
      this.logedon = true;
      this.httpClient.get(environment.backend_url + '/rs?idUser=' + localStorage.getItem('username') + '&numberOfPhone=3').subscribe((data:any) => {
        this.arrPhones = data;
        for (let index = 0; index < this.arrPhones.length; index++) {
            switch(this.arrPhones[index].name) {
              case 'phone10':
              this.arrPhoneNames[index] = 'Điện thoại Samsung Galaxy A50';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/196963/samsung-galaxy-a50-black-1-400x460.png';
              break;

              case 'phone11':
              this.arrPhoneNames[index] = 'Điện thoại iPhone Xr 128GB';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/191483/iphone-xr-128gb-red-400x460.png';
              break;
      
              case 'phone12':
              this.arrPhoneNames[index] = 'Điện thoại Samsung Galaxy A6+ (2018)';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/160728/samsung-galaxy-a6-plus-2018-xanh-400x460.png';
              break;
      
              case 'phone13':
              this.arrPhoneNames[index] = 'Điện thoại Samsung Galaxy S10';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/161554/samsung-galaxy-s10-white-400x460.png';
              break;
      
              case 'phone14':
              this.arrPhoneNames[index] = 'Điện thoại iPhone Xs Max 64GB';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/190321/iphone-xs-max-gray-400x460.png';
              break;
      
              case 'phone15':
              this.arrPhoneNames[index] = 'Điện thoại Samsung Galaxy Note 8';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/106211/samsung-galaxy-note8-black-400x460.png';
              break;
      
              case 'phone16':
              this.arrPhoneNames[index] = 'Điện thoại iPhone X 64GB';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/114115/iphone-x-64gb-1-400x460.png';
              break;
      
              case 'phone17':
              this.arrPhoneNames[index] = 'Điện thoại Huawei P30 Lite';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/198985/huawei-p30-lite-400x460.png';
              break;
      
              case 'phone18':
              this.arrPhoneNames[index] = 'Điện thoại Samsung Galaxy M20';
              this.arrPhonePics[index] = 'https://cdn.tgdd.vn/Products/Images/42/195314/samsung-galaxy-m20-400x460.png';
              break;
      
            }
          }
      });
    }
  }

}
