package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class SaludoController {
  public ModelAndView bienvenida(Request request, Response response) {
    return new ModelAndView(leerNombre(request), "bienvenida.html.hbs");
  }

  public ModelAndView despedida(Request request, Response response) {
    return new ModelAndView(leerNombre(request), "despedida.html.hbs");
  }

  public String leerNombre(Request request) {
    return request.queryParamOrDefault("nombre", "Mundo");
  }
}
