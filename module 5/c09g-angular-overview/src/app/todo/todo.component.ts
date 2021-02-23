import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
interface ITodo {
  id: number;
  content: string;
  complete: boolean;
}

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  userInput = new FormControl();
  todos: Array<ITodo> = [];
  id = 1;
  constructor() { }

  ngOnInit(): void {
  }

  onChange() {
    const {value} = this.userInput;
    if (value) {
      const todo: ITodo = {
        id: this.id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.userInput.setValue('');
    }
  }

  toggleTodo(i) {
    this.todos[i].complete = !this.todos[i].complete;
  }

}
