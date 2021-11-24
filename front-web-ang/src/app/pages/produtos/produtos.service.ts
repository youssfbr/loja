import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { Product } from "src/app/shared/types/product";

@Injectable({
  providedIn: "root",
})
export class ProdutosService {

  protected UrlServiceV1: string = "http://localhost:8080";

  constructor(private http: HttpClient) {}

  obterProdutos(): Observable<Product[]> {
    return this.http
      .get<Product[]>(`${this.UrlServiceV1}/products`);
  }
}
