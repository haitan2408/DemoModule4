import { Component, OnInit, Inject } from '@angular/core';
import { Validators, FormControl, FormBuilder, FormGroup } from '@angular/forms';
import { AdminService } from 'src/app/service/admin.service';
import { Router } from '@angular/router';
import{MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {
  registerForm: FormGroup
  listError: any = "";
  validation_messages = {
    'nameCourse': [
      { type: 'required', message: 'Tên của khóa học không được để trống.' }
    ],
  }
  constructor(private adminService: AdminService, private fb: FormBuilder, private router: Router,
    @Inject(MAT_DIALOG_DATA) public data: any) { 
       this.adminService.getCourseById(data).subscribe(data=> {
         this.registerForm.patchValue(data);
       },error => {
         alert("Không tìm thấy khóa học mà bạn muốn cập nhật.")
       })
    }

  ngOnInit() {
    this.createFormRegister();
  }
  createFormRegister() {
    this.registerForm = this.fb.group({
      id:new FormControl(),
      nameCourse: new FormControl('', Validators.compose([
        Validators.required,
      ]))
    })
  }
  updateCourse() {
    this.adminService.updateCourse(this.registerForm.value).subscribe(data=>{
        alert("Bạn đã cập nhật khóa học thành công");
        location.reload();
    },error =>{
      if (error.status === 400) {
        this.listError = error.error;
      }
      if (error.status === 500) {
        alert("Tên khóa học đã tồn tại")
      }
     
    })
  }
}

