package entity;

import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-02T18:12:42")
@StaticMetamodel(Logins.class)
public class Logins_ { 

    public static volatile SingularAttribute<Logins, Date> date;
    public static volatile SingularAttribute<Logins, Integer> loginId;
    public static volatile SingularAttribute<Logins, Users> userId;

}