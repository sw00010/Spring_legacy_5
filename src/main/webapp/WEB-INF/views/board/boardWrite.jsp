<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header_sub.jsp"></c:import>
	<div class="container">
		<h1>${board}Write Form</h1>


		<form action="./${board}Write" id="frm" method="post"
			enctype=multipart/form-data>
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text"
					class="form-control" id="writer" name="writer" value="${member.id}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea rows="20" cols="" class="form-control" id="contents"
					name="contents"></textarea>
			</div>

			<input type="button" id="add" class="btn btn-info" value="AddFile">
			<div id="file">

			</div>



			<input type="button" id="btn" class="btn btn-default" value="Write">
		</form>

	</div>

<!-- 	<script type="text/javascript" src="../resources/js/boardForm.js"> -->

<script type="text/javascript">

	$('#contents').summernote({
		height : 300,
		callbacks : {
			onImageUpload : function(file) {
				$.ajax({
					type:"POST",
					url:"../boardFile/fileInsert",
					enctype:"multipart/form-data",
					cache:false,
					contentType:false,
					processData:false,
					success:function(imageNamew){}
				});
			}
		}
	});
</script>
			
		
	</script>
</body>
</html>