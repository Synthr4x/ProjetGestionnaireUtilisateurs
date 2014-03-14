package utilisateurs.gestionnaires;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modele.Utilisateur;

@Stateless
public class GestionnaireUtilisateurs {
    @PersistenceContext(unitName = "TP2_-_WebPU")
    private EntityManager em;

    // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    

    public void creerUtilisateursDeTest() {
        creeUtilisateur("John", "Lennon", "jlennon");
        creeUtilisateur("Paul", "Mac Cartney", "pmc");
        creeUtilisateur("Ringo", "Starr", "rstarr");
        creeUtilisateur("Georges", "Harisson", "georgesH");
    }

    public Utilisateur creeUtilisateur(String nom, String prenom, String login) {
        Utilisateur u = new Utilisateur(nom, prenom, login);
        em.persist(u);
        return u;
    }

    public Collection<Utilisateur> getAllUsers() {
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");
        return q.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose  
    // "Insert Code > Add Business Method")  

    public Collection<Utilisateur> getUtilisateurByLogin(String login) {

        Query q = em.createQuery("select u from Utilisateur u where u.login=:param");
        q.setParameter("param", login);
        return q.getResultList();
    }

    public Utilisateur majUtilisateur(String login, String nom, String prenom) {
        Query q = em.createQuery("select u from Utilisateur u where u.login=:param");
        q.setParameter("param", login);

        Utilisateur u = (Utilisateur) q.getSingleResult();
        
        u.setFirstname(prenom);
        u.setLastname(nom);
        
        em.persist(u);
        
        return u;
    }
    
    // pagination
    // q.setFirstResult(offset*nb)
    // q.setMaxResult(nb)

    public void persist(Object object) {
        em.persist(object);
    }
}
