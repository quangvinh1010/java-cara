<%-- 
    Document   : header
    Created on : 15 thg 9, 2024, 16:16:57
    Author     : 22 STORE
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
      integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
      crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./assets/css/style.css">
<link rel="stylesheet" href="./assets/css/Style_new.css">
<header id="header">
    <a href="HomeServlet"><img src="./assets/img/logo.png" class="logo" alt=""></a>
    <ul id="navbar">
        <li><a class="active" href="HomeServlet">Home</a></li>
        <li class="menu-item">
            <a href="ShopServlet">Shop</a>
            <ul class="sub-menu">
                <c:forEach items="${categoryList}" var="category">
                    <li class="menu-item">
                        <a href="CategoryServlet?categoryId=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li><a href="BlogServlet">Blog</a></li>
        <li><a href="AboutServlet">About</a></li>
        <li><a href="ContactServlet">Contact</a></li>
        <li><a href="CartServlet"><i class="fa-solid fa-bag-shopping"></i></a></li>
        <li>
            <c:if test="${sessionScope.user == null}">
                <a href="LoginServlet">Login</a>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <a href="LogoutServlet">Logout</a>
            </c:if>
        </li>
    </ul>

</header>
