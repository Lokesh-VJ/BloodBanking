<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">Blood Availability</h2>

<form method="post" action="viewBloodAvailability.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div id="tableLayoutContainer">
			<div id="viewResultsSearchCriteria">
				<select name="bloodGroupId" id="bloodGroupId" style="width: 150px;" required>
					<option value="">Select blood group</option>
					<c:forEach items="${bloodGroupList}" var="bloodGroup">
						<option value="${bloodGroup.bloodGroupId}" ${(bloodGroup.bloodGroupId == baseDTO.bloodGroupId)?'selected':''}>${bloodGroup.bloodGroupName}</option>
					</c:forEach>
				</select>
				<input type="submit" id="searchBtn" name="searchBtn" value="Search" style="width: 60px;" />
			</div>
			<table id="viewResultsTable">
				<tbody>
					<tr>
						<th>Sl. No.</th>
						<th>Blood bank name</th>
						<th>Blood bank address</th>
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
							<td><c:out value="${item.bloodBankName}" /></td>
							<td><c:out value="${item.bloodBankAddress}" /></td>
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