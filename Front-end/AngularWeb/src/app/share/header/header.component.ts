import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private logedon: boolean;
  constructor() {
    this.logedon = false;
  }

  ngOnInit() {
    if (localStorage.getItem('username') !== null) {
      this.logedon = true;
    }
  }

  public logout() {
    localStorage.removeItem('username');
    window.location.reload();
  }
}
