/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Categories;
import entity.Users;
import javax.ejb.Stateless;

/**
 *
 * @author Angela
 */
@Stateless
public class Categorie {
    

    private String categorie;
    
    private Users user;


    
     public Categorie() {
    }
     
    public Categorie (Users user, String categorie){

    this.user = user;
    this.categorie = categorie;
    
    }
    public Categories validation(){
        
        return (new Categories(user, categorie));
    }
    
}
