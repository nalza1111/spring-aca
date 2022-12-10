<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="departmentId">
	<option value="">선택
	<option value="10" <c:if test="${empVO.departmentId=='10'}">selected</c:if> >Administration
	<option value="20" <c:if test="${empVO.departmentId=='20'}">selected</c:if>>marketing
	<option value="50" <c:if test="${empVO.departmentId=='50'}">selected</c:if>>Shipping
	<option value="60" <c:if test="${empVO.departmentId=='60'}">selected</c:if>>IT
	<option value="80" <c:if test="${empVO.departmentId=='80'}">selected</c:if>>Sales
</select>
<!-- paging객체 매핑 -->