<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="departmentId"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="departmentId">
	<option value="">선택
	<option value="10">Administration
	<option value="20">marketing
	<option value="50">Shipping
	<option value="60">IT
	<option value="80">Sales
</select>
<<script type="text/javascript">
searchFrm.departmentId.value = '${empVO.departmentId}'
</script>
<!-- paging객체 매핑 -->