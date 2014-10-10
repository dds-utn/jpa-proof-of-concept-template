package db;

import javax.persistence.Query;

public interface EntityManagerOps extends WithEntityManager {

   default void persist(Object entity) {
      entityManager().persist(entity);
   }

   default void remove(Object entity) {
      entityManager().remove(entity);
   }

   default <T> T find(Class<T> entityClass, Object primaryKey) {
      return entityManager().find(entityClass, primaryKey);
   }

   default Query createQuery(String qlString) {
      return entityManager().createQuery(qlString);
   }

}
