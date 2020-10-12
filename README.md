# Próximos pasos

1. En la página principal (`/`) se están mostrando todas las consultoras. En su lugar, mostrar las primeras 3.
1. Crear una página en la que se listen todas las consultoras (`/consultoras`), ordenadas según la cantidad de empleades, y agregar un enlace (`<a>`) desde la página principal (`/`) hasta este listado.
2. Crear una página en la que se listen los detalles de una consultura (`/consultoras/:id`), en la que se muestre su nombre, cantidad de empleades y se listen los nombres de los 3 últimos proyectos. Agregar un enlace a esta página desde cada consultora en el listado de consultoras (`/consultoras`).


# Sugerencias

* Es posible declarar mútliples rutas dentro de `Routes.java` usando varias veces `Spark.get`
* Para consultar el valor de un parámetro de la ruta (`:algo`) se puede usar el mensaje `params`: `request.params(":algo")`. Este paraḿetro es devuelto como string.
* Es _deseable_ que intentes llevar la lambda que pasás a cada `get` para evitar incurrir en un [`long-method`](https://refactoring.guru/smells/long-method)
* Recordá que además de diccionarios, a un `ModelAndView` podés pasarle un objeto de dominio y consultar sus propiedades en el archivo `hbs` mediante `{{propiedad}}`.
