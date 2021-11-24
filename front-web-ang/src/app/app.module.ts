import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavComponent } from './shared/components/nav/nav.component';
import { HomeComponent } from './pages/home/home.component';
import { ProdutosComponent } from './pages/produtos/produtos.component';
import { ListaProdutosComponent } from './pages/produtos/lista-produtos/lista-produtos.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { ProdutoDetalheComponent } from './pages/produtos/produto-detalhe/produto-detalhe.component';
import { ContatoModule } from './pages/contato/contato.module';

import { registerLocaleData } from '@angular/common';
import ptBr from '@angular/common/locales/pt';

registerLocaleData(ptBr);

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    SobreComponent,  
    FooterComponent,
    ProdutosComponent,
    ListaProdutosComponent,
    ProdutoDetalheComponent,    
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ContatoModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' },
    { provide: DEFAULT_CURRENCY_CODE, useValue: 'BRL' },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
