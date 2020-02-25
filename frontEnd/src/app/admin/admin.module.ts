import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { ListCourseComponent } from './course/list-course/list-course.component';
import { CreateCourseComponent } from './course/create-course/create-course.component';
import { ShareModule } from '../share/share/share.module';
import { MaterialModule } from '../share/material/material.module';
import { UpdateCourseComponent } from './course/update-course/update-course.component';


@NgModule({
  declarations: [
    ListCourseComponent,
    CreateCourseComponent,
    UpdateCourseComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    AdminRoutingModule,
    ShareModule
  ],
  entryComponents: [UpdateCourseComponent],
})
export class AdminModule { }
