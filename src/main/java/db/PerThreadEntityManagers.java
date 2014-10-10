package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PerThreadEntityManagers {

   private static EntityManagerFactory emf;

   private static ThreadLocal<EntityManager> threadLocal;

   static {
      try {
         emf = Persistence.createEntityManagerFactory("db");
         threadLocal = new ThreadLocal<>();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static EntityManager getEntityManager() {
      EntityManager manager = threadLocal.get();
      if (manager == null || !manager.isOpen()) {
         manager = emf.createEntityManager();
         threadLocal.set(manager);
      }
      return manager;
   }

   public static void closeEntityManager() {
      EntityManager em = threadLocal.get();
      threadLocal.set(null);
      em.close();
   }
}
