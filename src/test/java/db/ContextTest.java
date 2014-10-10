package db;

import java.util.List;

import model.Alumno;
import model.Cursada;
import model.Materia;
import model.MateriaElectiva;
import model.MateriaObligatoria;
import model.Nota;

import org.junit.Test;

import static db.EntityManagerHelper.*;

public class ContextTest {

	@Test
	public void contextUp() {
		EntityManagerHelper.getEntityManager();
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		EntityManagerHelper.withTransaction(() -> {});
	}
	

	   @Test
	   public void testName() throws Exception {
	      Alumno alumno = new Alumno();
	      Nota primerParcial = new Nota();
	      Nota segundoParcial = new Nota();

	      persist(segundoParcial);
	      persist(primerParcial);

	      Cursada cursada = new Cursada();
	      cursada.getNotas().add(primerParcial);
	      cursada.getNotas().add(segundoParcial);
	      persist(cursada);

	      alumno.getCursadas().add(cursada);

	      persist(alumno);
	   }

	   @Test
	   public void testHerencia() throws Exception {
	      Materia am2 = new MateriaObligatoria("Analisis Matemático 2", true);
	      Materia tgc = new MateriaElectiva("Técnicas Gráficas");

	      persist(am2);
	      persist(tgc);

	      List<Materia> resultList = createQuery("from Materia").getResultList();
	   }
}
