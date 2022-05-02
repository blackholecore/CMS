<%-- 
    Document   : Contact
    Created on : Mar 20, 2022, 6:14:45 PM
    Author     : pc
--%>

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
        <jsp:include page="header.jsp"></jsp:include>
        <div class="breadcrumb-area bg-gray">
            <div class="container">
                <div class="breadcrumb-content text-center">
                    <ul>
                        <li>
                            <a href="Index.jsp">Trang chủ</a>
                        </li>
                        <li class="active"> Nhận bài viết mới </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="contact-area pt-115 pb-120">
            <div class="container">
                
                <div class="get-in-touch-wrap">
                    <h3>Điền email của bạn tại đây!</h3>
                    <div class="contact-from contact-shadow">
                        <form id="contact-form" action="MailController" method="POST">
                            <div class="row">
                                
                                <div class="col-lg-12 col-md-12">
                                    <input name="mail" type="email" placeholder="Email nhận bài viết ...">
                                </div>
                              
                                <div class="col-lg-12 col-md-12">
                                    <button class="submit" type="submit">Đăng ký</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="contact-map pt-120">
                    <div id="map"></div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
