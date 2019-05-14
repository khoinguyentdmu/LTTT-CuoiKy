import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  private login(username: string, password: string): void {
    switch(username) {
      case 'user1':
        localStorage.setItem('username', '1');
        this.router.navigateByUrl("/homepage");
        break;
      case 'user2':
        localStorage.setItem('username', '2');
        this.router.navigateByUrl("/homepage");
        break;
      case 'user3':
        localStorage.setItem('username', '3');
        this.router.navigateByUrl("/homepage");
        break;
      case 'user4':
        localStorage.setItem('username', '4');
        this.router.navigateByUrl("/homepage");
        break;
      default: window.alert('Tài khoản mật khẩu không đúng!');
    }
    
  }

}
