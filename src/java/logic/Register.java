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
    
     public Register() {
    }
     
    public Register (String firstname, String lastname, String username, String password){
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.password = password;
    }
    public Users validation(){
        
        return (new Users(firstname,lastname, username, password));
    }
    
}
