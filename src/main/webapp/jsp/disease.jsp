<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Deploma</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="../resources/assets/css/main.css"/>
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
                    <c:if test="${role}">

                        <li><a href="/logout" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                    </c:if>
                    <c:if test="${!role}">
                        <li><a href="/login" class="icon fa-facebook"><span class="label">Sing in</span></a></li>
                        <li><a href="/registration" class="icon fa-snapchat-ghost"><span class="label">Sing up</span></a></li>

                    </c:if>
                </ul>
            </header>

            <section>
                <header class="main">
                    <h1>${disease.name}</h1>
                </header>
                <h3>Group Of Diseases</h3>
                <h4>${disease.groupsOfDiseases.name}</h4>
                <h3>Description</h3>
                <blockquote>${disease.description}</blockquote>
                <h3>Symptoms</h3>
                <c:forEach items="${disease.symptoms}" var="symptom">
                    <li>${symptom.name}</li>
                </c:forEach>
                <br>
                <header class="major">
                    <a href="/doctor/${disease.groupsOfDiseases.doctor.id}"><h3>Doctor</h3></a>
                </header>
                <p>First Name: ${disease.groupsOfDiseases.doctor.firstName}<br></p>
                <p>Last Name: ${disease.groupsOfDiseases.doctor.lastName}<br></p>
                <p>Room: ${disease.groupsOfDiseases.doctor.room.number}<br></p>
            </section>
        </div>
    </div>

    <div id="sidebar">
        <div class="inner">

            <section id="search" class="alt">
                <form method="post" action="/search">
                    <input type="text" name="query" id="query" placeholder="Search"/>
                </form>
            </section>

            <nav id="menu">
                <header class="major">
                    <h2>Menu</h2>
                </header>
                <ul>
                    <li><a href="/">home</a></li>
                    <li><a href="/user">profile</a></li>
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
<!-- Scripts -->
<script src="<c:url value="../resources/assets/js/jquery.min.js"/>"></script>
<script src="<c:url value="../resources/assets/js/skel.min.js"/>"></script>
<script src="<c:url value="../resources/assets/js/util.js"/>"></script>
<script src="../resources/assets/js/ie/respond.min.js"></script><![endif]-->
<script src="<c:url value="../resources/assets/js/main.js"/>"></script>
</body>
</html>