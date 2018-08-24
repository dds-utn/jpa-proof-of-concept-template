package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Alumno {

	@Id @GeneratedValue
	private Long id;
	
	private String legajo;
	private String nombre;
	private String apellido;
	private String secretCode;
	private String email;
	private String githubUser;
	
	@OneToMany
	@JoinColumn(name = "alumno_id")
	private List<Asignacion> asignaciones = new ArrayList<>();
	
	@SuppressWarnings("unused")
	private Alumno() {}
	
	public Alumno(String legajo, String nombre, String email, String githubUser, String apellido, String secretCode) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.email = email;
		this.githubUser = githubUser;
		this.apellido = apellido;
		this.secretCode = secretCode;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
	
	public void asignarTarea(Tarea tarea) {
		this.asignaciones.add(new Asignacion(tarea));
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithubUser() {
		return githubUser;
	}

	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}

}
