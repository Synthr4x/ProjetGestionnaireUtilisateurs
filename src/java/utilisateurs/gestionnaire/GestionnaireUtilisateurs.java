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
import utilisateurs.modeles.Adresse;
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
         // On cree des adresses et on les insère dans la base  
        Adresse biot = creerAdresse("Biot", "06410");  
        Adresse valbonne = creerAdresse("Valbonne", "06560");   
        Adresse nice = creerAdresse("Nice", "06000");   
          
        // Note : après un persist, les objets sont connectés  
        
        creeUtilisateur("John", "Lennon", "jlennon", "admin", biot);
        creeUtilisateur("Paul", "Mac Cartney", "pmc", "admin", valbonne);
        creeUtilisateur("Ringo", "Starr", "rstarr", "admin", nice);
        creeUtilisateur("Georges", "Harisson", "georgesH", "admin", biot);
        creeUtilisateur("Jean", "Bon", "jBon", "admin", biot);
        creeUtilisateur("Anne", "Orak", "aOrak", "admin", biot);
        creeUtilisateur("Jon", "Bon Jovi", "jbj", "admin", biot);
        creeUtilisateur("Eddie", "Van Halen", "evh", "admin", biot);
        creeUtilisateur("Wolfgang", "Van Halen", "wvh", "admin", biot);
        creeUtilisateur("David Lee", "Roth", "dlr", "admin", biot);
        creeUtilisateur("Angus", "Young", "aYoung", "admin", biot);
        creeUtilisateur("Malcolm", "Young", "mYoung", "admin", biot);
        creeUtilisateur("Brian", "Johnson", "bJohnson", "admin", biot);
        creeUtilisateur("Bon", "Scott", "ripBS", "admin", biot);
        creeUtilisateur("Freddie", "Mercury", "fMercury", "admin", biot);
        creeUtilisateur("Brian", "May", "bMay", "admin", biot);
        creeUtilisateur("Phil", "Collins", "pCollins", "admin", biot);
        creeUtilisateur("Ozzy", "Osbourne", "princeOfDarkness", "admin", biot);
        creeUtilisateur("Tony", "Iommy", "fatherOfMetal", "admin",valbonne);
        creeUtilisateur("Bruce", "Dickinson", "bDickinson", "admin",valbonne);
        creeUtilisateur("Dave", "Murray", "dMurray", "admin",valbonne);
        creeUtilisateur("Steven", "Taylor", "sTaylor", "admin",valbonne);
        creeUtilisateur("Ronnie James", "Dio", "pleaseSendUsBackDio", "admin",valbonne);
        creeUtilisateur("Zack", "Wylde", "zWylde", "admin",valbonne);
        creeUtilisateur("Marc", "Knopfler", "mk", "admin",valbonne);
        creeUtilisateur("Paul", "Stanley", "pStanley", "admin",valbonne);
        creeUtilisateur("Gene", "Simmons", "bigTong", "admin",nice);
        creeUtilisateur("David", "Gilmour", "DGilmour", "admin",nice);
        creeUtilisateur("Mick", "Jagger", "MJagger", "admin",nice);
        creeUtilisateur("Keith", "Richards", "KRichards", "admin",nice);
        creeUtilisateur("Klaus", "Meine", "KMeine", "admin",nice);
        creeUtilisateur("Gordon Matthew Thomas", "Sumner", "Sting", "admin",nice);
        creeUtilisateur("Roger Daltrey", "Daltrey", "WhoAmI", "admin",nice);
        creeUtilisateur("Steve", "Lukather", "SToto", "admin",nice);
        creeUtilisateur("Saul", "Hudson", "Slash", "admin",nice);
    }

    public Utilisateur creeUtilisateur(String nom, String prenom, String login, String mdp, Adresse a) {
        Utilisateur u = new Utilisateur(nom, prenom, login, mdp);  
        // On met à jour la relation, elle est déjà en base  
        u.setAdresse(a);  
          
        // On persiste l'utilisateur, la relation est déjà en base, cela va donc  
        // ajouter une ligne dans la table des utilisateur avec une clé étrangère  
        // correspondant à l'adresse  
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

    public Utilisateur getUtilisateurByLogin(String login) {

        Query q = em.createQuery("select u from Utilisateur u where u.login=:param");
        q.setParameter("param", login);
        if (q.getResultList().size() != 0)
            return (Utilisateur)q.getSingleResult();
        else
            return null;
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
    
    /**
     * Méthode permettant de supprimer un objet dans la base de donnée
     * @param <T> la classe de l'objet à supprimer
     * @param o  l'objet à supprimer
     */
    public <T> void remove(T o) {  
        em.remove(em.merge(o));
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
    
    public void injecterAdministrateur(){
        Utilisateur admin = new Utilisateur("Admin", "Admin", "admin", "admin");
        em.persist(admin);
    }
    
    public Adresse creerAdresse(String ville, String cp) {
        Adresse a = new Adresse(ville, cp);  
        em.persist(a);
        // Note : après un persist, les objets sont connectés  
        
        return a;
    }
}
