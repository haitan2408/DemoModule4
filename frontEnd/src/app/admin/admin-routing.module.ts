import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListCourseComponent } from './course/list-course/list-course.component';
import { AdminComponent } from './admin.component';
import { CreateCourseComponent } from './course/create-course/create-course.component';

const adminRoutes: Routes = [
    {
        path: "admin", component: AdminComponent, children: [
            {
                path: "course", component: ListCourseComponent, children: [
                    { path: "create-course", component: CreateCourseComponent }
                ]
            }
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(adminRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class AdminRoutingModule { }