import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-reactive-form-test',
  templateUrl: './reactive-form-test.component.html',
  styleUrls: ['./reactive-form-test.component.css']
})
export class ReactiveFormTestComponent implements OnInit {

  formStudent: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    // this.formStudent = new FormGroup({
    //   name: new FormControl('',
    //     [Validators.required, Validators.pattern('[A-Za-z]+')]),
    //   dateOfBirth: new FormControl('', this.checkDateOfBirth)
    // });
    this.formStudent = this.fb.group({
      name: ['', [Validators.required, Validators.pattern('[A-Za-z]+')]],
      dateOfBirth: ['', this.checkDateOfBirth]
    });
  }

  getInfoStudentForm(): void {
    console.log(this.formStudent.value);
  }

  // truong hop OK tra ve null, NG thi tra ve errorCode co gia tri true
  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value; // 2021-02-24
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {c09Abc : true};
  }
}
