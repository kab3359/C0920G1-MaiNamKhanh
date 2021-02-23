import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-countdown-timer-alias',
  templateUrl: './countdown-timer-alias.component.html',
  styleUrls: ['./countdown-timer-alias.component.css']
})
export class CountdownTimerAliasComponent implements OnInit, OnChanges, OnDestroy {
  private intervalId = 0;
  message = '';
  remainingTime: number;
  picture = '';

  // tslint:disable-next-line:no-input-rename
  @Input('remaining-time')
  seconds = 11;
  constructor() { }

  ngOnInit(): void {
    this.reset();
    this.start();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if ('seconds' in changes) {
      let v = changes.seconds.currentValue;
      v = typeof v === 'undefined' ? 11 : v;
      const vFixed = Number(v);
      this.seconds = Number.isNaN(vFixed) ? 11 : vFixed;
    }
  }
  clearTimer() {
    clearInterval(this.intervalId);
  }

  ngOnDestroy(): void {
    this.clearTimer();
  }

  start() {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }
  stop() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }
  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = `Click start button to start the Countdown`;
    this.picture = '';
  }

  private countDown() {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      this.remainingTime -= 1;
      if (this.remainingTime === 0) {
        this.message = 'Blast off!';
        this.picture = '../../assets/abcd.PNG';
        this.clearTimer();
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);
  }

}
