import { Component, OnInit } from '@angular/core';
import { AccountService } from '../service/account.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.accountService.helloUser().subscribe(data=>{
     console.log(data); 
    })
  }

}
