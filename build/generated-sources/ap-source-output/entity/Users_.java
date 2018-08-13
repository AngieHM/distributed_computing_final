package entity;

import entity.Boards;
import entity.Categories;
import entity.Followed;
import entity.Logins;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-10T16:22:04")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile CollectionAttribute<Users, Categories> categoriesCollection;
    public static volatile SingularAttribute<Users, String> catfive;
    public static volatile CollectionAttribute<Users, Followed> followedCollection;
    public static volatile SingularAttribute<Users, String> cattwo;
    public static volatile SingularAttribute<Users, String> catone;
    public static volatile CollectionAttribute<Users, Boards> boardsCollection;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, Logins> loginsCollection;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> catfour;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> catthree;
    public static volatile SingularAttribute<Users, String> username;

}