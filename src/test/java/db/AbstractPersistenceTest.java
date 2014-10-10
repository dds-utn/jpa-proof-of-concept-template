package db;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractPersistenceTest implements WithGlobalEntityManager, TransactionalOps,
      EntityManagerOps {

   @Before
   public void setup() {
      beginTransaction();
   }

   @After
   public void tearDown() {
      rollbackTransaction();
   }

}
