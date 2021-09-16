package main;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import controllers.ConsultorasController;
import controllers.HomeController;
import controllers.UsuariosController;
import model.Consultora;
import model.RepositorioConsultoras;
import spark.ModelAndView;
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
        UsuariosController usuariosController = new UsuariosController();

        Spark.get("/", (request, response) -> homeController.getHome(), engine);

        Spark.get("/consultoras", consultorasController::getConsultoras, engine);

        Spark.get("/consultoras/nueva", consultorasController::getFormularioCreacion,engine);

        Spark.get("/consultoras/:id", (request, response) -> consultorasController.getDetalleConsultora(request, response, engine));

        Spark.post("/consultoras", (request, response) -> consultorasController.crearConsultora(request, response));

        Spark.get("/login", (request, response) -> usuariosController.getFormularioLogin(request, response), engine);

        Spark.post("/login", (request, response) -> usuariosController.iniciarSesion(request, response));

        System.out.println("Servidor iniciado!");

    }


}
