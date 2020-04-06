<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:profileTemplate>

<script>
$(document).ready(function() {
    $('#list').click(function(event){
    	event.preventDefault();
    	$('#products .item').removeClass('col-xs-4');
    	$('#products .item').addClass('col-xs-12');
    	$('#products .list-group-image').addClass('col-xs-4');
    	$('#products .caption').addClass('col-xs-8');
     });
    $('#grid').click(function(event){
    	event.preventDefault();
    	$('#products .item').removeClass('col-xs-12');
    	$('#products .item').addClass('col-xs-4');
    	$('#products .list-group-image').removeClass('col-xs-4');
    	$('#products .caption').removeClass ('col-xs-8');
    });
});
</script>

<div class="container">
    <div class="well well-sm">
        <strong>Category Title</strong>
        <div class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
    </div>
    <%-- <c:set var="isGrid" value="true"/>
    <div id="products" class="row">
        <c:forEach var="i" begin="0" end="10" step="1">
        	<c:choose>
        		<c:when test="${isGrid}">
        			<jsp:include page="grid_item.jsp"></jsp:include>
		    	</c:when>
		    	<c:otherwise>
		    		<jsp:include page="list_item.jsp"></jsp:include>
		    	</c:otherwise>
        	</c:choose>
		    
		</c:forEach>
       
    </div> --%>
    
    <div id="products" class="row">
     <c:forEach items="${peopleList}" var="list">
	        <div class="item  col-xs-4">
			    <div class="thumbnail">
			        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
			        <div class="caption">
			       
			            <h4 class="group inner list-group-item-heading">
			                <c:out value="${list.firstName}" />
			                <c:out value="${list.lastName}" />
			                </h4>
			            <p class="group inner list-group-item-text">
			               <c:out value="${list.email}" />
			               </p>
			            
			            <div class="row">
			                <div class="col-xs-12 col-md-6">
			                    <p class="lead">
			                        The Digital Group</p>
			                </div>
			                <div class="col-xs-12 col-md-6">
			                    <a class="btn btn-success" >follow</a>
			                </div>
			            </div>
			        </div>
			    </div>
			</div>
       </c:forEach>
    </div>
</div>

<script>
function followUnfollow(){
$('button').click(function(){
	  var $this = $(this);
	  $this.toggleClass('following')
	  if($this.is('.following')){
	    $this.addClass('wait');
	  }
	})
}
</script>
</t:profileTemplate>
