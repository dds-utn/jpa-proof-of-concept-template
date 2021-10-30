package main;

import controllers.ConsultorasController;
import controllers.HomeController;
import controllers.SesionController;
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
        SesionController sesionController = new SesionController();

        Spark.get("/", homeController::getHome, engine);

        Spark.get("/consultoras", consultorasController::getConsultoras, engine);

        Spark.get("/consultoras/nueva", consultorasController::getFormularioCreacion,engine);
        Spark.get("/consultoras/:id", (request, response) -> consultorasController.getDetalleConsultora(request, response, engine));
        Spark.post("/consultoras", (request, response) -> consultorasController.crearConsultora(request, response));

        Spark.get("/login", sesionController::mostrarLogin, engine);
        Spark.post("/login", sesionController::crearSesion);

        Spark.after((request, response) ->  {
            // TODO franco se los pasa
            //PerThreadEntityManagers.closeEntityManager();;
        });

        System.out.println("Servidor iniciado!");
    }


}
