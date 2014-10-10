package db;

import javax.persistence.EntityManager;

public interface WithEntityManager {

   EntityManager entityManager();
}
