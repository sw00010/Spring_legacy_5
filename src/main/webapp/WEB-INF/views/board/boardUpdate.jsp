<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
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
		<h1>${fn:toUpperCase(board)}  Update Form</h1>
		
		
		<form action="./${board}Update" id="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${vo.num}">
		  <div class="form-group">
		    <label for="title">Title:</label>
		    <input type="text" value="${vo.title}" class="form-control" id="title" name="title">
		  </div>
		  <div class="form-group">
		    <label for="writer">Writer:</label>
		    <input type="text" disabled="disabled" value="${vo.writer}" class="form-control" id="writer" name="writer">
		  </div>
		 <div class="form-group" >
		    <label for="contents">Contents:</label>
		    <textarea rows="5" cols="" class="form-control" id="contents" name="contents">${vo.contents}</textarea>
		  </div> 
		  
		  
		<input type="button" id="add" class="btn btn-info" value="AddFile">
			<div id="file">
			
			
			
			</div>
			
			
			
		  		<div class="form-group">
		  			<label for="files">Files:</label>
		  	
		  	
		  				<c:forEach items="${vo.boardFileVOs}" var="fileVO">
		  					<p>${fileVO.oriName}<i id="${fileVO.fileNum}" title="${fileVO.board}" class='glyphicon glyphicon-remove remove fileDelete'></i></p>	
		  				</c:forEach>
		  
		  		</div>
		  
		  
		  
		  
		  
		  
		  <input type="submit" id="btn" class="btn btn-default" value="Write">
		</form>
		
	</div>
	
	
	<h1>asdaa </h1>
	
	<script type="text/javascript" src="../resources/js/boardForm.js"></script>
	<script type="text/javascript">
		$("#contents").summernote('code','${vo.contents}');
		
		var size = ${size};
		
		size= ${vo.boardFileVOs.size()};
		size = ${fn:length(vo.boardFileVOs)};
		count = count+size;
		
			
		$(".fileDelete").click(function(){
			var check = confirm("정말 지울거냐?");
			
			if(check){
				
			var s = $(this);
			$.post("../boardFile/fileDelete",{fileNum : $(this).attr("id"),board : $(this).attr("title")},function(data){
				
				
				if(data.trim()>0){
					
						s.parent().remove();
						count--;
					
				}else{
					alert("File Delete Fail");
				}
			});
			}
		});
		
		
	
	</script>
</body>

</html>