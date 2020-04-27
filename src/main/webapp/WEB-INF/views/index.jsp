<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./template/boot.jsp"></c:import>

</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<button id="btn">BUTTON</button>
	<script type="text/javascript">
	
		
		$("#btn").click(function() {
			//jquery ajax
			//GET
			$.get("./notice/noticeSelect?num=219",function(result){
				console.log(result);
			});
		});
		
	</script>
	
</body>
</html>



