import { Component, OnInit, AfterViewInit, ViewChildren, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, FormControlName } from '@angular/forms';
import { GenericValidator } from 'src/app/shared/utils/generic-form-validation';

import { User } from 'src/app/shared/types/User';

import { MASKS, NgBrazilValidators } from 'ng-brazil';
import { CustomValidators } from 'ng2-validation';
import { fromEvent, merge, Observable } from 'rxjs';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit, AfterViewInit {

  @ViewChildren(FormControlName, { read: ElementRef }) formInputElements: ElementRef[];

  public MASKS = MASKS;

  private genericValidator: GenericValidator;
  displayMessage: { [key: string]: string } = {};

  cadastroForm: FormGroup;
  user: User;
  formResult: string;  

  constructor(private fb: FormBuilder) 
  {
    let password = new FormControl('', [Validators.required, CustomValidators.rangeLength([6,15])]);
    let confirmPassword = new FormControl('', [Validators.required, CustomValidators.rangeLength([6,15]), CustomValidators.equalTo(password)]);

    this.cadastroForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(60)]],
      cpf: ['', [<any>NgBrazilValidators.cpf]],
      email: ['', [Validators.email]],
      password: password,
      confirmPassword: confirmPassword      
    });

    this.genericValidator = new GenericValidator();
  }
   
   ngOnInit(): void { }
  
  ngAfterViewInit(): void {
    let controlBlurs: Observable<any>[] = this.formInputElements
    .map((formControl: ElementRef) => fromEvent(formControl.nativeElement, 'blur'));

    merge(...controlBlurs).subscribe(() => {
      this.displayMessage = this.genericValidator.processMessages(this.cadastroForm);
    });
  }

  userPersist(): void 
  {    
    if (this.cadastroForm.dirty && this.cadastroForm.valid) 
    {
      this.cadastroForm.value.cpf = this.cadastroForm.value.cpf.replace(/\.|-/gm,'');

      this.user = Object.assign({}, this.user, this.cadastroForm.value);
      console.log(this.user);  
      
      this.formResult = JSON.stringify(this.cadastroForm.value);      
    }

  }

}
