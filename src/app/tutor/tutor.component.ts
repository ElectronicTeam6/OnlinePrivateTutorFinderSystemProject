import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-tutor',
  templateUrl: './tutor.component.html',
  styleUrls: ['./tutor.component.css']
})
export class TutorComponent implements OnInit {

  demoRequests: any = [];
  bookingRequest: any = [];

  email = "";
  password = "";

  accepted = false;
  viewBkngs = false;
  viewDemoReq = true;
  updateProfile = false;
  loggedIn = false;

  constructor(protected userService: UserService) {
    this.userService.getDemoReqBYTID(this.userService.activeUser.id).subscribe((data) => {

      this.demoRequests = data;
      console.log(data);

    });

    this.userService.getBookingRequests(this.userService.activeUser.id).subscribe((data) => {
      this.bookingRequest = data;
      console.log(data);

    });
  }

  loginUser() {
    this.userService.loginTutor(this.email, this.password);

    this.userService.loginTutor(this.email, this.password);


    console.log("Active User in Login:", this.userService.activeUser);


    Object.entries(this.userService.activeUser).forEach(([key, value]) => {
      console.log(key, value);
      sessionStorage.setItem(key, <string>value);

      this.loggedIn = true;

    });
  }


  viewDemoRequests() {

    this.ngOnInit();
    this.viewBkngs = false;
    this.viewDemoReq = true;
    this.updateProfile = false;

    this.userService.getDemoReqBYTID(this.userService.activeUser.id).subscribe((data) => {

      this.demoRequests = data;
      console.log(data);

    });

    console.log("Bookings:", this.demoRequests);

  }

  viewBookings() {

    this.ngOnInit();
    this.viewBkngs = true;
    this.viewDemoReq = false;
    this.updateProfile = false;

    console.log("+++++++", this.bookingRequest);


    this.userService.getBookingRequests(this.userService.activeUser.id).subscribe((data) => {
      this.bookingRequest = data;
      console.log(data);

    });

    console.log("Bookings:", this.bookingRequest);

  }

  toggleUpdateProfile() {
    this.viewBkngs = false;
    this.viewDemoReq = false;
    this.updateProfile = true;
  }

  acceptDemoReq(user: any) {

    console.log("Accept demo req: ", user);
    this.userService.updateDemo(user.demoId);
    this.ngOnInit();

  }

  declineDemoRequest(user: any) {

    console.log("DElete Demo Req: ", user);
    this.userService.deleteDemo(user);
    this.ngOnInit();

  }

  acceptBooking(user: any) {
    console.log("Accept Booking: ", user);
    console.log("Boking Id: ", user);

    this.userService.updateBooking(user);
    this.ngOnInit();
  }

  declineBooking(user: any) {
    console.log("DElete Booking: ", user);

    this.userService.deleteBooking(user);
    this.ngOnInit();
  }

  updateTutor() {
    this.userService.updateTutor(this.userService.activeUser);
    this.ngOnInit();
  }

  ngOnInit(): void {

    this.userService.getDemoReqBYTID(this.userService.activeUser.id).subscribe((data) => {

      this.demoRequests = data;
      console.log(data);

    });

    this.userService.getBookingRequests(this.userService.activeUser.id).subscribe((data) => {
      this.bookingRequest = data;
      console.log(data);

    });
  }



}
