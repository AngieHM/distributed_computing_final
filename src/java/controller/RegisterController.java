/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entity.Categories;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.CRUDOperation;
import logic.Register;
import entity.Users;
import logic.CRUDOperationCat;
import logic.Categorie;
import logic.RegisterValidation;

/**
 *
 * @author Angela
 */
public class RegisterController extends HttpServlet {
    @EJB
    RegisterValidation registerValidation;
    @EJB
    private Register registerBean;
    @EJB
    private Categorie categorie;
    @EJB
    private CRUDOperation crud;
    @EJB
    private CRUDOperationCat crudCat;
    private Users user;
    private Categories categorie_entity;
    
    
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String romance = request.getParameter("romance");
        String comedy = request.getParameter("comedy");
        String action = request.getParameter("action");
        String thriller = request.getParameter("thriller");
        String family = request.getParameter("family");
      
        
        registerBean = new Register(firstname, lastname, username, password,email,gender,romance,comedy,action,thriller,family);
          
        user = registerBean.validation();
        if(registerValidation.findByUsername(username)==null && registerValidation.findByEmail(email)==null){ 
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            crud.savetoDataBase(user);
            response.sendRedirect("login.jsp");
        }
        
        else{
            String message = "Choose another username and email";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
        
        categorie = new Categorie(user, romance);
        
        categorie_entity = categorie.validation();
        
        crudCat.savetoDataBase(categorie_entity);
    }
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
