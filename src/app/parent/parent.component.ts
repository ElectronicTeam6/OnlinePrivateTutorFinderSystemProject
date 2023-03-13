import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  allTutors: any;
  allBooks: any;
  loggedIn = false;

  viewTutors = true;
  viewBooks = false;

  email = "";
  password = "";

  requested = false;
  booked = false;




  constructor(protected userService: UserService) {

    this.userService.getAllTutors().subscribe((data) => {
      this.allTutors = data;
      console.log(data);

    });

    this.userService.getAllBooks().subscribe((data) => {
      this.allBooks = data;
      console.log(data);

    });
  }

  toggleTutors() {
    this.viewTutors = true;
    this.viewBooks = false;

  }

  toggleBooks() {
    this.viewBooks = true;
    this.viewTutors = false;
  }

  requestDemo(user: any) {

    this.requested = true;

    setTimeout(() => {
      this.requested = false;
    }, 3000);

    console.log("((((((()))))))))", user.id, this.userService.activeUser.id);


    this.userService.requestDemo(user.id, this.userService.activeUser.id);
    console.log("Request Demo:", user);

  }

  bookTutor(user: any) {
    console.log(user);

    this.booked = true;

    setTimeout(() => {
      this.booked = false;
    }, 3000);

    console.log("((((((()))))))))", user.id, this.userService.activeUser.id);


    this.userService.bookTutor(user.id, this.userService.activeUser.id);
    console.log("Book Tutor:", user);


  }


  loginUser() {
    this.userService.loginUser(this.email, this.password);

    this.userService.loginUser(this.email, this.password);


    console.log("Active User in Login:", this.userService.activeUser);


    Object.entries(this.userService.activeUser).forEach(([key, value]) => {
      console.log(key, value);
      sessionStorage.setItem(key, <string>value);

      this.loggedIn = true;

    });
  }

  ngOnInit(): void {
    this.userService.getAllTutors().subscribe((data) => {
      this.allTutors = data;
      console.log(data);

    });

    this.userService.getAllBooks().subscribe((data) => {
      this.allBooks = data;
      console.log(data);

    });
  }
}
