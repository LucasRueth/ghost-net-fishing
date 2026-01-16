package de.iu.ipwa.ghostnetfishing.repository;

import de.iu.ipwa.ghostnetfishing.model.Geisternetz;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@ApplicationScoped
public class GeisternetzRepository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ghostnetPU");

    public void save(Geisternetz netz) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            if (netz.getId() == null) {
                em.persist(netz);
            } else {
                em.merge(netz);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Geisternetz findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Geisternetz.class, id);
        } finally {
            em.close();
        }
    }

    public List<Geisternetz> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT g FROM Geisternetz g", Geisternetz.class
            ).getResultList();
        } finally {
            em.close();
        }
    }
}
