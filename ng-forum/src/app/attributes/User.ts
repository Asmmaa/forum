import {Topic} from "./Topic";
export class User{

  id: number;
  name: string;

  users: User[] = [];
  topics: Topic[]= [];
}
