import { Component, OnInit } from '@angular/core';
import {Student} from '../student';

@Component({
  selector: 'app-template-driven-form-test',
  templateUrl: './template-driven-form-test.component.html',
  styleUrls: ['./template-driven-form-test.component.css']
})
export class TemplateDrivenFormTestComponent implements OnInit {

  student: Student;

  constructor() {
  }

  ngOnInit(): void {
    this.student = new Student(342, 'Nguyen Van A', '2021-02-24');
  }

  getInfoStudentForm(form): void {
    console.log(form.value);
    console.log(this.student);
  }
}
