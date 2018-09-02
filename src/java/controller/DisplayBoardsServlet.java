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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.BoardsRepository;
import logic.DisplayBoards;
import logic.Followusers;
import logic.Login;
import logic.NotificationRepo;
import logic.UserRepository;

/**
 *
 * @author Angela
 */
public class DisplayBoardsServlet extends HttpServlet {
    @EJB
    DisplayBoards displayBoards;
    @EJB
    BoardsRepository boardRepo;
    @EJB
    BoardsRepository boardsRep;
    @EJB
    private Login login;
    private Users user;
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
            String notif = "";
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            session.setAttribute("user", user);
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
            List<Followed> followList = boardRepo.getFollowed(user);
            List<Boards> catBoard = new ArrayList<>();

            if(user.getCatone().equals("1")){
                System.out.println(user.getCatone());
                List<Boards> board = boardRepo.getByCategory("romance");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            
            if(user.getCattwo().equals("1")){
                List<Boards> board = boardRepo.getByCategory("comedy");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            
            if(user.getCatthree().equals("1")){
                List<Boards> board = boardRepo.getByCategory("action");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            if(user.getCatfour().equals("1")){
                List<Boards> board = boardRepo.getByCategory("thriller");
                if(board.size()>0)
                {
                    for (int i=0; i<board.size();i++)
                    {
                        catBoard.add(board.get(i));
                    }   
                }
            }
            if(user.getCatfive().equals("1")){
                List<Boards> board = boardRepo.getByCategory("family");
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
            request.setAttribute("notification", String.valueOf(notification));
            System.out.println(notification);
        List<Boards> boardList = boardRepo.getAll() ;
        request.setAttribute("eList", boardList);
        request.getRequestDispatcher("/boards.jsp").forward(request,response);
    
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
