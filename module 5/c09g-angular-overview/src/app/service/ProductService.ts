import {Product} from '../model/Product';
import {Injectable} from '@angular/core';
import {LoggerService} from './LoggerService';
@Injectable()
export class ProductService {
  constructor(private loggerService: LoggerService) {
    this.loggerService.log('Product Service Contructed');
  }
  public getProducts(){
    this.loggerService.log('getProducts called')
    let products: Product[];
    products = [
      new Product(1, 'Iphone', 500),
      new Product(2, 'Samsung', 1000),
      new Product(3, 'SH', 200)
    ];
    this.loggerService.log(products);
    return products;
  }
}
