package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class SaludoController {
  public ModelAndView bienvenida(Request request, Response response) {
    return new ModelAndView(
            request.queryParamOrDefault("nombre", "Mundo"),
            "bienvenida.html.hbs");
  }

  public ModelAndView despedida(Request request, Response response) {
    return new ModelAndView(
            request.queryParamOrDefault("nombre", "Mundo"),
            "despedida.html.hbs");
  }
}
