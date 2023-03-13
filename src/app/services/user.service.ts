import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { WrappedNodeExpr } from '@angular/compiler';
import { ErrorHandler, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { async, catchError, throwError } from 'rxjs';
import { User } from '../architectures/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  activeUser: any = {
  };

  response = 0;
  errorMessage: any;

  linkHeader = "http://localhost:8089/";
  parnetHeader = "parent/";
  tutorHeader = "tutor/";
  adminHeader = "admin/";
  booksHeader = "books/";

  users: any;

  allUsers: any = {};

  parents: any;

  constructor(private http: HttpClient, private router: Router) {

    this.allUsers = this.getAllUsers().subscribe((data) => {
      this.allUsers = data;
      console.warn(this.allUsers);

    });

  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.warn('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      // this.response = error.status;


      console.warn(
        `Backend returned code ${error.status}, body was: `, error.error);
      this.errorMessage = error.error;
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

  getUserByEmail(email: string) {
    return this.http.get(`${this.linkHeader}getUserByEmail/${email}`);
  }

  getAllUsers() {
    // console.log(this.http.get("http://localhost:8089/allUsers").subscribe((data)=> console.log(data)));



    return (this.http.get(`http://localhost:8089/allUsers`));
  }

  getAllParents() {
    return (this.http.get(`${this.linkHeader + this.parnetHeader}allParents`));
  }

  getAllTutors() {
    return this.http.get(`${this.linkHeader + this.tutorHeader}allTutors`);
  }

  getAllBooks() {
    return this.http.get(`${this.linkHeader + this.booksHeader}allBookss`);
  }

  deleteUser(uId: number) {
    return this.http.delete(`${this.linkHeader}deleteUser/${uId}`);
  }


  addUser(user: User) {

    let message = this.http.post(`${this.linkHeader + this.parnetHeader}registerParent`, user).subscribe();
    // setUser(user);
    console.log("MESSAGE: ", message);


  }

  addTutor(user: User) {

    let message = this.http.post(`${this.linkHeader + this.tutorHeader}registerTutor`, user).subscribe();
    // setUser(user);
    console.log("MESSAGE: ", message);


  }

  resp(status: number, email: String) {

    if (status == 200) {
      console.log("status is ok", status);

      console.log(this.activeUser);


      // sessionStorage.setItem();

    }

    console.log("Status in Resp:", status);

    this.http.get(`${this.linkHeader}getUserByEmail/${email}`, { observe: 'response' }).subscribe((data => {
      this.activeUser = data.body;
      // console.log(data.body);

      Object.entries(this.activeUser).forEach(
        ([key, values]) => {
          sessionStorage.setItem(key, <string>values);
        }
      );

      if (this.activeUser.admin) {
        this.router.navigate(['/admin']);
      }
      else if (this.activeUser.tutor) {
        this.router.navigate(['/tutor']);
      }
      else if (this.activeUser.parent) {
        this.router.navigate(['/parent']);
      }


      console.warn(this.activeUser);
    }
    ));


  }


  // Login Sevice


  loginUser(email: string | number | boolean, password: string | number | boolean) {

    let credentials = new HttpParams;
    credentials.append("email", email);
    credentials.append("password", password);
    this.http.get(`${this.linkHeader}${this.parnetHeader}loginParent/${email}/${password}`,).subscribe((data) => {
      console.log(data);
      this.activeUser = data;

    },
      (error) => {
        this.errorMessage = error;
        console.log(error);

      }
    )
  }

  loginAdmin(email: string | number | boolean, password: string | number | boolean) {

    let credentials = new HttpParams;
    credentials.append("email", email);
    credentials.append("password", password);
    this.http.get(`${this.linkHeader}${this.adminHeader}loginAdmin/${email}/${password}`,).subscribe((data) => {
      console.log(data);
      this.activeUser = data;

    },
      (error) => {
        this.errorMessage = error;
        console.log(error);

      }
    )
  }

  loginTutor(email: string | number | boolean, password: string | number | boolean) {

    let credentials = new HttpParams;
    credentials.append("email", email);
    credentials.append("password", password);
    this.http.get(`${this.linkHeader}${this.tutorHeader}loginTutor/${email}/${password}`,).subscribe((data) => {
      console.log(data);
      this.activeUser = data;

    },
      (error) => {
        this.errorMessage = error;
        console.log(error);

      }
    )
  }


  // PARENT OPS

  // UPDATE FUNCTIONALITY

  updateParent(user: any) {

    this.http.post(`${this.linkHeader}${this.parnetHeader}/updateParent`, user).subscribe();

  }

  deleteParent(user: any) {
    console.log("User To Delete:", user);

    this.http.delete(`${this.linkHeader}${this.parnetHeader}deleteParent`, { body: user }).subscribe();
  }


  updateTutor(user: any) {

    this.http.post(`${this.linkHeader}${this.tutorHeader}/updateTutor`, user).subscribe();

  }

  addTutors(tutor: any) {

    console.log("Tutor to add:", tutor);

    this.http.post(`${this.linkHeader}${this.tutorHeader}registerTutor`, tutor).subscribe();


  }

  deleteTutor(user: any) {
    console.log("Tutor To Delete:", user);

    this.http.delete(`${this.linkHeader}${this.tutorHeader}deleteTutor`, { body: user }).subscribe();
  }


  addBook(book: any) {

    console.log("Book to add:", book);

    this.http.post(`${this.linkHeader}${this.booksHeader}registerBooks`, book).subscribe();


  }


  updateBook(user: any) {

    this.http.post(`${this.linkHeader}${this.booksHeader}/updateBook`, user).subscribe();

  }

  deleteBook(user: any) {
    console.log("Book To Delete:", user);

    this.http.delete(`${this.linkHeader}${this.booksHeader}deleteBook`, { body: user }).subscribe();
  }

  ngOnInit(): void {
    this.allUsers = this.getAllUsers().subscribe((data) => {
      this.allUsers = data;
      console.warn(this.allUsers);
      this.allUsers = data;
    });
  }


  // Parent FUNCTIONALITIES

  requestDemo(tId: number, pId: number) {
    this.http.get(`http://localhost:8089/demoReq/getDemoRequests/${pId}/${tId}`).subscribe();
  }

  bookTutor(tid: number, pid: number) {
    this.http.get(`http://localhost:8089/bookTutor/sendBookingRequest/tid/${tid}/pid/${pid}`).subscribe();
  }

  getDemoReqBYTID(tid: number) {
    return this.http.get(`${this.linkHeader}demoReq/getDemoRequestsByTID/${tid}`);
  }

  getBookingRequests(tid: number) {
    return this.http.get(`${this.linkHeader}bookTutor/getBookingsBTID/tid/${tid}`);
  }

  updateBooking(d: any) {
    console.log("(())D:", d);
    this.http.get(`http://localhost:8089/bookTutor/updateData/${d}`).subscribe();
  }

  updateDemo(d: any) {
    console.log("(())D:", d);

    this.http.get(`${this.linkHeader}demoReq/updateReq/${d}`,).subscribe();
    // /demoReq/updateReq/{d}
  }

  deleteDemo(d: any) {


    this.http.delete(`${this.linkHeader}demoReq/deleteReq`, { body: d }).subscribe();
  }


  deleteBooking(d: any) {
    this.http.delete(`${this.linkHeader}bookTutor/deleteData`, { body: d }).subscribe();
  }
}


