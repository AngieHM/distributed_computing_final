package entity;

import entity.Boards;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-18T16:03:43")
@StaticMetamodel(Tracks.class)
public class Tracks_ { 

    public static volatile SingularAttribute<Tracks, String> linkp;
    public static volatile SingularAttribute<Tracks, Integer> trackId;
    public static volatile SingularAttribute<Tracks, String> title;
    public static volatile SingularAttribute<Tracks, Boards> board;

}