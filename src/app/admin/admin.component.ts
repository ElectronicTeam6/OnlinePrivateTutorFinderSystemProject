import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  loggedIn = false;
  email = "";
  password = "";

  allUsers: any;
  allTutors: any;
  allParents: any;
  allBooks: any;

  parentToEdit: any;
  bookToEdit: any;
  tutorToEdit: any;
  bookToAdd: any = {};
  tutorToAdd: any = {};

  manageParents: boolean = true;
  manageTutor: boolean = false;
  manageEbooks: boolean = false;
  addEbooks: boolean = false;
  addTTutor: boolean = false;

  toggleEditParent = false;
  toggleEditTutor = false;
  toggleEditBook = false;
  // toggleAddBooks = false;

  constructor(protected userService: UserService) {
    this.allUsers = this.userService.getAllUsers().subscribe((data) => this.allUsers = data);
    this.allParents = this.userService.getAllParents().subscribe((data) => this.allParents = data);
    this.allTutors = this.userService.getAllTutors().subscribe((data) => this.allTutors = data);
    this.allBooks = this.userService.getAllBooks().subscribe((data) => this.allBooks = data);

  }

  editMeParent(user: any) {

    this.toggleEditParent = !this.toggleEditParent;

    this.parentToEdit = user;
    console.log("----------- User To Edit ------------", user);
  }
  editMeBook(user: any) {

    this.toggleEditBook = !this.toggleEditBook;

    this.bookToEdit = user;
    console.log("----------- User To Edit ------------", user);
  }
  editMeTutor(user: any) {

    this.toggleEditTutor = !this.toggleEditTutor;

    this.tutorToEdit = user;
    console.log("----------- User To Edit ------------", user);
  }

  togglemanageParents() {
    this.manageParents = true;
    this.manageTutor = false;
    this.manageEbooks = false;
    this.addEbooks = false;
    this.addTTutor = false;
  }

  toggleManageTutor() {
    this.allTutors = this.userService.getAllTutors().subscribe(data => this.allTutors = data);
    this.manageTutor = true;
    this.manageParents = false;
    this.manageEbooks = false;
    this.addEbooks = false;
    this.addTTutor = false;
  }

  toggleManageBooks() {
    this.allBooks = this.userService.getAllBooks().subscribe((data) => this.allBooks = data);
    this.manageTutor = false;
    this.manageParents = false;
    this.addEbooks = false;
    this.manageEbooks = true;
    this.addTTutor = false;
  }

  toggleAddBooks() {
    this.addEbooks = true;
    this.manageTutor = false;
    this.manageParents = false;
    this.manageEbooks = false;
    this.addTTutor = false;

  }

  toggleAddTutor() {
    this.addEbooks = false;
    this.manageTutor = false;
    this.manageParents = false;
    this.manageEbooks = false;
    this.addTTutor = true;
  }



  updateParent() {

    console.log("Update Parent");

    this.userService.updateParent(this.parentToEdit);
    this.ngOnInit();
    // window.location.reload();
  }

  updateTutor() {
    console.log("Update Tutor");

    this.userService.updateTutor(this.tutorToEdit);
    this.ngOnInit();
    // window.location.reload();
  }

  updateBook() {
    console.log("Update Book");

    this.userService.updateBook(this.bookToEdit);
    this.ngOnInit();
    // window.location.reload();
  }

  deleteMeParent(user: any) {
    // this.editMeParent(user);
    this.userService.deleteParent(user);
    this.ngOnInit();
    // window.location.reload();
  }

  deleteMeBook(user: any) {
    // this.editMeParent(user);
    this.userService.deleteBook(user);
    this.ngOnInit();
    // window.location.reload();
  }

  deleteMeTutor(user: any) {
    // this.editMeParent(user);
    this.userService.deleteTutor(user);
    this.ngOnInit();
    // window.location.reload();
  }

  addBook() {
    this.userService.addBook(this.bookToAdd);
    console.log(this.bookToAdd);

  }

  addTutor() {

    this.userService.addTutors(this.tutorToAdd);

  }

  loginAdmin() {
    this.userService.loginAdmin(this.email, this.password);

    console.log("Active Admin :", this.userService.activeUser);


    Object.entries(this.userService.activeUser).forEach(([key, value]) => {
      console.log(key, value);
      sessionStorage.setItem(key, <string>value);

      this.loggedIn = true;

    });
  }

  ngOnInit(): void {

    this.allUsers = this.userService.getAllUsers().subscribe((data) => this.allUsers = data);
    this.allParents = this.userService.getAllParents().subscribe((data) => this.allParents = data);
    this.allTutors = this.userService.getAllTutors().subscribe((data) => this.allTutors = data);
    this.allBooks = this.userService.getAllBooks().subscribe((data) => this.allBooks = data);




  }

}
