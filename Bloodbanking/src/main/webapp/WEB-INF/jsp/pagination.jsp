<%@include file="taglib.jsp"%>
<c:if test="${ searchResult.page.totalPages > 1}">
	<div class="options">
		<div class="pagination pagination-sm">
			<c:if test="${searchResult.page.currentPage > 1}"><a href="javascript:setPageNumber('1');" >&laquo;</a></c:if>
			<c:if test="${searchResult.page.currentPage > 1}"><a href="javascript:setPageNumber('<c:out value="${searchResult.page.currentPage - 1}"/>');" >&lt;</a></c:if>
			<c:forEach var="i" begin="${searchResult.page.startPage}" end="${searchResult.page.endPage}" step="1">
				<c:set var="javascriptCall" value="javascript:setPageNumber('${i}')" />
				<a id="page_${i}" class="${searchResult.page.currentPage == i?'active':''}" href="${searchResult.page.currentPage != i ? javascriptCall : '#'}" >${i}</a>
			</c:forEach>
			<c:if test="${searchResult.page.currentPage<searchResult.page.totalPages}"><a href="javascript:setPageNumber('<c:out value="${searchResult.page.currentPage + 1}"/>');">&gt;</a></c:if> 
			<c:if test="${searchResult.page.currentPage<searchResult.page.totalPages}"><a href="javascript:setPageNumber('<c:out value="${searchResult.page.totalPages}" />');">&raquo;</a></c:if>
		</div>
		<input type="hidden" id="pageNumber" name="pageNumber" />
	</div>
</c:if>