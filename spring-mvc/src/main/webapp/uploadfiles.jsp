<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="fileuploadForm" action="/spring-mvc/uploadfiles" method="POST" enctype="multipart/form-data" class="cleanform">
			<label for="file">File</label>
			<input id="file" type="file" name="files" />
			<br>
			<br>
			<label for="file">File</label>
			<input id="file" type="file" name="files" />
			<br><br>
			<!-- <label for="file">File</label>
			<input id="file" type="file" name="files" /> -->
			<p><button type="submit">Upload</button></p>				
</form>
</body>
</html>