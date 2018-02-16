import { Component, OnInit } from '@angular/core';
import {User} from "../attributes/User";
import {DataService} from "../data-service.service";
import {Topic} from "../attributes/Topic";

@Component({
  selector: 'app-client-list-view',
  templateUrl: './client-list-view.component.html',
  styleUrls: ['./client-list-view.component.css']
})
export class ClientListViewComponent implements OnInit {

  users : User[];
  selectedUser : User;
  createdTopic : Topic = new Topic();

  constructor(public dataService : DataService) {
    dataService.fetchUsers()
      .then(clients => this.users = clients )
      .then(clients => console.log(clients));

  }

  ngOnInit() {
  }

  details(user: User){
    this.selectedUser = user;

    this.dataService.fetchTopics(user)
      /*.then(clients => this.selectedUser. = clients)
      .then(console.log)*/
      .then(topics => this.selectedUser.topics)
  }
  createTopic(){

  }

}
