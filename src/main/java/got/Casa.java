package got;

import java.util.Collection;

public class Casa {
    private String nombre;
    private int patrimonio;
    private int anioFundacion;
    private Casa vasallaDe;
    private Collection<FuerzaMilitar> fuerzasMilitares;
    private Lugar origen;
    public String nombreLugarOrigen() {
        return origen.getNombre();

    }
}
