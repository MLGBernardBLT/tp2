package cal.persistence;

import cal.model.Emprunt;
import cal.model.document.Document;
import cal.model.utilisateur.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class EmpruntDaoH2 implements EmpruntDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");

    @Override
    public <T> void save(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public <T> void merge(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Emprunt createEmprunt(Utilisateur user, List<Document> documents, LocalDateTime dateEmprunt, LocalDateTime dateRetourMax) {
        final Emprunt emprunt = new Emprunt(user, documents, dateEmprunt, dateRetourMax);
        for (Document document : documents) {
            if (!empruntPossible(document)) {
                return null;
            }
            document.pretExemplaire();
            merge(document);
        }
        save(emprunt);
        return emprunt;
    }

    private boolean empruntPossible(Document document) {
        if (document.getExemplaires() <= 0) {
            return false;
        }
        return true;
    }
}
