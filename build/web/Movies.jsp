<%-- 
    Document   : Movies
    Created on : May 2, 2022, 10:28:48 PM
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
        <div class="main-wrapper">
            <jsp:include page="header.jsp"></jsp:include>
                <div id="movies-block">

                </div>
            <jsp:include page="footer.jsp"></jsp:include>
            </div>
            <script>
                const options = {
                    method: 'GET',
                    headers: {
                        'X-RapidAPI-Host': 'online-movie-database.p.rapidapi.com',
                        'X-RapidAPI-Key': '34c232976emsh989cd008e98bd27p1aa66ajsn1237b0ccbf31'
                    }
                };

                fetch('https://online-movie-database.p.rapidapi.com/auto-complete?q=game%20of%20thr', options)
                        .then(response => response.json())
                        .then(data => {
                            const list = data.d;
                            list.map((item) => {
                                const name = item.l;
                                const poster = item.i.imageUrl;
                                const movie = `<li><img src="${poster}"> <h2>${name}</h2></li>`;
                                document.getElementById("movies-block").innerHTML += movie;
                            })
                        })
//                        .then(function (movies) {
//                            var htmls = movies.map(function (movie) {
//                                return `<li>
//                                <h2>${movie.l}</h2>
//                        </li>`;
//                            });
//                            
//                            var html = htmls.join('');
//                            document.getElementById('movies-block').innerHTML = html;
//                        })
                        .catch(err => console.error(err));
//                fetch('https://online-movie-database.p.rapidapi.com/auto-complete?q=game%20of%20thr', options)
//                        .then(response => response.json())
//                        .then(response => console.log(response))
//                        .catch(err => console.error(err));
        </script>  
    </body>
</html>
