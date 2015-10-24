package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import model.Consultora;
import model.RepositorioConsultoras;

import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ConsultorasControllerTest extends AbstractPersistenceTest implements
    WithGlobalEntityManager {

  private ConsultorasController controlador;
  private Request request;
  private Response response;

  @Before
  public void setUp() {
    controlador = new ConsultorasController();
    request = mock(Request.class);
    response = mock(Response.class);
  }

  @Test
  public void crearSiElRequestContieneTodosLosParametrosCreaLaConsultora() {
    when(request.params("nombre")).thenReturn("2diseños");
    when(request.params("cantidadEmpleados")).thenReturn("90");

    controlador.crear(request, response);

    List<Consultora> consultoras = RepositorioConsultoras.instancia.listar();
    assertEquals(1, consultoras.size());

    Consultora consultora = consultoras.get(0);
    assertEquals(90, consultora.getCantidadEmpleados());
    assertEquals("2diseños", consultora.getNombre());
  }

  @Test
  public void mostrarSiExisteDevuelveLaConsultora() {
    Consultora consultora = new Consultora("foo", 30);
    RepositorioConsultoras.instancia.agregar(consultora);

    when(request.params("id")).thenReturn(String.valueOf(consultora.getId()));

    ModelAndView resultado = controlador.mostrar(request, response);

    assertSame(resultado.getModel(), consultora);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void listarSinParametrosDevuelveTodasLasConsultoras() {
    RepositorioConsultoras.instancia.agregar(new Consultora("foo", 30));
    RepositorioConsultoras.instancia.agregar(new Consultora("bar", 30));
    RepositorioConsultoras.instancia.agregar(new Consultora("baz foo", 32));

    ModelAndView resultado = controlador.listar(request, response);

    Map<String, Object> viewModel = (Map<String, Object>) resultado.getModel();
    assertEquals(((List<Consultora>) viewModel.get("consultoras")).size(), 3);
    assertEquals(viewModel.get("filtroNombre"), null);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void listarConParametrosDevuelveTodasLasConsultorasQueContienenElNombre() {
    RepositorioConsultoras.instancia.agregar(new Consultora("foo", 30));
    RepositorioConsultoras.instancia.agregar(new Consultora("bar", 2));
    RepositorioConsultoras.instancia.agregar(new Consultora("baz foo", 32));
    RepositorioConsultoras.instancia.agregar(new Consultora("goo", 33));

    when(request.params("filtroNombre")).thenReturn("foo");

    ModelAndView resultado = controlador.listar(request, response);

    Map<String, Object> viewModel = (Map<String, Object>) resultado.getModel();
    assertEquals(((List<Consultora>) viewModel.get("consultoras")).size(), 2);
    assertEquals(viewModel.get("filtroNombre"), "foo");
  }

}
