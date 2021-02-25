import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-sub',
  templateUrl: './sub.component.html',
  styleUrls: ['./sub.component.css']
})
export class SubComponent implements OnInit {

  valueSentToParent = 'Hello Parent';

  @Output()
  eventEmitter = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
  }

  sendToParent(): void {
    this.eventEmitter.emit(this.valueSentToParent);
  }

}
