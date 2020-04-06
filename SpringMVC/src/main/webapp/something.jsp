<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
first<input type ="text" id ="first">
last<input type="text" id ="last">
<button onclick="showlist()">Submit</button>
</form>

<p class="text"></p>
<script>


function showlist(){
	var search = {}
	search["firstname"] = $("#first").val();
	search["lastname"] = $("#last").val();
	
	$.ajax({
		
		type: "POST",
		url: "/SpringHibernateApp/list",
		// dataType: 'html',
		data:JSON.stringify(search),
		success: function(data){
	
		//alert(data);
	//	$('.text').text(data)
		//window.location.href = "/SpringHibernateApp/response.jsp" ;	
		},
		error:function(e){
			alert("error");
		}
	});
	/* var list = ${somelist};
	$.each(list, function( index, value ) {
		alert( index + ": " + value );
	});
	 */
}
</script>

</body>
</html>