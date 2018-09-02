/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Boards;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import logic.BoardsRepository;
import logic.NotificationRepo;
import logic.crudOperationBoard;

/**
 *
 * @author Angela
 */
/*@MultipartConfig(
                 location = "C:\\Users\\Angela\\Documents\\NetBeansProjects\\pinterestTry1\\web\\images",
                 fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB*/
public class UpdateServlet extends HttpServlet {
    @EJB
    crudOperationBoard crudBoard;
    @EJB
    NotificationRepo notification;
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
        int boardId2 = Integer.parseInt(request.getParameter("boardId2"));
        Boards board = boardRepo.getById(boardId2);
        
        String title = request.getParameter("title");
        String categorie = request.getParameter("categorie");
        Part part = request.getPart("file");
        
        if (title.equals("Board title") || part ==null){
    
             response.sendRedirect("update_boards.jsp");
        }
        
        else
        { 
        String fileName = extractFileName(part);
         String path = request.getServletContext().getRealPath("/");
        String newPath = path.substring(0, path.length() - 11)+File.separator+"web"+File.separator+"images";

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        //try {
            out = new FileOutputStream(new File(newPath + File.separator
                    + fileName));
            filecontent = part.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
           
        
        board.setTitle(title);
        board.setCategory(categorie);
        board.setImage(fileName);
        crudBoard.updateDataBase(board);
        request.getRequestDispatcher("/display_boards.jsp").forward(request,response);
        }
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
