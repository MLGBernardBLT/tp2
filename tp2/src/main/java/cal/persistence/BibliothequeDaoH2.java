package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
    public <T> void merge(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createBibliotheque(String nom) {
        final Bibliotheque bibliotheque = new Bibliotheque(nom);
        save(bibliotheque);
        return bibliotheque.getId();
    }

    @Override
    public long createEmprunteur(String nom, String prenom) {
        final Utilisateur utilisateur = new Emprunteur(nom, prenom);
        save(utilisateur);
        return utilisateur.getId();
    }

    @Override
    public Emprunteur getEmprunteurAvecBibliotheque(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Emprunteur> query = em.createQuery(
                "SELECT e from Emprunteur e LEFT JOIN FETCH e.bibliotheque eb WHERE e.id = :emprunteurId"
                , Emprunteur.class);
        query.setParameter("emprunteurId", id);
        final Emprunteur emprunteur = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return emprunteur;
    }

    @Override
    public Bibliotheque getBibliotheque(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Bibliotheque bibliotheque = em.find(Bibliotheque.class, id);

        em.getTransaction().commit();
        em.close();
        return bibliotheque;
    }
}
