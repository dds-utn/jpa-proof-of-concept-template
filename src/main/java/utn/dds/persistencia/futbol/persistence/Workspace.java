package utn.dds.persistencia.futbol.persistence;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import utn.dds.persistencia.futbol.persistence.difusion.Difusion;
import utn.dds.persistencia.futbol.persistence.difusion.PagarParaVer;
import utn.dds.persistencia.futbol.persistence.difusion.TVPublica;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;
import java.util.List;

public class Workspace {

    public static void main(String[] args) {

        EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(new PagarParaVer());
        entityManager.persist(new PagarParaVer());
        entityManager.persist(new TVPublica());
        tx.commit();

        List<Difusion> difusiones = entityManager.createQuery("from Difusion").getResultList();

        for (Difusion difusion: difusiones) {
            System.out.println(difusion.getClass() + " " + difusion.getId());
        }

        List<Difusion> difusiones2 = entityManager.createQuery("from TVPublica").getResultList();


        entityManager.close();
    }
}
