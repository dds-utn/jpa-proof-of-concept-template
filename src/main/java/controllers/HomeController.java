package controllers;

import spark.Request;
import spark.Response;

public class HomeController {
  public Void index(Request request, Response response) {
    response.redirect("/bienvenida");
    return null;
  }
}
