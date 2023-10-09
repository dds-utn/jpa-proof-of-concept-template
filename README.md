QMP 8
====

Llegó el momento tan ansiado: ¡construir la interfaz de QMP! Basándonos en los requerimientos de [QMP7](https://docs.google.com/document/d/1ERlDghk47Yc1_V1SQ7oCnZAC4bubHx7ZhQXS3naKMJA/edit), queremos:

* Como usuarie de QueMePongo, quiero poder entrar a `/` y encontrar una breve descripción del sitio
* Como usuarie de QueMePongo, desde `/` quiero contar con un botón de login, que me permita iniciar sesión
  * Nota: inicialmente no nos interesará contar con un botón de creación de cuenta, sólo iniciaremos sesión con cuentas existentes
* Como usuarie de QueMePongo, tras realizar el login, deseo llego a `/guardarropas`, donde encontraré un listado de todos mis guardarropas
* Como usuarie de QueMePongo, desde `/guardarropas`, deseo poder navegar a `/guardarropas/:id`, donde encontraré el detalle del guardarropas y el listado de prendas que contiene.
* **Bonus**:  Como usuario de QueMePongo, quiero poder empezar a crear una prenda en mi guardarropas desde el detalle del guardarropa.
* **Bonus**: Como usuarie de QueMePongo quiero poder seleccionar una prenda desde el detalle del guardarropas y navegar hacia `/prendas/:id`, donde encontraré el detalle de la misma.
* **Bonus**: Como usuarie de QueMePongo, quiero poder eliminar una prenda desde el detalle de la misma.

En este repositorio encontrarás las clases `Guardarropa`, `Prenda`, `Usuario` y `Color`. Las mismas ya están anotadas y listas para ser usadas.

## Nota de clase

Estamos trabajando en aulas partidas en este ejercicio:

https://github.com/dds-utn/jpa-proof-of-concept-template/tree/qmp-web

Elijan un aula de su gusto (idealmente, mínimo de a dos personas) y comiencen a trabajar en el ejercicio
Iremos pasando por las aulas durante la clase.
Sugerencia:
  - dejar el login para el final.
  - concentrarse en, primero, la navegación, y segundo, en la UI y usabilidad

Después de clase, no se olviden de ver el video de manejo de sesión y transacciones
que está subido a la clase de hoy en el webcampus. 
