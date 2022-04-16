<%@page import="entity.Tag"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.Format"%>
<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="entity.Post"%>
<%@page import="entity.User"%>
<%@page import="dao.PostDAO"%>
<%
    User a = (User) session.getAttribute("acc");
    if (a != null) {
//        Long id = a.getUserId();
//        PostDAO dao = new PostDAO();
//        List<Post> listPost = dao.getPostByUserID(id);
//        List<Category> listCategory = dao.getAllCategory();
//        response.sendRedirect("Manage.jsp");
    } else {
        request.setAttribute("mess", "Bạn chưa đăng nhập để vào trang này!");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
%>
<%-- 
    Document   : Manage
    Created on : Mar 23, 2022, 8:03:03 PM
    Author     : pc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <%
            PostDAO dao = new PostDAO();
            int slbaiviet = dao.getAllPost().size();
            int slchuyenmuc = dao.getAllCategory().size();
            int sltag = dao.getAllTag().size();
            int sluser = dao.getAllUser().size();
            Format f = new SimpleDateFormat("dd/MM/yyyy");
            
            List<Tag> tag = dao.getAllTag();
            Tag p = new Tag();
            String tag_id = "";
            if (request.getParameter("tag") != null) {
                tag_id = request.getParameter("tag");
                tag = dao.getTagById(Long.parseLong(tag_id));
                p.setTagId(tag.get(0).getTagId());
                p.setTagTitle(tag.get(0).getTagTitle());
                p.setPostId(tag.get(0).getPostId());
                
            }
        %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="">Fast News</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Cài đặt</a></li>
                        <li><a class="dropdown-item" href="#!">Hoạt động</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="LogoutControl">Đăng xuất</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="Manage.jsp">
                                <div class="sb-nav-link-icon"><img src="assets/images/dashboard.png" width="30" height="30"/></div>
                                Dashboard
                            </a>

                            <div class="sb-sidenav-menu-heading">Tác vụ chính</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><img src="assets/images/share-post.png" width="30" height="30"/></div>
                                Quản lý bài viết
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="IndexPost.jsp">Danh sách bài viết</a>
                                    <a class="nav-link" href="CreatePost.jsp">Thêm bài viết</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><img src="assets/images/label.png" width="30" height="30"/></div>
                                Quản lý thẻ bài viết
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="IndexTag.jsp">Danh sách tag</a>
                                    <a class="nav-link" href="CreateTag.jsp">Thêm tag bài viết</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><img src="assets/images/trending-topic.png" width="30" height="30"/></div>
                                Quản lý chuyên mục
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="IndexCategory.jsp">Danh sách chuyên mục</a>
                                    <a class="nav-link" href="CreateCategory.jsp">Thêm chuyên mục</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><img src="assets/images/communicate.png" width="30" height="30"/></div>
                                Quản lý nhận xét
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="IndexComment.jsp">Danh sách comment</a>
                                    <a class="nav-link" href="CreateComment.jsp">Thêm comment bài viết</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><img src="assets/images/hang.png" width="30" height="30"/></div>
                                Quản lý quảng cáo
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="IndexAdvertisement.jsp">Danh sách quảng cáo</a>
                                    <a class="nav-link" href="CreateAdvertisement.jsp">Thêm quảng cáo</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><img src="assets/images/software-engineer.png" width="30" height="30"/></div>
                                Quản lý người dùng
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Tài khoản
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="IndexUser.jsp">Danh sách tài khoản</a>
                                            <a class="nav-link" href="CreateUser.jsp">Thêm tài khoản</a>
                                        </nav>
                                    </div>
                                    <!--                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                                                            Error
                                                                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                                                        </a>
                                                                        <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                                                            <nav class="sb-sidenav-menu-nested nav">
                                                                                <a class="nav-link" href="401.html">401 Page</a>
                                                                                <a class="nav-link" href="404.html">404 Page</a>
                                                                                <a class="nav-link" href="500.html">500 Page</a>
                                                                            </nav>
                                                                        </div>-->
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Khác</div>
                            <a class="nav-link" href="">
                                <div class="sb-nav-link-icon"><img src="assets/images/pie-chart.png" width="30" height="30"/></div>
                                Biểu đồ thống kê
                            </a>
                            <a class="nav-link" href="">
                                <div class="sb-nav-link-icon"><img src="assets/images/eye.png" width="30" height="30"/></div>
                                Tìm kiếm, báo cáo
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Fast News
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4" style="max-width: 750px">
                        <h1 class="mt-4">Thẻ bài viết</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Sửa thẻ bài viết</li>
                        </ol>

                        <form action="CreateTag" method="POST" class="row g-3">
                            <div class="col-md-6">
                                <label for="inputEmail4" class="form-label">Tên thẻ (Tag)</label>
                                <input type="text" class="form-control" name="tag_title" value="<%=p.getTagTitle() %>">
                            </div>
                           
                            <div class="col-md-2">
                                <label for="inputCity" class="form-label">Bài viết </label>
                                <select name="post_id" class="form-select">
                                    <option selected>Chọn</option>
                                    <% for (Post t : dao.getAllPost()) {%>                                 
                                    <option value="<%=t.getPostId() %>"><%=t.getPostTitle() %></option>
                                    <% } %>
                                </select>
                            </div>
<!--                            <div class="col-12">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="gridCheck">
                                    <label class="form-check-label" for="gridCheck">
                                        Check me out
                                    </label>
                                </div>
                            </div>-->
                            <div class="col-12">
                                <input type="submit" class="btn btn-primary" value="Sửa">
                            </div>
                        </form>

                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Nguyễn Văn Huỳnh</div>
                            <!--                            <div>
                                                            <a href="#">Privacy Policy</a>
                                                            &middot;
                                                            <a href="#">Terms &amp; Conditions</a>
                                                        </div>-->
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>

