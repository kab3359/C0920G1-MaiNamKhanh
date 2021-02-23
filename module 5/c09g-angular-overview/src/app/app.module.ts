import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CalculatorComponent } from './calculator/calculator.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import { PetComponent } from './pet/pet.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { HackerNewComponent } from './hacker-new/hacker-new.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { CountdownTimerAliasComponent } from './countdown-timer-alias/countdown-timer-alias.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { TodoComponent } from './todo/todo.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    FontSizeEditorComponent,
    PetComponent,
    ColorPickerComponent,
    HackerNewComponent,
    NameCardComponent,
    ProgressBarComponent,
    CountdownTimerAliasComponent,
    RatingBarComponent,
    TodoComponent,
    LoginComponent,
    RegisterComponent
  ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
