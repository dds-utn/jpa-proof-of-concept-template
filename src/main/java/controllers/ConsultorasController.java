package controllers;

import model.Consultora;
import model.RepositorioConsultoras;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultorasController {

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
        try{
            Consultora consultora = RepositorioConsultoras.instancia.buscar(Integer.parseInt(request.params(":id")));
            return consultora != null ?
                    engine.render(new ModelAndView(consultora, "detalle-consultora.html.hbs"))
                    : null;
        } catch(NumberFormatException e){
            response.status(400);
            return "Bad Request";
        }
    }

    public ModelAndView crearConsultora(Request request, Response response) {
        //TODO: Completar
        return null;
    }
}
