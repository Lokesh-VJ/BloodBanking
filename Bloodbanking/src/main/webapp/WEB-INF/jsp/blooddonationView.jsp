<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle" style="width: 130px;display: inline-block;">Blood donation</h2>
<input type="button" onclick="window.location.href='addBloodDonation.html';" value="Add blood donation" style=" width: 140px;" />

<form method="post" action="viewBloodDonation.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div id="tableLayoutContainer">
			<table id="viewResultsTable">
				<tbody>
					<tr>
						<th>Sl. No.</th>
						<th>Donor name</th>
						<th>Blood bank name</th>
						<th>Blood group</th>
						<th>Quantity</th>
					</tr>
					<c:if test="${fn:length(searchResult.list) == 0}">
						<tr class="noResults">
							<td colspan="5">No Data</td>
						</tr>
					</c:if>
					<c:set var="slNO" value="${ (searchResult.page.currentPage - 1) * searchResult.page.resultsPerPage}" />
					<c:forEach items="${searchResult.list}" var="item">
						<c:set value="${ slNO + 1}" var="slNO" />
						<tr>
							<td><c:out value="${slNO}" /></td>
							<td><c:out value="${item.donorName}" /></td>
							<td><c:out value="${item.bloodBankName}" /></td>
							<td><c:out value="${item.bloodGroupName}" /></td>
							<td><c:out value="${item.bloodUnits}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@include file="pagination.jsp"%>
		</div>
	</div>
</form>