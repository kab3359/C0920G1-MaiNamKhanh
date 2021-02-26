import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule} from '@angular/router';
import { CustomerComponent } from './components/customer/customer.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { AddCustomerComponent } from './components/customer/add-customer/add-customer.component';

const routes: Routes = [
  {path : '', component: CustomerComponent},
  {path: 'customer-list', component: CustomerComponent},
  {path: 'customer-add', component: AddCustomerComponent}
]

@NgModule({
  declarations: [
    CustomerComponent,
    AddCustomerComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
