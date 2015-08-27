package controllers;

import java.util.HashMap;
import java.util.List;

import model.Consultora;
import model.RepositorioConsultoras;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ConsultorasController {

  public ModelAndView listar(Request request, Response response) {
    List<Consultora> consultoras = 
        RepositorioConsultoras.instancia.listar();
    
    HashMap<String, Object> viewModel = new HashMap<>();
    viewModel.put("consultoras", consultoras);
    viewModel.put("cantidadConsultoras", consultoras.size());

    return new ModelAndView(viewModel, "consultoras.hbs");
  }
  
  public ModelAndView mostrar(Request request, 
      Response response) {

    Consultora consultora = 
        RepositorioConsultoras.instancia.buscar(
            Long.parseLong(request.params("id")));    
    
    return new ModelAndView(consultora, "consultora.hbs");
  }

}
