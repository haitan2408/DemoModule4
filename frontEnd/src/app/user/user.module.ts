import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeUserComponent } from './home-user/home-user.component';
import { UserRoutingModule } from './user-routing.module';
import { ShareModule } from '../share/share/share.module';
import { MaterialModule } from '../share/material/material.module';



@NgModule({
  declarations: [
    HomeUserComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    ShareModule,
    MaterialModule
  ]
})
export class UserModule { }
