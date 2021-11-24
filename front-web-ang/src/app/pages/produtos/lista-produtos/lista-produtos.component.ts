import { Component, OnInit } from '@angular/core';

import { Product } from './../../../shared/types/product';

import { ProdutosService } from './../produtos.service';

@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css']
})
export class ListaProdutosComponent implements OnInit {

  public products: Product[] = [];

  constructor(private productService: ProdutosService) { }

  ngOnInit(): void {

    this.productService.obterProdutos().subscribe(
      products => {
        this.products = products;        
      },
      error => console.log(error)      
    );
  }

}
