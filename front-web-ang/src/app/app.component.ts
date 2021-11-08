import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `   

    <app-nav></app-nav>

    <app-home></app-home>    
    
    <router-outlet></router-outlet>
    
    <app-footer></app-footer>

  `,
  styles: []
})
export class AppComponent {
  title = 'front-web-ang';
}
