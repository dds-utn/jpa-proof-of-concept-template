package controllers;

import model.RepositorioConsultoras;
import spark.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeController {

    public ModelAndView getHome() {
        Map model = new HashMap();
        model.put("fecha",  new Date());
        model.put("consultoras", RepositorioConsultoras.instancia.listar().stream().limit(3).collect(Collectors.toList()));
        return new ModelAndView(model, "index.html.hbs");
    }
}
