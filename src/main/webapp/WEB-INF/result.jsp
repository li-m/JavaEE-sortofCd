<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<p>Searched by <c:out value="${ searchContent.type }" />
	</p>
	
	<p>Search Content :<c:out value="${ searchContent.keyWord }" />
	</p>	 
	<table>
    <c:forEach items="${SearchResult}" var="cd">
        <tr>
            <td>${cd.id}</td>
            <td><c:out value="${cd.name}" /></td>
            <td>${cd.category}</td>
            <td>${cd.author}</td>
        </tr>
    </c:forEach>
</table>
</div>