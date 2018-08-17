package entity;

import entity.Followed;
import entity.Tracks;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-17T20:08:26")
@StaticMetamodel(Boards.class)
public class Boards_ { 

    public static volatile CollectionAttribute<Boards, Tracks> tracksCollection;
    public static volatile SingularAttribute<Boards, String> image;
    public static volatile CollectionAttribute<Boards, Followed> followedCollection;
    public static volatile SingularAttribute<Boards, Integer> boardId;
    public static volatile SingularAttribute<Boards, String> title;
    public static volatile SingularAttribute<Boards, String> category;
    public static volatile SingularAttribute<Boards, Users> userid;

}