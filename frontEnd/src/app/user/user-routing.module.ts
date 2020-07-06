import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user.component';
import { HomeUserComponent } from './home-user/home-user.component';

const userRoutes: Routes = [
    {
        path: "", component: UserComponent , children: [
            {
                path: "home", component: HomeUserComponent }
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(userRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class UserRoutingModule { }