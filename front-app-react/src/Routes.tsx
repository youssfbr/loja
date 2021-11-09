import { BrowserRouter, Switch, Route } from "react-router-dom";

import Home from "pages/Home";
import Contato from "pages/Contato";
import Sobre from "pages/Sobre";

const Routes = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/contato">
          <Contato />
        </Route>
        <Route path="/sobre">
          <Sobre />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;