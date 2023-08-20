package main;

import controller.ConsultorasController;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.persistence.PersistenceException;

public class Routes implements WithSimplePersistenceUnit {

  public static void main(String[] args) {
    new Routes().start();
  }

  public void start() {
    System.out.println("Iniciando servidor");

    Spark.port(8080);
    Spark.staticFileLocation("/public");

    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    ConsultorasController consultorasController = new ConsultorasController();


    Spark.get("/", consultorasController::listar, engine);

    Spark.get("/blog", (request, response) -> {
      return new ModelAndView(null, "blog.html.hbs");
    }, engine);

    Spark.get("/consultoras/nueva", consultorasController::nueva, engine);
    Spark.get("/consultoras/:id", consultorasController::buscar, engine);
    Spark.post("/consultoras", consultorasController::crear);

    Spark.exception(PersistenceException.class, (e, request, response) -> {
      response.redirect("/500"); //TODO
    });

    Spark.before((request, response) -> {
      entityManager().clear();
    });
  }


}
