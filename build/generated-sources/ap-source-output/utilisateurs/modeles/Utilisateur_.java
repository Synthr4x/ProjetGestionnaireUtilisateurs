package utilisateurs.modeles;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Telephone;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-27T15:10:32")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Integer> id;
    public static volatile SingularAttribute<Utilisateur, String> mdp;
    public static volatile SingularAttribute<Utilisateur, Adresse> adresse;
    public static volatile ListAttribute<Utilisateur, Telephone> numeros;
    public static volatile SingularAttribute<Utilisateur, String> lastname;
    public static volatile SingularAttribute<Utilisateur, String> login;
    public static volatile SingularAttribute<Utilisateur, String> firstname;

}