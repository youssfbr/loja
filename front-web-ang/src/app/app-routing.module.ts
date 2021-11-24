import { CadastroComponent } from './pages/contato/cadastro/cadastro.component';
import { ProdutoDetalheComponent } from './pages/produtos/produto-detalhe/produto-detalhe.component';
import { ListaProdutosComponent } from './pages/produtos/lista-produtos/lista-produtos.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { HomeComponent } from './pages/home/home.component';
import { ContatoComponent } from './pages/contato/contato.component';


import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'produtos', component: ListaProdutosComponent },
  { path: 'produto-detalhe', component: ProdutoDetalheComponent },
  { path: 'produto-detalhe/:id', component: ProdutoDetalheComponent },
  { path: 'contato', component: ContatoComponent },
  { path: 'sobre', component: SobreComponent },
  { path: 'cadastro', component: CadastroComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
