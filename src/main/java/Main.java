import spark.Spark;

public class Main {
  public static void main(String[] args) {
    Spark.port(9000);
    Spark.get("/", (request, response) -> 
                      "<h1>¡Hola mundo!</h1>" 
                    + "<p>Esta es nuestra primera respuesta HTML</p>");
  }
}
