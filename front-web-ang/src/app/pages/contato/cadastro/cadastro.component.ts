import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  cadastroForm: FormGroup;

  constructor(private fb: FormBuilder) 
  {
    this.cadastroForm = this.fb.group({
      name: ['', []],
      cpf: ['', []],
      email: ['', []],
      password: ['', []],
      confirmepassword: ['', []]      
    });
   }

  ngOnInit(): void {    
  }

  userPersist(): void {
    let x = this.cadastroForm.value;

  }

}
