import { Component, OnInit } from '@angular/core';
import { User } from '../architectures/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email = "";
  password = "";

  constructor(public userService: UserService) {
    console.log("All user in login:", this.userService.getAllUsers());

  }

  ngOnInit(): void {
  }

  loginUser() {

    this.userService.loginUser(this.email, this.password);

    console.log("Active User in Login:", this.userService.activeUser);


    Object.entries(this.userService.activeUser).forEach(([key, value]) => {
      console.log(key, value);
      sessionStorage.setItem(key, <string>value);

    })


  }

}
