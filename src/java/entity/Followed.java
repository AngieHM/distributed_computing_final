/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angela
 */
@Entity
@Table(name = "FOLLOWED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followed.findAll", query = "SELECT f FROM Followed f")
    , @NamedQuery(name = "Followed.findByFollowedId", query = "SELECT f FROM Followed f WHERE f.followedId = :followedId")})
public class Followed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLLOWED_ID")
    private Integer followedId;
    @JoinColumn(name = "BOARDID", referencedColumnName = "BOARD_ID")
    @ManyToOne(optional = false)
    private Boards boardid;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userid;

    public Followed() {
    }

    public Followed(Boards boardid, Users userid) {
        this.followedId = followedId;
        this.boardid = boardid;
        this.userid = userid;
    }

    public Integer getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }

    public Boards getBoardid() {
        return boardid;
    }

    public void setBoardid(Boards boardid) {
        this.boardid = boardid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followedId != null ? followedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followed)) {
            return false;
        }
        Followed other = (Followed) object;
        if ((this.followedId == null && other.followedId != null) || (this.followedId != null && !this.followedId.equals(other.followedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Followed[ followedId=" + followedId + " ]";
    }
    
}
