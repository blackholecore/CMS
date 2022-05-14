/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.PostDAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.lang.String;
/**
 *
 * @author pc
 */
@MultipartConfig
@WebServlet(name = "EditPost", urlPatterns = {"/EditPost"})
public class EditPost extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet EditPost</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet EditPost at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        String post_id = request.getParameter("post_id");
        String post_title = request.getParameter("post_title");
        String slug = request.getParameter("slug");
        String thumbnail = request.getParameter("thumbnail");
        String summary = request.getParameter("summary");
        String content = request.getParameter("content");
        String updatedAt = request.getParameter("updatedAt");
        Date UpdatedDate = Date.valueOf(updatedAt);
        String published = request.getParameter("published");
        String publishedAt = request.getParameter("publishedAt");
        Date PublishedDate = Date.valueOf(publishedAt);
        String viewcount = request.getParameter("viewcount");
        String category_id = request.getParameter("category_id");
        String user_id = request.getParameter("user_id");
        
//        Part part = request.getPart("thumbnail");
//        
//        String realPart = request.getServletContext().getRealPath("/assets/images");
//        String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
        
        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("acc");
        if (a != null) {
            //CHÈN NẾU ĐĂNG NHẬP
            PostDAO dao = new PostDAO();
            dao.editPost(Long.parseLong(post_id), post_title, slug, thumbnail, summary, UpdatedDate, Boolean.parseBoolean(published), PublishedDate, content, Long.parseLong(user_id), Integer.parseInt(viewcount), Long.parseLong(category_id));
            //request.setAttribute("mess", "Bạn có muốn đăng nhập không!");
            response.sendRedirect("IndexPost.jsp");
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
