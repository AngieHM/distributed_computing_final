/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Boards;
import entity.Followed;
import entity.Notifications;
import entity.Users;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import logic.BoardsRepository;
import logic.NotificationRepo;
import logic.crudOperationBoard;
import sun.misc.IOUtils;

/**
 *
 * @author Angela
 */
@MultipartConfig(
                 location = "C:\\Users\\Angela\\Documents\\NetBeansProjects\\pinterestTry1\\web\\images",
                 fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class BoardServlet extends HttpServlet {
    
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
        /*try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BoardServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BoardServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); 
        }
        */
        String title = request.getParameter("title");
        String categorie = request.getParameter("categorie");


        Part part = request.getPart("file");
        String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            
        fileName = new File(fileName).getName();
        part.write(fileName);

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        crudBoard.savetoDataBase(new Boards(user,title,categorie,fileName));
        
        /*String filename = extractFileName(part);
        String savePath = "C:\\Users\\Angela\\Documents\\NetBeansProjects\\pinterestTry1\\web\\images" + File.separator + filename;
        File FileSaveDir = new File(savePath);
        
        part.write(savePath + File.separator);*/
        Date date = new Date();
        notification.savetoDataBase(new Notifications(date,user.getId()));
        
        List<Boards> boardList = boardRepo.getAll() ;
        request.setAttribute("eList", boardList);
        List<Followed> followList = boardRepo.getFollowed(user);
        request.setAttribute("fList", followList);
        request.getRequestDispatcher("/display_boards.jsp").forward(request,response);
        
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
