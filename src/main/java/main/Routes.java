package main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import model.RepositorioConsultoras;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {

  public static void main(String[] args) {
    System.out.println("Iniciando servidor");
    
    Spark.port(8080);
    Spark.staticFileLocation("/public");

    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    
    Spark.get("/", (request, response) -> {
        // opcion 1
        // pasar un diccionario
        Map<String, Object> modelo = new HashMap<>();
        
        // opción 2
        // pasar un objeto que tenga getters
        
        // opcion 3
        // pasar una lista y recorrerla mediante #lista
        
        modelo.put("anio", LocalDate.now().getYear());
        modelo.put("consultoras", RepositorioConsultoras.instancia.listar());
        
        return new ModelAndView(modelo, "index.html.hbs");
    }, engine);

    Spark.get("/blog", (request, response) -> {
      return new ModelAndView(null, "blog.html.hbs");
    }, engine);
  }

}
