package main;

import static spark.Spark.*;
import static spark.Spark.post;
import static spark.SparkBase.port;
import spark.template.handlebars.HandlebarsTemplateEngine;
import controllers.ConsultorasController;
import controllers.HomeController;

public class Routes {

  public static void main(String[] args) {
    System.out.println("Iniciando servidor");

    HomeController home = new HomeController();
    ConsultorasController consultoras = new ConsultorasController();
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    port(8080);

    staticFileLocation("/public");

    get("/", home::mostrar, engine);
    get("/index.html", (request, response) -> {
      response.redirect("/");
      return null;
    });
    get("/consultoras", consultoras::listar, engine);
    post("/consultoras", consultoras::crear);
    get("/consultoras/new", consultoras::nuevo, engine);
    get("/consultoras/:id", consultoras::mostrar, engine);

  }

}
