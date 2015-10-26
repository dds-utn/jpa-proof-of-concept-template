package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import model.Consultora;
import model.RepositorioConsultoras;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ConsultorasController implements WithGlobalEntityManager, TransactionalOps {

  public ModelAndView nuevo(Request request, Response response) {
    return new ModelAndView(null, "consultora-nueva.hbs");
  }

  public Void crear(Request request, Response response) {
    String nombre = request.queryParams("nombre");
    int cantidadEmpleados = Integer.parseInt(request.queryParams("cantidadEmpleados"));

    withTransaction(() -> {
      RepositorioConsultoras.instancia.agregar(new Consultora(nombre, cantidadEmpleados));
    });

    response.redirect("/consultoras");
    return null;
  }

  public ModelAndView listar(Request request, Response response) {
    List<Consultora> consultoras;

    String filtroNombre = request.queryParams("filtroNombre");
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
    long id = Long.parseLong(request.params(":id"));

    Consultora consultora = RepositorioConsultoras.instancia.buscar(id);

    return new ModelAndView(consultora, "consultora.hbs");
  }

}
