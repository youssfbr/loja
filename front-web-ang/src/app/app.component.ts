import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <!--The content below is only a placeholder and can be replaced.-->

    <div class="container text-center">
      <h2>Alisson </h2>
    </div>    
    
    <router-outlet></router-outlet>
  `,
  styles: []
})
export class AppComponent {
  title = 'front-web-ang';
}
