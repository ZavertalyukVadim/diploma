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
                    <h1>Doctors</h1>
                </header>
                <p>First Name: ${doctor.firstName}<br></p>
                <p>Last Name: ${doctor.lastName}<br></p>
                <c:forEach items="${doctor.groupsOfDiseases}" var="groupsOfDisease">
                    <p>Groups Of Disease: ${groupsOfDisease.name}<br></p>
                </c:forEach>
                <p>Room number: ${doctor.room.number}<br></p>
                <h4>Rents</h4>
                <div class="table-wrapper">
                    <table class="alt">
                        <thead>
                        <tr>
                            <th>Date</th>
                            <th>Pacient</th>
                            <th>Doctor</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${doctor.rents}" var="rent">
                            <tr>
                                <td>${rent.date}</td>
                                <td>${rent.user.lastName}</td>
                                <td>${rent.doctor.firstName}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul class="actions small">
                        <form action="/rent" method="post">
                            <input type="hidden" name="doctor_id" value="${doctor.id}">
                            <input type="time" name="date" value="10:00" min="08:00" max="17:00" step="1800">
                            <button type="submit" class="button small">Add rent</button>
                        </form>
                    </ul>
                </div>
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
<script src="../resources/assets/js/ie/respond.min.js"></script>
<![endif]-->
<script src="<c:url value="../resources/assets/js/main.js"/>"></script>
</body>
</html>