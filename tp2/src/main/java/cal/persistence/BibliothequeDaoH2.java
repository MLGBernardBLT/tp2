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
    public Emprunteur getEmprunteur(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Emprunteur emprunteur = em.find(Emprunteur.class, id);

        em.getTransaction().commit();
        em.close();
        return emprunteur;


    }

    @Override
    public Bibliotheque getBibliothequeAvecUtilisateur(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Bibliotheque> query = em.createQuery(
                "SELECT b from Bibliotheque b LEFT JOIN FETCH b.utilisateurs bu WHERE b.id = :bibliothequeId"
                , Bibliotheque.class);
        query.setParameter("bibliothequeId", id);
        final Bibliotheque bibliotheque = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return bibliotheque;
    }
}
