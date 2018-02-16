import { Injectable } from '@angular/core';
import {User} from "./attributes/User";
import {HttpClient} from "@angular/common/http";
import {Topic} from "./attributes/Topic";



@Injectable()
export class DataService {

  constructor(public http: HttpClient) {
  }

  fetchUsers(): Promise<User[]> {

    console.log('>>>>>>');
    return this.http
      .get('http://localhost:8080/forum/api/clients')
      .toPromise()
      .then(data => {
        console.log(data);
        return data as User[]
      })
  }

  fetchTopics(user: User): Promise<Topic> {

    console.log('>>>>>>');
    return this.http
      .get('http://localhost:8080/forum/api/clients/'+ user.id +'/topics')
      .toPromise()
      .then(data => {
        console.log('Client with topic:', data);
        return data as Topic
      })
  }
}
