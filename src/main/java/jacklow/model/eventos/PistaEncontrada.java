package jacklow.model.eventos;

public class PistaEncontrada extends Evento {
	private String descripcion;

	public PistaEncontrada(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}
