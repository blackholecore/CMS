<%-- 
    Document   : Blog
    Created on : Mar 20, 2022, 6:12:11 PM
    Author     : pc
--%>
<%@page import="entity.Advertisement"%>
<%@page import="control.Blog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

        <!-- Use the minified version files listed below for better performance and remove the files listed above
        <link rel="stylesheet" href="assets/css/vendor/vendor.min.css">
        <link rel="stylesheet" href="assets/css/plugins/plugins.min.css">
        <link rel="stylesheet" href="assets/css/style.min.css"> -->
    </head>
    <body>
        <%
            PostDAO dao = new PostDAO();
            List<Post> post = dao.getAllPost();
            Post p = new Post();
            String post_id = "";

            if (Blog.SLUGID != null) {
                post = dao.getPostBySLUGID(Blog.SLUGID);
                //post_id = request.getServletContext();
                //post = dao.getPostByID(Long.parseLong(post_id));
                p.setPostId(post.get(0).getPostId());
                p.setPostTitle(post.get(0).getPostTitle());
                p.setPublishedAt(post.get(0).getPublishedAt());
                p.setUpdatedAt(post.get(0).getUpdatedAt());
                p.setThumbnail(post.get(0).getThumbnail());
                p.setContent(post.get(0).getContent());
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="breadcrumb-area bg-gray">
                <div class="container">
                    <div class="breadcrumb-content text-center">
                        <ul>
                            <li>
                                <a href="Index.jsp"><i class="icon-home"></i> Trang chủ</a>
                            </li>
                            <li class="active"><%=p.getPostTitle()%></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="blog-area pt-120 pb-120">
            <div class="container">
                <div class="row flex-row-reverse">

                    <div class="col-lg-9">
                        <div class="blog-details-wrapper">
                            <div class="blog-details-top">
                                <div class="blog-details-img">
                                    <img alt="" src="assets/images/<%=p.getThumbnail()%>">
                                </div>
                                <div class="blog-details-content">
                                    <div class="blog-meta-2">
                                        <ul>
                                            <li>Cập nhật: <%=p.getPublishedAt()%></li>
                                            <li>Đăng bài: <%=p.getPublishedAt()%></li>
                                        </ul>
                                    </div>
                                    <h1><%=p.getPostTitle()%></h1>
<!--                                        <blockquote><%=p.getSummary()%></blockquote>-->
                                </div>
                            </div>
                            <div class="dec-img-wrapper">
                                <!--                                    <div class="row">
                                                                        <div class="col-md-6 col-sm-6 col-12">
                                                                            <div class="dec-img mb-50">
                                                                                <img alt="" src="assets/images/blog/blog-details-2.jpg">
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6 col-sm-6 col-12">
                                                                            <div class="dec-img mb-50">
                                                                                <img alt="" src="assets/images/blog/blog-details-3.jpg">
                                                                            </div>
                                                                        </div>
                                                                    </div>-->
                                <p><%=p.getContent()%></p>
                            </div>
                            <div class="tag-share">
                                <div class="dec-tag">
                                    <ul>
                                        <li><a href="#">lifestyle ,</a></li>
                                        <li><a href="#">interior ,</a></li>
                                        <li><a href="#">outdoor</a></li>
                                    </ul>
                                </div>
                                <div class="blog-share">
                                    <span>share :</span>
                                    <div class="share-social">
                                        <ul>
                                            <li>
                                                <a class="facebook" href="#">
                                                    <i class="icon-social-facebook"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a class="twitter" href="#">
                                                    <i class="icon-social-twitter"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a class="instagram" href="#">
                                                    <i class="icon-social-instagram"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="next-previous-post">
                                <a href="#"> <i class="fa fa-angle-left"></i> prev post</a>
                                <a href="#">next post <i class="fa fa-angle-right"></i></a>
                            </div>
                            <div class="blog-comment-wrapper mt-55">
                                <h4 class="blog-dec-title">comments : 02</h4>
                                <div class="single-comment-wrapper mt-35">
                                    <div class="blog-comment-img">
                                        <img src="assets/images/blog/comment-1.jpg" alt="">
                                    </div>
                                    <div class="blog-comment-content">
                                        <h4>Anthony Stephens</h4>
                                        <span>October 14, 2020 </span>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolor magna aliqua. Ut enim ad minim veniam, </p>
                                        <div class="blog-details-btn">
                                            <a href="blog-details.html">read more</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="single-comment-wrapper mt-50 ml-120">
                                    <div class="blog-comment-img">
                                        <img src="assets/images/blog/comment-2.jpg" alt="">
                                    </div>
                                    <div class="blog-comment-content">
                                        <h4>DX Joxova</h4>
                                        <span>October 14, 2020 </span>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolor magna aliqua. Ut enim ad minim veniam, </p>
                                        <div class="blog-details-btn">
                                            <a href="blog-details.html">read more</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="blog-reply-wrapper mt-50">
                                <h4 class="blog-dec-title">post a comment</h4>
                                <form class="blog-form" action="#">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="leave-form">
                                                <input type="text" placeholder="Full Name">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="leave-form">
                                                <input type="email" placeholder="Email Address ">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="text-leave">
                                                <textarea placeholder="Message"></textarea>
                                                <input type="submit" value="POST COMMENT">
                                            </div>
                                        </div>
                                    </div>
                                </form>
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
                    </div>
                    <jsp:include page="sidebar.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
