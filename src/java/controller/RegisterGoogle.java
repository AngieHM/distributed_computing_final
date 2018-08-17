/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Boards;
import entity.Followed;
import entity.Followers;
import entity.Notifications;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.BoardsRepository;
import logic.CRUDOperation;
import logic.Followusers;
import logic.NotificationRepo;
import logic.RegisterValidation;
import logic.UserRepository;

/**
 *
 * @author Angela
 */
public class RegisterGoogle extends HttpServlet {
    @EJB
    RegisterValidation registerValidation;
    @EJB
    CRUDOperation crudOperation;
    @EJB
    BoardsRepository boardsRep;
    @EJB
    NotificationRepo notificationRepo;
    @EJB
    Followusers crudFollow;
    @EJB
    UserRepository userRepository;
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
        response.setContentType("text/html;charset=UTF-8");
            Boolean notification = false;
            String firstname = request.getParameter("name");
            String lastname = request.getParameter("name");
            String username = "googleUser";
            String password = "googlePass";
            String email = request.getParameter("email");
            String gender = "foo";
            String romance = "0";
            String comedy = "0";
            String action = "0";
            String thriller = "0";
            String family = "0";
            
                   String notif = "";
            Users user = registerValidation.findByEmail(email);
            System.out.println(user);
            Date date = new Date();
            List<Notifications> notificationList =notificationRepo.getByDate(date);
            List<String> nameList = new ArrayList<>();
            for (int i=0; i< notificationList.size();i++){
            int followerId =  notificationList.get(i).getAddedBy();
            Followers follower = crudFollow.findByIds(followerId,user.getId());
            if(follower!=null)
            {
                notification = true;
                notif = Boolean.toString(notification);
                String notFirst= userRepository.getById(followerId).getFirstname();
                nameList.add(notFirst);
            }
            }
            List<Followed> followList = boardsRep.getFollowed(user);
            List<Boards> catBoard = new ArrayList<>();

            if(user.getCatone().equals("1")){
                System.out.println(user.getCatone());
                List<Boards> board = boardsRep.getByCategory("romance");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            
            if(user.getCattwo().equals("2")){
                List<Boards> board = boardsRep.getByCategory("comedy");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            
            if(user.getCatthree().equals("3")){
                List<Boards> board = boardsRep.getByCategory("action");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            if(user.getCatfour().equals("4")){
                List<Boards> board = boardsRep.getByCategory("thriller");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            if(user.getCatfive().equals("5")){
                List<Boards> board = boardsRep.getByCategory("family");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            request.setAttribute("catList", catBoard);
            request.setAttribute("nameList", nameList);
            request.setAttribute("fList", followList);
            request.setAttribute("notification", notif);
            List<Boards> boardList = boardsRep.getAll() ;
            request.setAttribute("eList", boardList);
            
            if(registerValidation.findByFirstname(firstname)==null && registerValidation.findByEmail(email)==null){
                crudOperation.savetoDataBase(new Users(firstname, lastname, username, password,email,gender,romance,comedy,action,thriller,family));
                RequestDispatcher view = request.getRequestDispatcher("/boards.jsp");
                view.forward(request, response);
            }
            
            else{
                System.out.println("redirected");
                HttpSession session = request.getSession(true);
                request.getServletContext()
               .getRequestDispatcher("/boards.jsp").forward(request, response);
            
            }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
