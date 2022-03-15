package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.utilisateur.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoH2 implements UserDao{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");

    @Override
    public Utilisateur save(Utilisateur user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();
        em.close();

        return user;
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


}
