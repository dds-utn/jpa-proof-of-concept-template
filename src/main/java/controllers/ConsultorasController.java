package controllers;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import model.Consultora;
import model.RepositorioConsultoras;
import model.RepositorioUsuarios;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultorasController implements WithSimplePersistenceUnit {

  public ModelAndView getConsultoras(Request request, Response response) {
    String nombreBuscado = request.queryParams("filtro");
    Map<String, Object> modelo = new HashMap<>();

    List<Consultora> consultorasMostradas =
        nombreBuscado != null ?
            RepositorioConsultoras.instancia.buscarPorNombre(nombreBuscado) :
            RepositorioConsultoras.instancia.listarSegunEmpleados();

    modelo.put("consultoras", consultorasMostradas);

    return new ModelAndView(modelo, "consultoras.html.hbs");
  }

  public Object getDetalleConsultora(Request request, Response response, TemplateEngine engine) {
    String id = request.params(":id");
    try {
      Consultora consultora = RepositorioConsultoras.instancia.buscar(Integer.parseInt(id));
      return consultora != null ?
          engine.render(new ModelAndView(consultora, "detalle-consultora.html.hbs"))
          : null;
    } catch (NumberFormatException e) {
      response.status(400);
      System.out.println("El id ingresado (" + id + ") no es un número");
      return "Bad Request";
    }
  }

  public Void crearConsultora(Request request, Response response) {
    String nombre = request.queryParams("nombre");
    Integer cantidadEmpleados = Integer.parseInt(request.queryParams("cantEmpleados"));

    Usuario usuario = getUsuarioLogueado(request);

    if (usuario != null) {
      response.redirect("/login");
    }

    Consultora nueva = new Consultora(nombre, cantidadEmpleados);

    withTransaction(() -> {
      RepositorioConsultoras.instancia.agregar(nueva);
      usuario.agregarConsultora(nueva);
    });

    response.redirect("/consultoras/" + nueva.getId());
    return null;
  }

  public ModelAndView getFormularioCreacion(Request request, Response response) {
    if (!estaLogueado(request, response)) {
      response.redirect("/login");
    }

    return new ModelAndView(null, "formulario-creacion.html.hbs");
  }

  private boolean estaLogueado(Request request, Response response) {
    Usuario usuario = getUsuarioLogueado(request);

    return usuario != null;
  }

  private Usuario getUsuarioLogueado(Request request) {
    Long idUsuario = request.session().attribute("idUsuario");

    Usuario usuario = null;

    if (idUsuario != null) {
      usuario = RepositorioUsuarios.instancia.getById(idUsuario);
    }

    return usuario;
  }
}
