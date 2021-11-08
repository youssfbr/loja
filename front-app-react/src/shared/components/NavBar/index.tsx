const NavBar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top " aria-label="Main navigation">

        <div className="container container-fluid">
          <a className="navbar-brand" href="">Link Informática</a>
    
          <button className="navbar-toggler p-0 border-0" type="button"  data-toggle="collapse" data-target="#navbarResponsive" id="navbarSideCollapse" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
      
          <div className="collapse navbar-collapse offcanvas-collapse" id="navbarResponsive">
            <ul className="navbar-nav m-auto me-2">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="">Produtos</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="">Sobre</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="">Contato</a>
              </li>       
            </ul>         
          </div>
    
        </div>
    
      </nav>
    )
}

export default NavBar;