package controllers;

import model.RepositorioConsultoras;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HomeController {

    public ModelAndView getHome(Request request, Response response) {
        Map<String, Object> modelo = new HashMap<>();
        modelo.put("anio", LocalDate.now().getYear());
        modelo.put("consultoras", RepositorioConsultoras.instancia.listar().subList(0, 3));
        modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
        return new ModelAndView(modelo, "index.html.hbs");
    }
}
