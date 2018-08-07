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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    ,@NamedQuery(name = "Users.findByUsernameAndPassword", query = "SELECT u FROM Users u WHERE u.username = :username AND u.password = :password")
    ,@NamedQuery(name = "Users.findByUsernameAndEmail", query = "SELECT u FROM Users u WHERE u.username = :username AND u.email = :email")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Users.findByAddress", query = "SELECT u FROM Users u WHERE u.address = :address")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    @Size(max = 20)
    @Column(name = "GENDER")
    private String gender;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 25)
    @Column(name = "CATONE")
    private String catone;
    @Size(max = 25)
    @Column(name = "CATTWO")
    private String cattwo;
    @Size(max = 25)
    @Column(name = "CATTHREE")
    private String catthree;
    @Size(max = 25)
    @Column(name = "CATFOUR")
    private String catfour;
    @Size(max = 25)
    @Column(name = "CATFIVE")
    private String catfive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Followed> followedCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Logins> loginsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Boards> boardsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Categories> categoriesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 1024)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "PASSWORD")
    private String password;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(String lastname, String firstname, String username, String password, String email, String gender,String catone,String cattwo, String catthree, String catfour, String catfive) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.catone = catone;
        this.cattwo = cattwo;
        this.catthree = catthree;
        this.catfour = catfour;
        this.catfive = catfive;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Categories> getCategoriesCollection() {
        return categoriesCollection;
    }

    public void setCategoriesCollection(Collection<Categories> categoriesCollection) {
        this.categoriesCollection = categoriesCollection;
    }

    @XmlTransient
    public Collection<Boards> getBoardsCollection() {
        return boardsCollection;
    }

    public void setBoardsCollection(Collection<Boards> boardsCollection) {
        this.boardsCollection = boardsCollection;
    }

    @XmlTransient
    public Collection<Logins> getLoginsCollection() {
        return loginsCollection;
    }

    public void setLoginsCollection(Collection<Logins> loginsCollection) {
        this.loginsCollection = loginsCollection;
    }

    @XmlTransient
    public Collection<Followed> getFollowedCollection() {
        return followedCollection;
    }

    public void setFollowedCollection(Collection<Followed> followedCollection) {
        this.followedCollection = followedCollection;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCatone() {
        return catone;
    }

    public void setCatone(String catone) {
        this.catone = catone;
    }

    public String getCattwo() {
        return cattwo;
    }

    public void setCattwo(String cattwo) {
        this.cattwo = cattwo;
    }

    public String getCatthree() {
        return catthree;
    }

    public void setCatthree(String catthree) {
        this.catthree = catthree;
    }

    public String getCatfour() {
        return catfour;
    }

    public void setCatfour(String catfour) {
        this.catfour = catfour;
    }

    public String getCatfive() {
        return catfive;
    }

    public void setCatfive(String catfive) {
        this.catfive = catfive;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
