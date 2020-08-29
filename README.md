ORM
===


# 0. Recuperando lo visto

¿Qué recuerdan del apunte?

# 1. ¿Por qué necesito ORM?

## 1.1 Capa de abstracción

> Nota: el código está [acá](https://github.com/dds-utn/eg-equipos-futbol-jdbc-java)

Veamos un ejemplo de JDBC.

  * ¿Es una biblioteca o un framework?
  * Notemos el concepto de _driver_ (a qué nos suena).
  * Discutamos la necesidad de configuración.
  * ¿Es sencillo de programar y entender el código resultante?


> Nota técnica: bases servidor vs en memoria vs en archivo
>
> ```java
>  dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
>  dataSource.setUsername("sa");
>  dataSource.setPassword("");
>  dataSource.setUrl("jdbc:hsqldb:mem:sample-db-" + db);
> ```
>
> vs
>
> ```java
>  dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
>  dataSource.setUsername("sa");
>  dataSource.setPassword("");
>  dataSource.setUrl("jdbc:hsqldb:file:sample-db-" + db);
> ```

Moraleja: trabajar a un bajo nivel de abstracción usando directamente JDBC es tedioso y propenso a error.

## 1.2 Desadaptación de impedancia

> En electrónica adaptar o emparejar las impedancias, consiste en hacer que la impedancia de salida de un origen de señal,
> como puede ser una fuente de alimentación o un amplificador, sea igual a la impedancia de entrada de la carga a la cual se conecta.

Ehhh... no. No es esto. ¿Cuáles son las diferencias entre estos dos mundos?

 * tipos de datos
 * herencia
 * identidad


# 2. Mapeos básicos

> Nota: el código está [acá](https://github.com/dds-utn/jpa-proof-of-concept-template/tree/futbol)

## 2.1 Primero lo primero: dependencias

Vamos a necesitar de JPA/Hibernate....

> Nota técnica:
>
> * JPA es la interfaz
> * Hibernate la  implementación
>
> Creo que el mejor diagrama de la relación entre JPA-Hibernate-JDBC-DB en internet lo encontré [acá](https://thidoo.github.io/SpringBoot-JPA-And-Hibernate/)

... y de una base de datos, claro.

> Y también, entre bambalinas, vamos a necesitar a JDBC y el driver (conector) correspondiente.

Y también vamos a tener que configurarlo.

	* `persistence.xml`
  * Quizás también sean necesarias variables de entorno


## 2.2 Segundo lo segundo: el modelo

> Con ustedes... ¡un modelo de objetos!

Como van a ver, el modelo es bastante de objetos es bastante puro, no tiene absolutamente **nada** específico de la persistencia.


## 2.3 Pero no tan rápido, ¡anoten!

> * Nota 1: Para ver el código **ANTES** de este paso, ver la rama [`futbol-sin-mapeos`](https://github.com/dds-utn/jpa-proof-of-concept-template/tree/futbol-sin-mapeos)
> * Nota 2: Su nueva amiga, la [guía de anotaciones](https://docs.google.com/document/d/1jWtehhVCFYECKvpdcCxnEgWZFCv2fR2WPyUJSoiX3II/edit#heading=h.r09lefmcufkn)

1. Primero tenemos que decir cuáles clases son persistentes, con `@Entity`
2. Luego, tenemos que decirle a JPA dónde buscar esas anotaciones en el `persistence.xml`:

```xml
<class>utn.dds.persistencia.futbol.persistence.Jugador</class>
<class>utn.dds.persistencia.futbol.persistence.Formacion</class>
```

3. Ahora tenemos que crearles una clave primaria con `@Id`, y hacerla autoincremental (que es una posible estrategia
	 para hacerla surrogada) mediante `@GeneratedValue`

> Nota ~filosófica~ técnica de JPA: este herramienta está a mitad de camino entre _convención y configuración_.
> porque hay muchas cosas que las infiere del sistema de tipos, por ejemplo, mintras que otras hay que decirlas explícitamente.
> De todas formas, aún cuando haya valores por defecto, si queremos podemos configurar una gran cantidad de aspectos del mapeo.
>
> * `@Table`: por ejemplo, para cambiar el nombre de la tabla a plural
> * `@Column`: por ejemplo, para cambiar la capitalización o limitar la cantidad máxima de caracteres

4. Y llegó el momento de la verdad: a persistir con el `EntityManager`. Podemos verificar que haya funcionado mirando el log de Hibernate

```
Hibernate:
    insert
    into
        Jugador
        (id, nombre, posicion)
    values
        (default, ?, ?)
```


> Nota técnica: ¿y si voy a la base de datos, por qué no lo veo? Porque los tests son _transaccionales_, es decir que por defecto no se comitea

# 3. Relaciones.

* `@OneToMany` (relación "mentirosa", porque en realidad termina siendo una many-to-many; más adelante lo profundizaremos)
* `@ManyToOne`
* `@ManyToMany`

Y de yapa:

* `@Transient`, que nos permite ignorar un atributo (y por tanto, no se persitirá)

# 4. Identidad

> ¿Y vos quien sos?

## 4.1 Primera situación: un sólo objeto

```java
Jugador dani = new Jugador();
dani.setNombre("Dani");
dani.setPosicion("11");

dani.getId(); // inicialmente es null

entityManager().persist(dani); // hago persistible a dani

dani.getId(); // ahora es != null
```

## 4.2 Segunda situación: dos objetos


```java
// agregamos una nueva instancia:
Jugador caro = new Jugador();
caro.setNombre("Dani");
caro.setPosicion("11");

entityManager().persist(caro);

dani.getId(); // ahora es != null, y también != del id de dani
```

## 4.3 Tercera situación: trayendo los objetos de la base

```java
Jugador dani2 = entityManager().find(Jugador.class, dani.getId());

assertEquals(dani2.getId(), dani.getId()); // esto no debería resultar extraño
assertSame(dani2, dani); // y esto tampoco, al fin y al cabo estamos recuperando un objeto que ya tenemos, ¿no?

// ¿Perro qué pasa si en el medio se cierra el entity manager?
entityManager().close(); // esto pasará todo el tiempo en el contexto de una aplicación web

// o se "limpia"
entityManager().clear(); // esto no tiene tanto sentido en el contexto normal de una aplicación,
                         // pero es una forma menos "agresiva" de simular esta situación dentro de un test

Jugador dani3 = entityManager().find(Jugador.class, dani.getId());

assertEquals(dani3.getId(), dani.getId()); // bien
assertSame(dani3, dani); // ¡FALLA!
```

Conclusiones:
 1. al usar un ORM perdemos la identidad de los objetos. No debemos asumir que el objeto que obtendremos es la misma instancia que guardamos
 2. el entity manager hace las veces de caché (porque mientras una instancia de EntityManager esté abierta y
    no se borre su contexto mediante `clear`, mantiene referencias a los objetos que se persistieron
    a través ellas)

> Nota técnica: Hay formas de paliar la pérdida de indentidad, ver por ejemplo el
> [ciclo de vida de  un objeto dentro del entity manager](https://www.objectdb.com/java/jpa/persistence/managed)
> pero en el contexto de una aplicación web no es tan común recurrir a ellas


# 5. Esquemas

> Ver https://github.com/uqbar-project/jpa-java8-extras#schema-generation

Si ejecutamos la clase `org.uqbarproject.jpa.java8.extras.export.JpaSchemaExport` con
los argumentos `db schema.sql true true` nos generará un archivo `schema.sql` con un esquema como el siguiente:

```sql
create table Equipo (
    id bigint generated by default as identity (start with 1),
    cantidadAfiliados bigint,
    nombre varchar(255),
    primary key (id)
)

create table Formacion (
    id bigint generated by default as identity (start with 1),
    goles bigint,
    equipo_id bigint,
    primary key (id)
)

create table Jugador (
    id bigint generated by default as identity (start with 1),
    nombre varchar(255),
    posicion varchar(255),
    primary key (id)
)

alter table Formacion
    add constraint FK_igvpmtq73a5lqlpvsdjf8t7ct
    foreign key (equipo_id)
    references Equipo
```
