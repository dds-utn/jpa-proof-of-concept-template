package controllers;

import model.Consultora;
import model.RepositorioConsultoras;
import model.RepositorioUsuarios;
import model.Usuario;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ConsultorasController implements WithGlobalEntityManager, TransactionalOps {

    public ModelAndView getConsultoras(Request request, Response response) {
        String nombreBuscado = request.queryParams("filtro");
        Map<String, Object> modelo = new HashMap<>();

        List<Consultora> consultorasMostradas =
                nombreBuscado != null ?
                        RepositorioConsultoras.instancia.buscarPorNombre(nombreBuscado) :
                        RepositorioConsultoras.instancia.listarSegunEmpleados();

        modelo.put("consultoras", consultorasMostradas);
        modelo.put("filtro", nombreBuscado);
        return new ModelAndView(modelo, "consultoras.html.hbs");
    }

    public Object getDetalleConsultora(Request request, Response response, TemplateEngine engine) {
        String id = request.params(":id");
        try{
            Consultora consultora = RepositorioConsultoras.instancia.buscar(Integer.parseInt(id));
            return consultora != null ?
                    engine.render(new ModelAndView(consultora, "detalle-consultora.html.hbs"))
                    : null;
        } catch(NumberFormatException e){
            response.status(400);
            System.out.println("El id ingresado (" + id +") no es un número");
            return "Bad Request";
        }
    }

    public Void crearConsultora(Request request, Response response) {
        String nombre = request.queryParams("nombre");
        Integer cantidadEmpleados = Integer.parseInt(request.queryParams("cantEmpleados"));


        Consultora nueva = new Consultora(nombre,cantidadEmpleados);

        withTransaction(() -> {
            RepositorioConsultoras.instancia.agregar(nueva);
        });

        response.redirect("/consultoras/" + nueva.getId());
        return null;
    }

    public ModelAndView getFormularioCreacion(Request request, Response response) {
        if (request.session().attribute("user_id") == null) {
            response.redirect("/login?orign=/consultoras/nueva");
            return null;
        }

        return new ModelAndView(null, "formulario-creacion.html.hbs");
    }

}
