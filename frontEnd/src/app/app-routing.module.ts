import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { MemberComponent } from './member/member.component';
import { LogoutComponent } from './logout/logout.component';


const routes: Routes = [
  {
    path: "login", component: LoginComponent,
  },
  {
    path:"user",component:UserComponent
  },
  {
    path:"member",component:MemberComponent
  },
  {
    path:"logout",component:LogoutComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
