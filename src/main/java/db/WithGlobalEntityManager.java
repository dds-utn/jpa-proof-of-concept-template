package db;

import javax.persistence.EntityManager;

public interface WithGlobalEntityManager  extends WithEntityManager {
   
   default EntityManager entityManager() {
      return PerThreadEntityManagers.getEntityManager();
   }
   

}
