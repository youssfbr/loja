import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  protected UrlServiceV1: string = "http://localhost:8080/"

  constructor(private http: HttpClient) { }


  obterProdutos() {
    this.http.get(`this.UrlServiceV1/products`)
    
  }

}
