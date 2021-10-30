package controllers;

import model.RepositorioUsuarios;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class SesionController {
  // TODO GRAN TODO: notar que las responsabildades
  // de saber si una personas está con sesión inciada,
  // de saber le usuarie actual, etc, probablmente se vayan a repetir
  // y convendrá generalizarlas

  public ModelAndView mostrarLogin(Request request, Response response) {
    if (request.session().attribute("user_id") != null) {
      response.redirect("/");
      return null;
    }
    Map<String, Object> modelo = new HashMap<>();
    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    return new ModelAndView(modelo, "formulario-login.html.hbs");
  }

  public Void crearSesion(Request request, Response response) {
    try {
      Usuario usuario = RepositorioUsuarios.instancia.buscarPorUsuarioYContrasenia(
              request.queryParams("username"),
              request.queryParams("password"));

      // dos opciones para guarda la información
      // de sessión
      // Servelet API
      // guardarlo en la cookie
      // esto NO lo haremos en Java, queda solo de forma conceptual
      // y para otras tecnologias con los recaudos de seguridad correspondientes
      // response.cookie("user_id", usuario.getId().toString());

      // guardarlo en la session de servelet (jsessionid)
      // en realidad esto también lo guarda en la cookie
      // pero de forma indirecta
      request.session().attribute("user_id", usuario.getId());

      response.redirect("/"); // TODO aca va a convenir leer el origen
      return null;
    } catch (NoSuchElementException e) {
      response.redirect("/login"); // TODO redirigir agregando un mensaje de error
      return null;
    }
  }
}
