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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angela
 */
@Entity
@Table(name = "FOLLOWERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followers.findAll", query = "SELECT f FROM Followers f")
    , @NamedQuery(name = "Followers.findByFollowersId", query = "SELECT f FROM Followers f WHERE f.followersId = :followersId")
    , @NamedQuery(name = "Followers.findByIds", query = "SELECT f FROM Followers f WHERE f.followerId = :followerId AND f.followingId = :followingId")
    , @NamedQuery(name = "Followers.findByFollowerId", query = "SELECT f FROM Followers f WHERE f.followerId = :followerId")
    , @NamedQuery(name = "Followers.findByFollowingId", query = "SELECT f FROM Followers f WHERE f.followingId = :followingId")})
public class Followers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLLOWERS_ID")
    private Integer followersId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLLOWER_ID")
    private int followerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLLOWING_ID")
    private int followingId;

    public Followers() {
    }

    public Followers(Integer followersId) {
        this.followersId = followersId;
    }

    public Followers(int followerId, int followingId) {
        this.followersId = followersId;
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public Integer getFollowersId() {
        return followersId;
    }

    public void setFollowersId(Integer followersId) {
        this.followersId = followersId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getFollowingId() {
        return followingId;
    }

    public void setFollowingId(int followingId) {
        this.followingId = followingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followersId != null ? followersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followers)) {
            return false;
        }
        Followers other = (Followers) object;
        if ((this.followersId == null && other.followersId != null) || (this.followersId != null && !this.followersId.equals(other.followersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Followers[ followersId=" + followersId + " ]";
    }
    
}
