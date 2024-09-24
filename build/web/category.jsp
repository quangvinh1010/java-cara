<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cara</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
              integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="./assets/css/style.css">
    </head>

    <body>

        <%@include file="./inc/header.jsp" %>

        <section id="page-header">
            <h2>#${keyword}</h2>
            <p>Save more with coupons & up to 70% off!</p>
            <form action="SearchServlet" class="search" method="get">
                <div class="form-search">
                    <input name="keyword" class="search w-50 p-2 rounded-top" type="search" placeholder="Search" aria-label="Search">
                </div>
            </form>

        </section>

        <section id="product1" class="section-p1">
            <div class="row">
                <form action="CategoryServlet" class="filter" method="get">
                    <input type="hidden" name="categoryId" value="${category.id}"/>
                    <strong>Sort by:</strong>
                    <select name="property" id="" class="from-control property">
                        <option value="name">Name</option>
                        <option value="pricr">Price</option>
                        <option value="createdAt">Time</option>
                    </select>
                    <strong>Order by:</strong>
                    <select name="Order" id="" class="from-control Order">
                        <option value="asc">A-Z</option>
                        <option value="desc">Z-A</option>
                    </select>
                    <button class="filter-submit btn btn-primary">Filter</button>
                </form>
            </div>
            <div class="prod-cont">
                <c:forEach items="${productList}" var="product">
                    <div class="prod">
                        <img src="${product.thumbnail}" alt="">
                        <div class="des">
                            <span>adidas</span>
                            <h5>${product.name}</h5>
                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h4>$${product.price}</h4>
                        </div>
                        <a href="#"><i class="fa-solid fa-cart-shopping cart"></i></a>
                    </div>
                </c:forEach>
        </section>

        <section id="pagination" class="section-p1">
            <a href="#">1</a>
            <a href="#">2</a>
            <a href="#"><i class="fa-solid fa-arrow-right"></i></a>
        </section>

        <section id="newsletter" class="section-p1 section-m1">
            <div class="newstext">
                <h4>Sign Up For Newsletters</h4>
                <p>Get E-mail updates about our latest shop and <span>special offers</span></p>
            </div>
            <div class="form">
                <input type="text" placeholder="Your email address">
                <button class="normal">Sign up</button>
            </div>
        </section>

        <%@include file="./inc/footer.jsp" %>

    </body>

</html>
