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
        creeUtilisateur("John", "Lennon", "jlennon", "admin");
        creeUtilisateur("Paul", "Mac Cartney", "pmc", "admin");
        creeUtilisateur("Ringo", "Starr", "rstarr", "admin");
        creeUtilisateur("Georges", "Harisson", "georgesH", "admin");
        creeUtilisateur("Jean", "Bon", "jBon", "admin");
        creeUtilisateur("Anne", "Orak", "aOrak", "admin");
        creeUtilisateur("Jon", "Bon Jovi", "jbj", "admin");
        creeUtilisateur("Eddie", "Van Halen", "evh", "admin");
        creeUtilisateur("Wolfgang", "Van Halen", "wvh", "admin");
        creeUtilisateur("David Lee", "Roth", "dlr", "admin");
        creeUtilisateur("Angus", "Young", "aYoung", "admin");
        creeUtilisateur("Malcolm", "Young", "mYoung", "admin");
        creeUtilisateur("Brian", "Johnson", "bJohnson", "admin");
        creeUtilisateur("Bon", "Scott", "ripBS", "admin");
        creeUtilisateur("Freddie", "Mercury", "fMercury", "admin");
        creeUtilisateur("Brian", "May", "bMay", "admin");
        creeUtilisateur("Phil", "Collins", "pCollins", "admin");
        creeUtilisateur("Ozzy", "Osbourne", "princeOfDarkness", "admin");
        creeUtilisateur("Tony", "Iommy", "fatherOfMetal", "admin");
        creeUtilisateur("Bruce", "Dickinson", "bDickinson", "admin");
        creeUtilisateur("Dave", "Murray", "dMurray", "admin");
        creeUtilisateur("Steven", "Taylor", "sTaylor", "admin");
        creeUtilisateur("Ronnie James", "Dio", "pleaseSendUsBackDio", "admin");
        creeUtilisateur("Zack", "Wylde", "zWylde", "admin");
        creeUtilisateur("Marc", "Knopfler", "mk", "admin");
        creeUtilisateur("Paul", "Stanley", "pStanley", "admin");
        creeUtilisateur("Gene", "Simmons", "bigTong", "admin");
        creeUtilisateur("David", "Gilmour", "DGilmour", "admin");
        creeUtilisateur("Mick", "Jagger", "MJagger", "admin");
        creeUtilisateur("Keith", "Richards", "KRichards", "admin");
        creeUtilisateur("Klaus", "Meine", "KMeine", "admin");
        creeUtilisateur("Gordon Matthew Thomas", "Sumner", "String", "admin");
        creeUtilisateur("Roger Daltrey", "Daltrey", "WhoAmI", "admin");
        creeUtilisateur("Steve", "Lukather", "SToto", "admin");
        creeUtilisateur("Saul", "Hudson", "Slash", "admin");
    }

    public Utilisateur creeUtilisateur(String nom, String prenom, String login, String mdp) {
        Utilisateur u = new Utilisateur(nom, prenom, login, mdp);
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

    public void persist(Object object) {
        em.persist(object);
    }
    
    /**
     * méthode permettant de savoir si les informations de login sont correctes.
     * @param login
     * @param password
     * @return 
     */
    public boolean isLoginCorrect(String login, String password) {
        Query q = em.createQuery("select u from Utilisateur u where u.login=:param");
        q.setParameter("param", login);
       
        if (q.getResultList().isEmpty()) {
            return false;
        }
        
        Utilisateur u = (Utilisateur) q.getSingleResult();
        
        if(u.getMdp().equals(password))
            return true;
        
        return false;
    }
}
