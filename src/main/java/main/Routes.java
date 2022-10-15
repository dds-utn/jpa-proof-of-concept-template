package main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import model.Consultora;
import model.RepositorioConsultoras;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

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

    // si
    Spark.get("/consultoras/nueva", (request, response) -> {
      // magia
      return new ModelAndView(null, "nuevaConsultora.html.hbs");
    }, engine);

    Spark.get("/consultoras/:id", (request, response) -> {
      Consultora consultora = RepositorioConsultoras.instancia.buscar(Long.parseLong(request.params("id")));

      return new ModelAndView(consultora, "consultora.html.hbs");
    }, engine);

    Spark.post("/consultoras", (request, response) -> {

      EntityTransaction transaction = PerThreadEntityManagers.getEntityManager().getTransaction();

      try {
        transaction.begin();
        Consultora consultora = new Consultora(
                request.queryParams("nombre"),
                Integer.parseInt(request.queryParams("cantidadEmpleados")));
        RepositorioConsultoras.instancia.agregar(consultora);
        transaction.commit();
      } catch (Exception e) {
        transaction.rollback();
      } // ESTA MAL IGUAL

      response.redirect("/");
      return null;
    });



    // NO
    // get /crearConsultora
    // get /consultoras/crear
  }



}
