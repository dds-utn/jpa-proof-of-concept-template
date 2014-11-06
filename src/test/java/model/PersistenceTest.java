package model;

import static db.EntityManagerHelper.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.EntityManagerHelper;

public class PersistenceTest {

   @Before
   public void before() {
      beginTransaction();
   }

   @After
   public void after() {
      rollback();
   }

   @Test
   public void testName() throws Exception {
      Pollera pollera = new Pollera(new Importada(), 100, null, 10);
      
      entityManager().persist(pollera);
   }
}
