<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">Blood bank stock</h2>
<form method="post" action="viewBloodBankStock.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div id="tableLayoutContainer">
			<div id="viewResultsSearchCriteria">
				<select name="registrationId" id="registrationId" style="width: 150px;" >
					<option value="">Select</option>
					<c:forEach items="${bloodBankList}" var="bloodBank">
						<option value="${bloodBank.registrationId}" ${(bloodBank.registrationId == baseDTO.registrationId)?'selected':''}>${bloodBank.locationAddressDTO.name}</option>
					</c:forEach>
				</select>
				<select name="bloodGroup" id="bloodGroup" style="width: 150px;">
					<option value="">Select blood group</option>
					<c:forEach items="${bloodGroupList}" var="bloodGroup">
						<option value="${bloodGroup.bloodGroupId}" ${(bloodGroup.bloodGroupId == baseDTO.bloodGroup)?'selected':''}>${bloodGroup.bloodGroupName}</option>
					</c:forEach>
				</select>
				<input type="submit" id="searchBtn" name="searchBtn" value="Search" style="width: 60px;" />
			</div>
			<table id="viewResultsTable">
				<tbody>
					<tr>
						<th>Sl. No.</th>
						<th>Blood bank name</th>
						<th>Blood group</th>
						<th>Donated Blood Unit(s)</th>
						<th>Supplied Blood Unit(s)</th>
						<th>Rejected Blood Unit(s)</th>
						<th>Pending Blood Unit(s)</th>
						<th>Available Blood Unit(s)</th>
					</tr>
					<c:if test="${fn:length(searchResult.list) == 0}">
						<tr class="noResults">
							<td colspan="8">No Data</td>
						</tr>
					</c:if>
					<c:set var="slNO" value="${ (searchResult.page.currentPage - 1) * searchResult.page.resultsPerPage}" />
					<c:forEach items="${searchResult.list}" var="item">
						<c:set value="${ slNO + 1}" var="slNO" />
						<tr>
							<td><c:out value="${slNO}" /></td>
							<td><c:out value="${item.bloodBankName}" /></td>
							<td><c:out value="${item.bloodGroupName}" /></td>
							<td><c:out value="${item.donotedBloodUnits}" /></td>
							<td><c:out value="${item.suppliedBloodUnits}" /></td>
							<td><c:out value="${item.rejectedBloodUnits}" /></td>
							<td><c:out value="${item.pendingBloodUnits}" /></td>
							<td><c:out value="${item.totalAvailableBloodUnits}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@include file="pagination.jsp"%>
		</div>
	</div>
</form>