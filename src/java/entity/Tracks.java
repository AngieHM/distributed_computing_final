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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angela
 */
@Entity
@Table(name = "TRACKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracks.findAll", query = "SELECT t FROM Tracks t")
    , @NamedQuery(name = "Tracks.findByBoard", query = "SELECT t FROM Tracks t WHERE t.board = :board")
    , @NamedQuery(name = "Tracks.findByTrackId", query = "SELECT t FROM Tracks t WHERE t.trackId = :trackId")
    , @NamedQuery(name = "Tracks.findByTitle", query = "SELECT t FROM Tracks t WHERE t.title = :title")
    , @NamedQuery(name = "Tracks.findByLinkp", query = "SELECT t FROM Tracks t WHERE t.linkp = :linkp")})
public class Tracks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRACK_ID")
    private Integer trackId;
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 1024)
    @Column(name = "LINKP")
    private String linkp;
    @JoinColumn(name = "BOARD", referencedColumnName = "BOARD_ID")
    @ManyToOne(optional = false)
    private Boards board;

    public Tracks() {
    }

    public Tracks(Integer trackId) {
        this.trackId = trackId;
    }

    public Tracks(String title,Boards board, String linkp) {
        this.trackId = trackId;
        this.title = title;
        this.board = board;
        this.linkp = linkp;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkp() {
        return linkp;
    }

    public void setLinkp(String linkp) {
        this.linkp = linkp;
    }

    public Boards getBoard() {
        return board;
    }

    public void setBoard(Boards board) {
        this.board = board;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tracks)) {
            return false;
        }
        Tracks other = (Tracks) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tracks[ trackId=" + trackId + " ]";
    }
    
}
