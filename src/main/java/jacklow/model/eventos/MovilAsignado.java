package jacklow.model.eventos;

import jacklow.model.Movil;

public class MovilAsignado extends Evento {
	
	private Movil movil;

	public Movil getMovil() {
		return movil;
	}

	public MovilAsignado(Movil movil) {
		super();
		this.movil = movil;
	}

}
