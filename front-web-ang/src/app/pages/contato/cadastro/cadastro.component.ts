import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { User } from 'src/app/shared/types/User';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  cadastroForm: FormGroup;
  user: User;

  constructor(private fb: FormBuilder) 
  {
    this.cadastroForm = this.fb.group({
      name: ['', []],
      cpf: ['', []],
      email: ['', []],
      password: ['', []],
      confirmPassword: ['', []]      
    });
   }

  ngOnInit(): void {    
  }

  userPersist(): void {    
    this.user = Object.assign({}, this.user, this.cadastroForm.value);
    console.log(this.user);
    

  }

}
