package db;

import java.util.function.Supplier;

import javax.persistence.EntityTransaction;

public interface TransactionalOps extends WithEntityManager {

   default void withTransaction(Runnable action) {
      withTransaction(() -> {
         action.run();
         return null;
      });
   }

   default <A> A withTransaction(Supplier<A> action) {
      beginTransaction();
      try {
         A result = action.get();
         commitTransaction();
         return result;
      } catch (Throwable e) {
         rollbackTransaction();
         throw e;
      }
   }

   default void beginTransaction() {
      EntityTransaction tx = entityManager().getTransaction();

      if (!tx.isActive()) {
         tx.begin();
      }
   }

   default void commitTransaction() {
      EntityTransaction tx = entityManager().getTransaction();
      if (tx.isActive()) {
         tx.commit();
      }
   }

   default void rollbackTransaction() {
      EntityTransaction tx = entityManager().getTransaction();
      if (tx.isActive()) {
         tx.rollback();
      }
   }
}
