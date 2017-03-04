<%@include file="taglib.jsp"%>
<c:if test="${ searchResult.page.totalPages > 1}">
	<div class="options">
		<ul id="nav-list" class="pagination pagination-sm">
			<c:if test="${searchResult.page.currentPage ne 1}"><li><a <c:if test="${searchResult.page.currentPage!='1'}">href="javascript:setPageNumber('1');" </c:if>>&laquo;</a></li></c:if>
			<c:if test="${searchResult.page.currentPage ne 1}"><li><a <c:if test="${searchResult.page.currentPage!='1'}">href="javascript:setPageNumber('<c:out value="${searchResult.page.currentPage - 1}"/>');" </c:if>>&lt;</a></li></c:if>
			<c:forEach var="i" begin="${searchResult.page.startPage}" end="${searchResult.page.endPage}" step="1">
				<li id="page_${i}" class="${baseDTO.pageNumber == i?'active':''}">
					<a onclick="javascript:setPageNumber('<c:out value="${i}" />');">${i}</a>
				</li>
			</c:forEach>
			<c:if test="${searchResult.page.currentPage ne searchResult.page.totalPages}"><li><a <c:if test="${searchResult.page.currentPage<searchResult.page.totalPages}">href="javascript:setPageNumber('<c:out value="${searchResult.page.currentPage + 1}"/>');"</c:if>>&gt;</a></li></c:if> 
			<c:if test="${searchResult.page.currentPage ne searchResult.page.totalPages}"><li><a <c:if test="${searchResult.page.totalPages!=searchResult.page.currentPage}">href="javascript:setPageNumber('<c:out value="${searchResult.page.totalPages}" />');"</c:if>>&raquo;</a></li></c:if>
		</ul>
		<input type="hidden" id="pageNumber" name="pageNumber" value="${baseDTO.pageNumber}"/>
	</div>
</c:if>