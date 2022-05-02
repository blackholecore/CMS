/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PostDAO;
import entity.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@WebServlet(name = "Blog", urlPatterns = {"/Blog"})
public class Blog extends HttpServlet {

    public static String SLUGID = null;
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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Blog</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Blog at " + request.getServletPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        
        PostDAO dao = new PostDAO();
        List<Post> post = dao.getAllPost();
        Post p = new Post();
        String post_id = "";
        if (request.getParameter("postID") != null) {
            post_id = request.getParameter("postID");
            post = dao.getPostByID(Long.parseLong(post_id));
            p.setPostId(post.get(0).getPostId());
            p.setPostTitle(post.get(0).getPostTitle());
            p.setSlug(post.get(0).getSlug());
            p.setPublishedAt(post.get(0).getPublishedAt());
            p.setUpdatedAt(post.get(0).getUpdatedAt());
            p.setThumbnail(post.get(0).getThumbnail());
            p.setContent(post.get(0).getContent());
            Blog.SLUGID = p.getSlug()+"-"+p.getPostId();
            response.sendRedirect("Blog.jsp?/"+Blog.SLUGID);
        }else{
            response.sendRedirect("404.html");
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
