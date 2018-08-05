/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Angela
 */
@Entity
@Table(name = "BOARDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boards.findAll", query = "SELECT b FROM Boards b")
    , @NamedQuery(name = "Boards.findByBoardId", query = "SELECT b FROM Boards b WHERE b.boardId = :boardId")
    , @NamedQuery(name = "Boards.findByTitle", query = "SELECT b FROM Boards b WHERE b.title = :title")
    , @NamedQuery(name = "Boards.findByCategory", query = "SELECT b FROM Boards b WHERE b.category = :category")
    , @NamedQuery(name = "Boards.findByImage", query = "SELECT b FROM Boards b WHERE b.image = :image")})
public class Boards implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boardid")
    private Collection<Followed> followedCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board")
    private Collection<Tracks> tracksCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOARD_ID")
    private Integer boardId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 1024)
    @Column(name = "IMAGE")
    private String image;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userid;

    public Boards() {
    }

    public Boards(Integer boardId) {
        this.boardId = boardId;
    }

    public Boards(Users userid, String title, String category, String image) {
        this.userid = userid;
        this.boardId = boardId;
        this.title = title;
        this.category = category;
        this.image = image;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        hash += (boardId != null ? boardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boards)) {
            return false;
        }
        Boards other = (Boards) object;
        if ((this.boardId == null && other.boardId != null) || (this.boardId != null && !this.boardId.equals(other.boardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Boards[ boardId=" + boardId + " ]";
    }

    @XmlTransient
    public Collection<Tracks> getTracksCollection() {
        return tracksCollection;
    }

    public void setTracksCollection(Collection<Tracks> tracksCollection) {
        this.tracksCollection = tracksCollection;
    }

    @XmlTransient
    public Collection<Followed> getFollowedCollection() {
        return followedCollection;
    }

    public void setFollowedCollection(Collection<Followed> followedCollection) {
        this.followedCollection = followedCollection;
    }
    
}
