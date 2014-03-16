/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaire;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Christian
 */
@Stateless
public class GestionnaireUtilisateurs {

    @PersistenceContext(unitName = "ProjetWebPU")
    private EntityManager em;

    // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    public void creerUtilisateursDeTest() {
        creeUtilisateur("John", "Lennon", "jlennon");
        creeUtilisateur("Paul", "Mac Cartney", "pmc");
        creeUtilisateur("Ringo", "Starr", "rstarr");
        creeUtilisateur("Georges", "Harisson", "georgesH");
        creeUtilisateur("Jean", "Bon", "jBon");
        creeUtilisateur("Anne", "Orak", "aOrak");
        creeUtilisateur("Jon", "Bon Jovi", "jbj");
        creeUtilisateur("Eddie", "Van Halen", "evh");
        creeUtilisateur("Wolfgang", "Van Halen", "wvh");
        creeUtilisateur("David Lee", "Roth", "dlr");
        creeUtilisateur("Angus", "Young", "aYoung");
        creeUtilisateur("Malcolm", "Young", "mYoung");
        creeUtilisateur("Brian", "Johnson", "bJohnson");
        creeUtilisateur("Bon", "Scott", "ripBS");
        creeUtilisateur("Freddie", "Mercury", "fMercury");
        creeUtilisateur("Brian", "May", "bMay");
        creeUtilisateur("Phil", "Collins", "pCollins");
        creeUtilisateur("Ozzy", "Osbourne", "princeOfDarkness");
        creeUtilisateur("Tony", "Iommy", "fatherOfMetal");
        creeUtilisateur("Bruce", "Dickinson", "bDickinson");
        creeUtilisateur("Dave", "Murray", "dMurray");
        creeUtilisateur("Steven", "Taylor", "sTaylor");
        creeUtilisateur("Ronnie James", "Dio", "pleaseSendUsBackDio");
        creeUtilisateur("Zack", "Wylde", "zWylde");
        creeUtilisateur("Marc", "Knopfler", "mk");
        creeUtilisateur("Paul", "Stanley", "pStanley");
        creeUtilisateur("Gene", "Simmons", "bigTong");
        creeUtilisateur("David", "Gilmour", "DGilmour");
        creeUtilisateur("Mick", "Jagger", "MJagger");
        creeUtilisateur("Keith", "Richards", "KRichards");
        creeUtilisateur("Klaus", "Meine", "KMeine");
        creeUtilisateur("Gordon Matthew Thomas", "Sumner", "String");
        creeUtilisateur("Roger Daltrey", "Daltrey", "WhoAmI");
        creeUtilisateur("Steve", "Lukather", "SToto");
        creeUtilisateur("Saul", "Hudson", "Slash");
    }

    public Utilisateur creeUtilisateur(String nom, String prenom, String login) {
        Utilisateur u = new Utilisateur(nom, prenom, login);
        em.persist(u);
        return u;
    }

    // TODO à virer à terme
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
       
        if (q.getResultList().isEmpty()) {
            return null;
        }
        
        Utilisateur u = (Utilisateur) q.getSingleResult();

        u.setFirstname(prenom);
        u.setLastname(nom);

        em.persist(u);

        return u;
    }
    
    public Collection<Utilisateur> getListeUtilisateurs(int offset) {
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");

        q.setFirstResult(offset);
        q.setMaxResults(10);        
        return q.getResultList();
    }
    
    /**
     * Méthode permettant de récuperer le nombre d'utilisateur dans la BDD
     * @return 
     */
    public int getNbUtilisateur() {
        Query q = em.createQuery("select count(u) from Utilisateur u");
        return Integer.valueOf(q.getSingleResult().toString());
    }

    // pagination
    // q.setFirstResult(offset*nb)
    // q.setMaxResult(nb)
    public void persist(Object object) {
        em.persist(object);
    }
}
