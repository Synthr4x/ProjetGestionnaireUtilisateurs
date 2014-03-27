package utilisateurs.modeles;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utilisateurs.modeles.Telephone.TypeTel;
import utilisateurs.modeles.Utilisateur;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-27T16:00:15")
@StaticMetamodel(Telephone.class)
public class Telephone_ { 

    public static volatile SingularAttribute<Telephone, Integer> id;
    public static volatile SingularAttribute<Telephone, Utilisateur> u;
    public static volatile SingularAttribute<Telephone, TypeTel> t;
    public static volatile SingularAttribute<Telephone, String> numero;

}