import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark" aria-label="Main navigation">

        <div className="container container-fluid">
          <Link to="/" className="navbar-brand">Link Informática</Link>

          <button 
            className="navbar-toggler p-0 border-0"
            type="button"
            data-toggle="collapse"
            data-target="#navbarResponsive"
            id="navbarSideCollapse"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>

          <div
            className="collapse navbar-collapse offcanvas-collapse" id="navbarResponsive">
            <ul className="navbar-nav m-auto me-2">
              <li className="nav-item">
                <Link to="/" className="nav-link">Produtos</Link>
              </li>
              <li className="nav-item">
                <Link to="/sobre" className="nav-link">Sobre</Link>
              </li>
              <li className="nav-item">
                <Link to="/contato" className="nav-link">Contato</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </>
  );
};

export default NavBar;
