import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  public listCustomer;
  term: string;
  p: number;
  constructor(public customerService: CustomerService) { }

  ngOnInit(): void {
    this.customerService.getAllCustomer().subscribe(data => {
      this.listCustomer = data;
      console.log(this.listCustomer);
    });
  }

}
