/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Boards;
import entity.Tracks;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import logic.BoardsRepository;
import logic.TrackRepository;
import logic.crudTracks;

/**
 *
 * @author Angela
 */
@MultipartConfig(
                 location = "C:\\Users\\Angela\\Documents\\NetBeansProjects\\pinterestTry1\\web\\tracks",
                 fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class TrackServlet extends HttpServlet {
    @EJB
    crudTracks crudTrack;
    @EJB
    TrackRepository trackRepo;
    @EJB
    BoardsRepository boardsRepository;
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
        
        
        String title = request.getParameter("title");
        //HttpSession session = request.getSession();
        //Boards board = (Boards)session.getAttribute("board");
        HttpSession session = request.getSession();
        int boardId = Integer.parseInt((String)(session.getAttribute("boardId")));
        Boards board = boardsRepository.getById(boardId);
        
        Part part = request.getPart("audio");
        String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            
        fileName = new File(fileName).getName();
        part.write(fileName);

        
        crudTrack.savetoDataBase(new Tracks(title,board, fileName));
        
        List<Tracks> trackList = trackRepo.findByBoard(board) ;
        request.setAttribute("eList", trackList);
        request.getRequestDispatcher("/tracks.jsp").forward(request,response);
  
    }
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
    return "";
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
