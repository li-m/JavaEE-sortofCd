<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>

<body>
	<div>
	
	<p><a href="<c:url value="/"/>">Home</a></p>
	
	<form method="get" action="<c:url value="/" />">
		<label for="searchType">Search by: </label>
		<select id="searchType" name="searchType">
			<option value="ID">ID</option>
			<option value="Author">Author</option>
			<option value="Category">Category</option>
			<option value="Song">Song Title</option>
		</select>
		<br />
		
		<label for="searchKeyWord">Key Words</label>
		<input type="text" id="searchKeyWord" name="searchKeyWord" value="<c:out value="${searchContent.keyWord }"></c:out>" />
		<br />
		
		<input type="submit" value="Go" />

		
		<c:if test="${searchForm.validation != 'Empty' }" var="oops" scope="session">
			<c:import url="result.jsp" />
		</c:if>
	</form>
	</div>



</body>
</html>