import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
  public static void main(String[] args) {
    Spark.port(9000);
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    Spark.get("/",
            (request, response) ->
                    new ModelAndView( //1
                            request.queryParamOrDefault("nombre", "Mundo"),
                            "bienvenida.html.hbs"), //2
            engine); //3
  }
}