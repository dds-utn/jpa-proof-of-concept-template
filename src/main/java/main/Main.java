package main;

import static spark.Spark.get;
import static spark.SparkBase.port;

import java.util.HashMap;
import java.util.List;

import model.Consultora;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import controllers.ConsultorasController;

public class Main {

  public static void main(String[] args) {
    System.out.println("Iniciando servidor");
    
    ConsultorasController consultoras = new ConsultorasController();
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    port(8080);

    get("/", (request, response) -> "hola!");
    get("/index.html", (request, response) -> {
      response.redirect("/");
      return null;
    });
    get("/consultoras", consultoras::listar, engine);
    get("/consultoras/:id", consultoras::mostrar, engine);
     
  }

}
