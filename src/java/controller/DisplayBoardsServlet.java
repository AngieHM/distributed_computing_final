/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Boards;
import entity.Users;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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

/**
 *
 * @author Angela
 */
public class DisplayBoardsServlet extends HttpServlet {
    @EJB
    DisplayBoards displayBoards;
    @EJB
    BoardsRepository boardRepo;
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
        
        /*Boards boards = displayBoards.board();
        String title = boards.getTitle();
        String category = boards.getCategory();
        String image = boards.getImage();
        int id = boards.getBoardId();
        String imagePath = "images/" + image;
        HttpSession session = request.getSession();
        session.setAttribute("board", boards);
        request.setAttribute("title",title);
        request.setAttribute("category",category);
        request.setAttribute("image",imagePath);
        request.setAttribute("id",String.valueOf(id));*/
        //RequestDispatcher view=request.getRequestDispatcher("display_boards.jsp");
        //RequestDispatcher view=request.getRequestDispatcher("/display_boards.jsp");
        //view.forward(request,response);
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
