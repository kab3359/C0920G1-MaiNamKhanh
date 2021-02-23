import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SubComponent } from './sub/sub.component';
import { ParentComponent } from './parent/parent.component';
import {FormsModule} from '@angular/forms';
import { NgForAndNgIfTestComponent } from './ng-for-and-ng-if-test/ng-for-and-ng-if-test.component';
import { NgStyleAndNgClassTestComponent } from './ng-style-and-ng-class-test/ng-style-and-ng-class-test.component';
import { PipeTestComponent } from './pipe-test/pipe-test.component';

@NgModule({
  declarations: [
    AppComponent,
    SubComponent,
    ParentComponent,
    NgForAndNgIfTestComponent,
    NgStyleAndNgClassTestComponent,
    PipeTestComponent
  ],
    imports: [
        BrowserModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
