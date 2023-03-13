import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {


  adminPane = false;
  parentPane = true;
  tutorPane = false;

  constructor() { }

  ngOnInit(): void {
  }

  activeAdmin() {
    this.adminPane = true;
    this.parentPane = false;
    this.tutorPane = false;

  }

  activeTutor() {
    this.adminPane = false;
    this.parentPane = false;
    this.tutorPane = true;

  }

  activeParent() {

    this.adminPane = false;
    this.parentPane = true;
    this.tutorPane = false;
  }

}
