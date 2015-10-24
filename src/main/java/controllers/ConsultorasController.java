package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import model.Consultora;
import model.RepositorioConsultoras;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ConsultorasController {

  public ModelAndView nuevo(Request request, Response response) {
    return new ModelAndView(null, "consultora-nueva.hbs");
  }

  public Void crear(Request request, Response response) {
    String nombre = request.params("nombre");
    int cantidadEmpleados = Integer.parseInt(request.params("cantidadEmpleados"));

    RepositorioConsultoras.instancia.agregar(new Consultora(nombre, cantidadEmpleados));

    response.redirect("/consultoras");
    return null;
  }

  public ModelAndView listar(Request request, Response response) {
    List<Consultora> consultoras;
    
    
    String filtroNombre = request.params("filtroNombre");
    if (Objects.isNull(filtroNombre) || filtroNombre.isEmpty()) {
      consultoras = RepositorioConsultoras.instancia.listar();
    } else {
      consultoras = RepositorioConsultoras.instancia.buscarPorNombre(filtroNombre);
    }

    HashMap<String, Object> viewModel = new HashMap<>();
    viewModel.put("consultoras", consultoras);
    viewModel.put("filtroNombre", filtroNombre);
    
    
    return new ModelAndView(viewModel, "consultoras.hbs");
  }

  public ModelAndView mostrar(Request request, Response response) {

    Consultora consultora = RepositorioConsultoras.instancia.buscar(Long.parseLong(request
        .params("id")));

    return new ModelAndView(consultora, "consultora.hbs");
  }

}
