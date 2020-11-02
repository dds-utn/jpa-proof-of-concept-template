package controllers;

import model.RepositorioConsultoras;
import model.RepositorioUsuarios;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UsuariosController {


    public ModelAndView getFormularioLogin(Request request, Response response) {
        return new ModelAndView(null, "formulario-login.html.hbs");
    }

    public Void iniciarSesion(Request request, Response response) {
        String password = request.queryParams("password");
        String username = request.queryParams("username");
        Usuario usuario = RepositorioUsuarios.instancia.listar().stream()
                .filter(u -> u.getPassword().equals(password) && u.getUsername().equals(username)).findFirst().get();

        request.session().attribute("idUsuario", usuario.getId());

        response.redirect("/");

        return null;

    }
}
