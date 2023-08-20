package controller;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import model.Consultora;
import model.RepositorioConsultoras;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ConsultorasController implements WithSimplePersistenceUnit {


  public ModelAndView nueva(Request request, Response response) {
    return new ModelAndView(null, "nuevaConsultora.html.hbs");
  }

  public ModelAndView buscar(Request request, Response response) {
    Consultora consultora = RepositorioConsultoras.instancia.buscar(Long.parseLong(request.params("id")));
    return new ModelAndView(consultora, "consultora.html.hbs");
  }

  public Void crear(Request request, Response response) {
    withTransaction(() -> {
      Consultora consultora = new Consultora(request.queryParams("nombre"), Integer.parseInt(request.queryParams("cantidadEmpleados")));
      RepositorioConsultoras.instancia.agregar(consultora);
    });
    response.redirect("/");
    return null;
  }

  public ModelAndView listar(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();
    modelo.put("anio", LocalDate.now().getYear());
    modelo.put("consultoras", RepositorioConsultoras.instancia.listar());
    return new ModelAndView(modelo, "index.html.hbs");
  }
}
