/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudcomment;

import dao.PostDAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@WebServlet(name = "CreateComment", urlPatterns = {"/CreateComment"})
public class CreateComment extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CreateComment</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CreateComment at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        String comment_title = request.getParameter("comment_title");
        String comment_fullname = request.getParameter("comment_fullname");
        String comment_website = request.getParameter("comment_website");
        String comment_email = request.getParameter("comment_email");
        String content = request.getParameter("content");
        String updatedAt = request.getParameter("updatedAt");
        Date UpdatedDate = Date.valueOf(updatedAt);
        String published = request.getParameter("published");
        Boolean published_ = Boolean.parseBoolean(published);
        String publishedAt = request.getParameter("publishedAt");
        Date PublishedDate = Date.valueOf(publishedAt);
        String post_id = request.getParameter("post_id");

        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("acc");
        if (a != null) {
            //CHÈN NẾU ĐĂNG NHẬP
            PostDAO dao = new PostDAO();
            dao.insertComment(comment_title, UpdatedDate, published_ , PublishedDate, content, Long.parseLong(post_id), comment_email, comment_website, comment_fullname);
            //request.setAttribute("mess", "Bạn có muốn đăng nhập không!");
            response.sendRedirect("IndexComment.jsp");
        } else {
            //day ve trang login.jsp
            request.setAttribute("mess", "Email này đã tồn tại! Mời bạn nhập email khác!");
            response.sendRedirect("Login.jsp");
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateComment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateComment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
