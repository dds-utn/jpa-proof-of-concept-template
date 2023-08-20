package controllers;

import model.RepositorioConsultoras;
import spark.ModelAndView;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HomeController {

  public ModelAndView getHome() {
    Map<String, Object> modelo = new HashMap<>();
    modelo.put("anio", LocalDate.now().getYear());
    modelo.put("consultoras", RepositorioConsultoras.instancia.listar().subList(0, 3));

    return new ModelAndView(modelo, "index.html.hbs");
  }
}
