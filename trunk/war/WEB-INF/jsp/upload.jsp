<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form enctype="multipart/form-data" action="/upload.htm" method="post">
  <input type="file" name="uploadedfile">
  <input type="submit" value="upload">
</form:form>
<form:form action="/upload.htm" method="delete">
  <input type="hidden" value="ram.pdf">
  <input type="submit" value="delete">
</form:form>
