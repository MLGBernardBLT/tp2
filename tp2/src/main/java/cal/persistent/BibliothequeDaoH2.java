package cal.persistent;

import cal.model.Bibliotheque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BibliothequeDaoH2 implements BibliothequeDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");

    @Override
    public <T> void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createBibliotheque(String nom) {
        final Bibliotheque bibliotheque = new Bibliotheque(nom);
        save(bibliotheque);
        return bibliotheque.getId();
    }
}
