package main;

import controllers.ConsultorasController;
import controllers.HomeController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {

    public static void main(String[] args) {
        System.out.println("Corriendo bootstrap...");
        new Bootstrap().run();

        System.out.println("Iniciando servidor...");
        Spark.port(8080);
        Spark.staticFileLocation("/public");


        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        ConsultorasController consultorasController = new ConsultorasController();
        HomeController homeController = new HomeController();

        Spark.get("/", (request, response) -> homeController.getHome(), engine);

        System.out.println("Servidor iniciado!");

    }


}
