import controllers.HomeController;
import controllers.SaludoController;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
  public static void main(String[] args) {
    Spark.port(9000);
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    HomeController home = new HomeController();
    SaludoController saludo = new SaludoController();

    Spark.get("/", home::index);
    Spark.get("/bienvenida", saludo::bienvenida, engine);
    Spark.get("/despedida", saludo::despedida, engine);
  }
}