import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  displayValueFromSub: string;

  constructor() { }

  ngOnInit(): void {
  }

  receivedFromSub(value: any): void {
    console.log('Value received from sub: ' + value);
    this.displayValueFromSub = value;
  }

}
