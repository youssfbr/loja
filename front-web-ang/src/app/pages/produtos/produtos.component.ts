import { Product } from './../../shared/types/product';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.css']
})
export class ProdutosComponent implements OnInit {

  protected UrlServiceV1: string = 'http://localhost:8080/'

  constructor(private http: HttpClient) { }

  obterProdutos(): Observable<Product[]> {
    return this.http
    .get<Product[]>(`this.UrlServiceV1/products`);
  }

  ngOnInit(): void {
  }

}
