import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ContatoComponent } from './contato.component';
import { CadastroComponent } from './cadastro/cadastro.component';

@NgModule({
  declarations: [
    ContatoComponent,
    CadastroComponent  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ], 
  exports: [
    ContatoComponent,
    CadastroComponent
  ]
})
export class ContatoModule { }
