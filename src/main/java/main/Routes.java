package main;

import controllers.ConsultorasController;
import controllers.HomeController;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Date;

public class Routes {

    public static void main(String[] args) {


        System.out.println("Iniciando servidor...");
        Spark.port(9001);

        Spark.staticFileLocation("/public");

        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        HomeController homeController = new HomeController();
        ConsultorasController consultorasController = new ConsultorasController();

        System.out.println("Servidor iniciado!");
        DebugScreen.enableDebugScreen();

        Spark.get("/health", (req, res) -> "OK" + new Date());

        Spark.get("/", (request, response) -> homeController.getHome(), engine);
        Spark.get("/consultoras", (request, response) -> consultorasController.getConsultoras(request, response), engine);
        Spark.get("/consultoras/:id", (req, res) -> consultorasController.getDetalleConsultora(req, res, engine));
    }

}
