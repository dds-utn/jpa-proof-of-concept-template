package controller;

import model.RepositorioUsuarios;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class SessionController {
  // TODO GRAN TODO: notar que las responsabildades
  // de saber si una personas está con sesión inciada,
  // de saber le usuarie actual, etc, probablmente se vayan a repetir
  // y convendrá generalizarlas

  public ModelAndView mostrarLogin(Request request, Response response) {

    Map<String, Object> modelo = new HashMap<>();
    return new ModelAndView(modelo, "formulario-login.html.hbs");
  }

  public Void crearSesion(Request request, Response response) {
    try {
      Usuario usuario = RepositorioUsuarios.instance().buscarPorUsuarioYContrasenia(
          request.queryParams("nombre"),
          request.queryParams("contrasenia"));

      request.session().attribute("user_id", usuario.getId());
      response.redirect("/"); // TODO aca va a convenir leer el origen
      return null;
    } catch (Exception e) {
      response.redirect("/login"); // TODO redirigir agregando un mensaje de error
      return null;
    }
  }
}
