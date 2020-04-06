<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="item  col-xs-4">
    <div class="thumbnail">
        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
        <div class="caption">
            <h4 class="group inner list-group-item-heading">
                Product title</h4>
            <p class="group inner list-group-item-text">
                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <p class="lead">
                        $21.000</p>
                </div>
                <div class="col-xs-12 col-md-6">
                    <a class="btn btn-success" href="https://www.google.co.in">Add to cart</a>
                </div>
            </div>
        </div>
        <c:forEach items="${list}" var="list">
          <c:out value="${list}" />
        </c:forEach>
    </div>
</div>