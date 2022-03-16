package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.Emprunt;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import jdk.jshell.execution.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDaoH2 implements UserDao {
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
    public Utilisateur createUtilisateur(String nom, String prenom) {
        final Utilisateur emprunteur = new Emprunteur(nom, prenom);
        save(emprunteur);
        return emprunteur;
    }


    @Override
    public Utilisateur getUser(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Utilisateur utilisateur = em.find(Utilisateur.class, id);

        em.getTransaction().commit();
        em.close();

        return utilisateur;
    }

    @Override
    public void addUserToBibliotheque(Utilisateur utilisateur, Bibliotheque bibliotheque) {
        merge(utilisateur);
        merge(bibliotheque);
    }

    @Override
    public List<Emprunt> getListeEmprunts(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Emprunteur emprunteur = em.find(Emprunteur.class, id);

        return emprunteur.getEmprunts();
    }


}
