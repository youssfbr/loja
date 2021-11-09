import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `   
    
    <app-nav></app-nav>

    <div class="">
      <router-outlet></router-outlet>    
    </div>

    
    <app-footer></app-footer>

  `,
  styles: []
})
export class AppComponent {
  title = 'front-web-ang';
}
