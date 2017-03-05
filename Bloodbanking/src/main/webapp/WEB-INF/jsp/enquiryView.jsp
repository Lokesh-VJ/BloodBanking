<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">Inquiry</h2>
<form method="post" action="viewInquiry.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div id="tableLayoutContainer">
			<table id="viewResultsTable">
				<tbody>
					<tr>
						<th>Sl. No.</th>
						<th>Name</th>
						<th>Email Id</th>
						<th>Contact Number</th>
						<th>Inquiry</th>
					</tr>
					<c:if test="${null == searchResult.list}">
						<tr class="noResults">
							<td colspan="3">No Data</td>
						</tr>
					</c:if>
					<c:set var="slNO" value="${ (searchResult.page.currentPage - 1) * searchResult.page.resultsPerPage}" />
					<c:forEach items="${searchResult.list}" var="item">
						<c:set value="${ slNO + 1}" var="slNO" />
						<tr>
							<td><c:out value="${slNO}" /></td>
							<td><c:out value="${item.locationAddressDTO.name}" /></td>
							<td><c:out value="${item.locationAddressDTO.emailId}" /></td>
							<td><c:out value="${item.locationAddressDTO.mobileNumber}" /></td>
							<td><c:out value="${item.message}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@include file="pagination.jsp"%>
		</div>
	</div>
</form>