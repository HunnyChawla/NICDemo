<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${data}
	<core:forEach items="${data}" var="CompanyDetails">
	    <tr>
	        <td>Employee ID: <c:out value="${CompanyDetails.name}"/></td>
	        <td>Employee Pass: <c:out value="${CompanyDetails.cin}"/></td>  
	    </tr>
	</cpre:forEach>
</body>
</html>