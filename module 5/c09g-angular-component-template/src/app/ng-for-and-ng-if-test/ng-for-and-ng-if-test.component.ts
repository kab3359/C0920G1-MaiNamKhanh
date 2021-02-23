import {Component, OnInit} from '@angular/core';
import {Student} from '../student';

@Component({
  selector: 'app-ng-for-and-ng-if-test',
  templateUrl: './ng-for-and-ng-if-test.component.html',
  styleUrls: ['./ng-for-and-ng-if-test.component.css']
})
export class NgForAndNgIfTestComponent implements OnInit {

  public studentList: Student[];

  constructor() {

  }

  ngOnInit(): void {
    this.studentList = new Array();
    this.studentList.push(new Student(12312, 'Nguyen Van A', '23/02/2021', 1));
    this.studentList.push(new Student(6546, 'Nguyen Thi D', '23/02/2021', 0));
    this.studentList.push(new Student(2343, 'Nguyen Thi B', '23/02/2021', 0));
    this.studentList.push(new Student(7776, 'Nguyen Van C', '23/02/2021', 1));
  }

}
