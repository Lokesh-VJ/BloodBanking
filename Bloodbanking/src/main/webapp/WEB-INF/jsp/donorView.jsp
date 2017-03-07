<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">Donor</h2>
<form method="post" action="viewDonor.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div id="tableLayoutContainer">
			<table id="viewResultsTable">
				<tbody>
					<tr>
						<th>Sl. No.</th>
						<th>Name</th>
						<th>Gender</th>
						<th>Date of Birth</th>
						<th>Blood group</th>
						<th>User name</th>
						<th>Address</th>
					</tr>
					<c:if test="${fn:length(searchResult.list) == 0}">
						<tr class="noResults">
							<td colspan="7">No Data</td>
						</tr>
					</c:if>
					<c:set var="slNO" value="${ (searchResult.page.currentPage - 1) * searchResult.page.resultsPerPage}" />
					<c:forEach items="${searchResult.list}" var="item">
						<c:set value="${ slNO + 1}" var="slNO" />
						<tr>
							<td><c:out value="${slNO}" /></td>
							<td><c:out value="${item.locationAddressDTO.name}" /></td>
							<td><c:out value="${item.gender}" /></td>
							<td><c:out value="${item.birthDate}" /></td>
							<td><c:out value="${item.bloodGroupName}" /></td>
							<td><c:out value="${item.userName}" /></td>
							<td><c:out value="${item.locationAddressDTO.address} ${item.locationAddressDTO.city} ${item.locationAddressDTO.state} ${item.locationAddressDTO.pincode}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@include file="pagination.jsp"%>
		</div>
	</div>
</form>