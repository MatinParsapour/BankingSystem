package util;

import javax.persistence.EntityManager;

public class ApplicationContext {

    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    }
}
