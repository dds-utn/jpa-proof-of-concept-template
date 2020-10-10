package main;

import static spark.Spark.*;
import static spark.Spark.post;
import static spark.SparkBase.port;

import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {

  public static void main(String[] args) {
    Spark.port(8080);
    
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    
    Spark.get("/", (request, response) -> {
        return new ModelAndView(null, "index.html.hbs");
    }, engine);
  }

}
