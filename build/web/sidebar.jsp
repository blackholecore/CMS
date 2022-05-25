<%-- 
    Document   : Sidebar
    Created on : Mar 20, 2022, 6:52:48 PM
    Author     : pc
--%>
<%@page import="entity.Advertisement"%>
<%@page import="java.util.List"%>
<%@page import="entity.Category"%>
<%@page import="entity.Tag"%>
<%@page import="entity.Post"%>
<%@page import="dao.PostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            PostDAO dao = new PostDAO();
        %>
        <div class="col-lg-3">
            <div class="sidebar-wrapper sidebar-wrapper-mrg-right">
                <div class="sidebar-widget mb-40">
                    <h4 class="sidebar-widget-title">Tìm kiếm </h4>
                    <div class="sidebar-search">
                        <form class="sidebar-search-form" action="Search.jsp" method="GET">
                            <input name="txtSearch" type="text" placeholder="Tìm kiếm...">
                            <button>
                                <i class="icon-magnifier"></i>
                            </button>
                        </form>
                    </div>
                </div>
                 <div class="sidebar-widget shop-sidebar-border pt-40">
                     <h4 class="sidebar-widget-title" style="margin-bottom: 20px;"> Quảng cáo</h4>
                    <% List<Advertisement> listCC = dao.getAllAdvertisement();%>
                    <% for (Advertisement ad : listCC) {%>
                    <div class="row-12 centered" style="margin-bottom: 10px;">
                        <img src="assets/images/<%=ad.getImage()%>" alt="quang-cao" width="250px" height="250px"/>   
                    </div>                              
                    <% }%>
                </div>
                <div class="sidebar-widget shop-sidebar-border mb-35 pt-40">
                    <h4 class="sidebar-widget-title">Chuyên mục </h4>
                    <div class="shop-catigory">
                        <ul>
                            <!--                                                <li><a href="shop.html">T-Shirt</a></li>
                                                                            <li><a href="shop.html">Shoes</a></li>
                                                                            <li><a href="shop.html">Clothing </a></li>
                                                                            <li><a href="shop.html">Women </a></li>
                                                                            <li><a href="shop.html">Baby Boy </a></li>
                                                                            <li><a href="shop.html">Accessories </a></li>-->
                            <% for (Category c : dao.getAllCategory()) {%>
                            <li><a href="Category.jsp?category=<%=c.getCategoryId()%>"><%=c.getCatTitle()%></a></li>
                                <% } %>

                        </ul>
                    </div>
                </div>
                <div class="sidebar-widget shop-sidebar-border mb-40 pt-40">
                    <h4 class="sidebar-widget-title">Bài đăng gần đây </h4>
                    <div class="recent-post">


                        <% for (Post c : dao.getTop6()) {%>
                        <div class="single-sidebar-blog">
                            <div class="sidebar-blog-img">
                                <a href="Blog?postID=<%=c.getPostId()%>"><img src="assets/images/<%=c.getThumbnail()%>" alt="No Image"></a>
                            </div>
                            <div class="sidebar-blog-content">
                                <h5><a href="Blog?postID=<%=c.getPostId()%>"><%=c.getPostTitle()%></a></h5>
                                <span><%=c.getPublishedAt()%></span>
                            </div>
                        </div>
                        <% }%>
                    </div>
                </div>
                <div class="sidebar-widget shop-sidebar-border mb-40 pt-40">
                    <h4 class="sidebar-widget-title">Kho lưu trữ </h4>
                    <div class="archives-wrap">
                        <select>
                            <option>Select Month</option>
                            <option> January 2020 </option>
                            <option> December 2018 </option>
                            <option> November 2018 </option>
                        </select>
                    </div>
                </div>
                <div class="sidebar-widget shop-sidebar-border pt-40">
                    <h4 class="sidebar-widget-title">Thẻ bài viết</h4>
                    <div class="tag-wrap sidebar-widget-tag">
                        <!--                        <a href="#">Clothing</a>
                                                <a href="#">Accessories</a>
                                                <a href="#">For Men</a>
                                                <a href="#">Women</a>
                                                <a href="#">Fashion</a>-->
                        <% for (Tag c : dao.getAllTag()) {%>
                        <a href="Tag.jsp?tag=<%=c.getTagId()%>"><%=c.getTagTitle()%></a>
                        <% }%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
