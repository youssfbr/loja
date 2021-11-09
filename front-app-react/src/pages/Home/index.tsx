import CrossPlat from "assets/img/crossplat.jpg";
import Performance from "assets/img/performance.jpg";
import Productivity from "assets/img/productivity.jpg";
import FullDev from "assets/img/full_dev.jpg";
import NavBar from "shared/components/NavBar";
import Footer from "shared/components/Footer";

const Home = () => {
  return (
    <>
      <NavBar />

      <header className="bg-primary py-5 mb-5 ">
        <div className="container h-100">
          <div className="row h-100 align-itens-center">
            <div className="col-lg-2">
              <img
                src="http://angular.io/assets/images/logos/angular/angular.svg"
                alt="angular"
              />
            </div>
            <div className="col-lg-10">
              <h1 className="display-4 text-white mt-5 mb-2">
                Desenvolvimento SPA com Angular
              </h1>
              <p className="lead mb-5 text-white">
                Link Informática - Alisson Youssf
              </p>
            </div>
          </div>
        </div>
      </header>

      <div className="container main-container">
        <div className="row text-center mb-5">
          <div className="col-lg-3 col-md-6 mb-4">
            <div className="card h-100">
              <img
                className="card-img-top"
                src={CrossPlat}
                width="253px"
                alt=""
              />
              <div className="card-body">
                <h4 className="card-title">Multiplataforma</h4>
                <p className="card-text">
                  Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                  Maiores voluptas, accusantium alias nam voluptate quidem
                  perspiciatis facilis! Deserunt vero eum ab reiciendis, magni
                  harum, quae nobis libero recusandae amet similique.
                </p>
              </div>
              <div className="card-footer">
                <a href="/" className="btn btn-primary">
                  Saiba mais
                </a>
              </div>
            </div>
          </div>

          <div className="col-lg-3 col-md-6 mb-4">
            <div className="card h-100">
              <img
                className="card-img-top"
                src={Performance}
                width="253px"
                alt=""
              />
              <div className="card-body">
                <h4 className="card-title">Performance</h4>
                <p className="card-text">
                  Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                  Maiores voluptas, accusantium alias nam voluptate quidem
                  perspiciatis facilis! Deserunt vero eum ab reiciendis, magni
                  harum, quae nobis libero recusandae amet similique.
                </p>
              </div>
              <div className="card-footer">
                <a href="/" className="btn btn-primary">
                  Saiba mais
                </a>
              </div>
            </div>
          </div>

          <div className="col-lg-3 col-md-6 mb-4">
            <div className="card h-100">
              <img
                className="card-img-top"
                src={Productivity}
                width="253px"
                alt=""
              />
              <div className="card-body">
                <h4 className="card-title">Produtividade</h4>
                <p className="card-text">
                  Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                  Maiores voluptas, accusantium alias nam voluptate quidem
                  perspiciatis facilis! Deserunt vero eum ab reiciendis, magni
                  harum, quae nobis libero recusandae amet similique.
                </p>
              </div>
              <div className="card-footer">
                <a href="/" className="btn btn-primary">
                  Saiba mais
                </a>
              </div>
            </div>
          </div>

          <div className="col-lg-3 col-md-6 mb-4">
            <div className="card h-100">
              <img
                className="card-img-top"
                src={FullDev}
                width="253px"
                alt=""
              />
              <div className="card-body">
                <h4 className="card-title">Funcionalidades</h4>
                <p className="card-text">
                  Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                  Maiores voluptas, accusantium alias nam voluptate quidem
                  perspiciatis facilis! Deserunt vero eum ab reiciendis, magni
                  harum, quae nobis libero recusandae amet similique.
                </p>
              </div>
              <div className="card-footer">
                <a href="/" className="btn btn-primary">
                  Saiba mais
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Home;
