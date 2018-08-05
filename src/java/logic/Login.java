/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Logins;
import entity.Users;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Angela
 */
@Stateless
public class Login {
    @EJB
    CrudOperationLogins crud;
    @EJB
    UserRepository userRepository;
    private boolean isVerified;
    
       public Login() 
    {
    }
 
    public Users login(String username, String password) {
        Users user = userRepository.getByUsernameAndPassword(username, password);
        if(user != null) {
            //logLogin(user);
            isVerified = true;
            logLogin(user);
        }
        else{
            isVerified = false;
        }
        
        return user;
    }
    
    public void setVerified(boolean isVerified){
        this.isVerified = isVerified;
    }
    
    public boolean getVerified(){
        return isVerified;
    }
    
    public void logLogin(Users user){
        Date date = new Date();
        
        crud.savetoDataBase(new Logins(user,date));
    }
        
}
