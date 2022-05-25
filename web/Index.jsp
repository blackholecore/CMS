<%-- 
    Document   : Index
    Created on : Mar 20, 2022, 6:06:57 PM
    Author     : pc
--%>
<%@page import="java.util.List"%>
<%@page import="entity.Advertisement"%>
<%@page import="entity.Category"%>
<%@page import="entity.Tag"%>
<%@page import="entity.Post"%>
<%@page import="dao.PostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Norda - Minimal eCommerce HTML Template</title>
        <meta name="robots" content="noindex, follow" />
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png">

        <!-- All CSS is here
            ============================================ -->

        <link rel="stylesheet" href="assets/css/vendor/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/vendor/signericafat.css">
        <link rel="stylesheet" href="assets/css/vendor/cerebrisans.css">
        <link rel="stylesheet" href="assets/css/vendor/simple-line-icons.css">
        <link rel="stylesheet" href="assets/css/vendor/elegant.css">
        <link rel="stylesheet" href="assets/css/vendor/linear-icon.css">
        <link rel="stylesheet" href="assets/css/plugins/nice-select.css">
        <link rel="stylesheet" href="assets/css/plugins/easyzoom.css">
        <link rel="stylesheet" href="assets/css/plugins/slick.css">
        <link rel="stylesheet" href="assets/css/plugins/animate.css">
        <link rel="stylesheet" href="assets/css/plugins/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/plugins/jquery-ui.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />

        <!-- Use the minified version files listed below for better performance and remove the files listed above
        <link rel="stylesheet" href="assets/css/vendor/vendor.min.css">
        <link rel="stylesheet" href="assets/css/plugins/plugins.min.css">
        <link rel="stylesheet" href="assets/css/style.min.css"> -->
    </head>
    <body>
        <div class="main-wrapper">
            <jsp:include page="header.jsp"></jsp:include>

                <div class="breadcrumb-area bg-gray">
                    <div class="container">
                        <div class="breadcrumb-content text-center">
                            <ul>
                                <li>
                                    <a href="Index.jsp"><i class="icon-home"></i> Trang chủ</a>
                                </li>
                                <li class="active">Danh sách bài viết</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="blog-area pt-120 pb-120">
                    <div class="container">


                        <!-- Xuất bản tin-->
                        <div class="row flex-row-reverse">
                            <div class="col-lg-9">
                                <div class="row">
                                <%
                                    PostDAO dao = new PostDAO();
                                %>
                                <% for (Post c : dao.getTop6()) {%>
                                <div class="col-lg-6 col-md-6 col-12 col-sm-6">
                                    <div class="blog-wrap mb-40">
                                        <div class="blog-img mb-20">
                                            <a href="Blog?postID=<%=c.getPostId()%>"><img src="assets/images/<%=c.getThumbnail()%>" alt="blog-img"></a>
                                        </div>
                                        <div class="blog-content">
                                            <div class="blog-meta">
                                                <ul>
                                                    <!--                                                        <li><a href="#"> </a></li>-->
                                                    <li>Cập nhật: <%=c.getUpdatedAt()%></li>
                                                    <li>Đăng bài: <%=c.getPublishedAt()%></li>
                                                </ul>
                                            </div>
                                            <h1><a href="Blog?postID=<%=c.getPostId()%>"><%=c.getPostTitle()%></a></h1>
                                        </div>
                                    </div>
                                </div>
                                <% }%>
                            </div>
                            <div class="pro-pagination-style text-center mt-10">
                                <ul>
                                    <li><a class="prev" href="#"><i class="icon-arrow-left"></i></a></li>
                                    <li><a class="active" href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a class="next" href="#"><i class="icon-arrow-right"></i></a></li>
                                </ul>
                            </div>


                            <div class="row" style="margin-top: 20px;">
                                <% List<Advertisement> listCC = dao.getAllAdvertisement();%>
                                <% for (Advertisement ad : listCC) {%>
                                <div class="col-5 " style="margin-bottom: 10px;">
                                    <img src="assets/images/<%=ad.getImage()%>" alt="quang-cao" />   
                                </div> 
                                <% }%>
                            </div>                              


                        </div>
                        <jsp:include page="sidebar.jsp"></jsp:include>
                        </div>
                    </div>
                </div>
            <jsp:include page="footer.jsp"></jsp:include>
            <script src="js/datatables-simple-demo.js"></script>
        </div>
    </body>
</html>
