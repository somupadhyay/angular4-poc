import { User } from './user.model';
import { Component,OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app works!';
  user:User = new User();
  users:User[] = [];
  submit(){
    this.users.push(this.user);
    console.log(this.user);
    this.user = new User();
  }
  ngOnInit(){
    console.log(this.user);
  }
}
