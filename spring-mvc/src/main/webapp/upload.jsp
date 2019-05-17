<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<form id="fileuploadForm" action="/spring-mvc/uploads" method="POST" enctype="multipart/form-data" class="cleanform">
			<label for="file">File</label>
			<input id="file" type="file" name="file" />
			<p><button type="submit">上传</button></p>		
</form>
</body>
</html>
