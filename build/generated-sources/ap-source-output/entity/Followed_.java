package entity;

import entity.Boards;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-02T18:12:42")
@StaticMetamodel(Followed.class)
public class Followed_ { 

    public static volatile SingularAttribute<Followed, Boards> boardid;
    public static volatile SingularAttribute<Followed, Users> userid;
    public static volatile SingularAttribute<Followed, Integer> followedId;

}