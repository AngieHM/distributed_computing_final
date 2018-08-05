package entity;

import entity.Boards;
import entity.Categories;
import entity.Followed;
import entity.Logins;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-18T16:03:43")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile CollectionAttribute<Users, Logins> loginsCollection;
    public static volatile CollectionAttribute<Users, Categories> categoriesCollection;
    public static volatile CollectionAttribute<Users, Followed> followedCollection;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile CollectionAttribute<Users, Boards> boardsCollection;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, String> username;

}