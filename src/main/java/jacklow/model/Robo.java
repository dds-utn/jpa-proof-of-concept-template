package jacklow.model;

import java.time.LocalDateTime;

public class Robo {

	private LocalDateTime fecha;
	private String denunciante;
	private String operador;
	private String zona;
	private String codigoDenuncia;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDenunciante() {
		return denunciante;
	}

	public String getOperador() {
		return operador;
	}

	public String getZona() {
		return zona;
	}

	public String getCodigoDenuncia() {
		return codigoDenuncia;
	}

}
