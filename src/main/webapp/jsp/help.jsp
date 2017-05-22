<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../resources/assets/css/main.css"/>

    <meta charset="utf-8" />
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <title>User</title>
</head>
<body>
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <!-- Header -->
            <header id="header">
                <a href="/" class="logo"><strong>Editorial</strong> by HTML5 UP</a>
                <ul class="icons">
                    <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                    <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                    <li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
                    <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                    <li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
                </ul>
            </header>
            <section id="search" class="alt">
                <header class="main">
                    <h1>Enter your symptoms</h1>
                </header>
                <form method="post" action="/search">
                    <input type="text" name="query" id="query" placeholder="Search"/>
                </form>
            </section>

            <section>
                <header class="main">
                    <h1>Help</h1>
                </header>
                <p>Donec eget ex magna. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque
                    venenatis dolor imperdiet dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas enim auctor
                    sit amet. Pellentesque leo mauris, consectetur id ipsum sit amet, fergiat. Pellentesque in mi eu
                    massa lacinia malesuada et a elit. Donec urna ex, lacinia in purus ac, pretium pulvinar mauris.
                    Curabitur sapien risus, commodo eget turpis at, elementum convallis elit. Pellentesque enim turpis,
                    hendrerit.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus rutrum facilisis. Class aptent
                    taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam tristique
                    libero eu nibh porttitor fermentum. Nullam venenatis erat id vehicula viverra. Nunc ultrices eros ut
                    ultricies condimentum. Mauris risus lacus, blandit sit amet venenatis non, bibendum vitae dolor.
                    Nunc lorem mauris, fringilla in aliquam at, euismod in lectus. Pellentesque habitant morbi tristique
                    senectus et netus et malesuada fames ac turpis egestas. In non lorem sit amet elit placerat maximus.
                    Pellentesque aliquam maximus risus, vel sed vehicula.</p>
                <p>Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet
                    dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit amet. Pellentesque
                    leo mauris, consectetur id ipsum sit amet, fersapien risus, commodo eget turpis at, elementum
                    convallis elit. Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p>

                <%--<form method="post" action="input5.php">--%>
                    <%--<p><b>С какими операционными системами вы знакомы?</b></p>--%>
                    <%--<p><label>--%>
                        <%--<input type="checkbox" name="option1" value="a1" checked>--%>
                    <%--</label>Windows 95/98<Br>--%>
                        <%--<label>--%>
                            <%--<input type="checkbox" name="option2" value="a2">--%>
                            <%--Windows 2000--%>
                        <%--</label><Br>--%>
                        <%--<input type="checkbox" name="option3" value="a3">System X<Br>--%>
                        <%--<input type="checkbox" name="option4" value="a4">Linux<Br>--%>
                        <%--<input type="checkbox" name="option5" value="a5">X3-DOS</p>--%>
                    <%--<p><input type="submit" value="Отправить"></p>--%>
                <%--</form>--%>
            </section>



        </div>
    </div>

    <div id="sidebar">
        <div class="inner">

            <%--<section id="search" class="alt">--%>
                <%--<form method="post" action="#">--%>
                    <%--<input type="text" name="query" id="query" placeholder="Search"/>--%>
                <%--</form>--%>
            <%--</section>--%>

            <nav id="menu">
                <header class="major">
                    <h2>Menu</h2>
                </header>
                <ul>
                    <li><a href="/">home</a></li>
                    <li><a href="/doctor">doctors</a></li>
                    <li><a href="/help">helps</a></li>
                </ul>
            </nav>
            <section>
                <header class="major">
                    <h2>Get in touch</h2>
                </header>
                <p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem
                    ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus
                    aliquam.</p>
                <ul class="contact">
                    <li class="fa-envelope-o"><a href="#">information@untitled.tld</a></li>
                    <li class="fa-phone">(000) 000-0000</li>
                    <li class="fa-home">1234 Somewhere Road #8254<br/>
                        Nashville, TN 00000-0000
                    </li>
                </ul>
            </section>
            <footer id="footer">
                <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>.
                    Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
            </footer>
        </div>
    </div>
</div>
<script src="<c:url value="../resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="../resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="../resources/assets/js/util.js"/>"></script>
<script src="../resources/assets/js/ie/respond.min.js"></script>
<![endif]-->
<script src="<c:url value="../resources/assets/js/main.js"/>"></script>
</body>
</html>
