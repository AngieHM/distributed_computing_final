/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import entity.Users;
import javax.ejb.Stateless;
/**
 *
 * @author Angela
 */
@Stateless
public class Register {
    
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String gender;
    private String romance;
    private String comedy;
    private String action;
    private String thriller;
    private String family;
    
     public Register() {
    }
     
    public Register (String firstname, String lastname, String username, String password,String email,String gender,String romance,String comedy,String action,String thriller,String family){
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.password = password;
    this.email = email;
    this.gender = gender;
    this.romance = romance;
    this.comedy = comedy;
    this.thriller = thriller;
    this.action = action;
    this.family = family ;
    
    
    }
    public Users validation(){
        
        return (new Users(firstname,lastname, username, password,email,gender,romance,comedy,action,thriller,family));
    }
    
}
