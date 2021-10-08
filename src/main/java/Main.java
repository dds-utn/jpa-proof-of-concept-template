import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
  public static void main(String[] args) {
    Spark.port(9000);
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    Spark.get("/",
            (request, response) -> {
              response.redirect("/bienvenida");
              return null;
            },
            engine);

    Spark.get("/bienvenida",
            (request, response) ->
                    new ModelAndView(
                            request.queryParamOrDefault("nombre", "Mundo"),
                            "bienvenida.html.hbs"),
            engine);

    Spark.get("/despedida",
            (request, response) ->
                    new ModelAndView(
                            request.queryParamOrDefault("nombre", "Mundo"),
                            "despedida.html.hbs"),
            engine);
  }
}