<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">User</h2>
<form method="post" action="viewUser.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div id="tableLayoutContainer">
			<table id="viewResultsTable">
				<tbody>
					<tr>
						<th>Sl. No.</th>
						<th>User Type</th>
						<th>Name</th>
						<th>Gender</th>
						<th>Date of Birth</th>
						<th>Blood group</th>
						<th>User name</th>
						<th>Address</th>
						<th>Action</th>
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
							<td><c:out value="${item.usertypeName}" /></td>
							<td><c:out value="${item.locationAddressDTO.name}" /></td>
							<td><c:out value="${item.gender}" /></td>
							<td><c:out value="${item.birthDate}" /></td>
							<td><c:out value="${item.bloodGroupName}" /></td>
							<td><c:out value="${item.userName}" /></td>
							<td><c:out value="${item.locationAddressDTO.address} ${item.locationAddressDTO.city} ${item.locationAddressDTO.state} ${item.locationAddressDTO.pincode}" /></td>
							<td>
								<a href="javascript:doModuleAction('detailUser.html', 'userNameAMF', '${item.userName}')">View</a>
								<c:if test="${item.statusMstDTO.status == inactiveFlag}">
									<a href="javascript:doModuleActionWithConfirmation('activateUser.html', 'User will be activated, are you sure?', 'userNameAMF', '${item.userName}')">
										Activate
									</a>
								</c:if>
								<c:if test="${item.statusMstDTO.status == activeFlag}">
									<a href="javascript:doModuleActionWithConfirmation('deactivateUser.html', 'User will be deactivated, are you sure?', 'userNameAMF', '${item.userName}')">
										Deactivate
									</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@include file="pagination.jsp"%>
		</div>
	</div>
</form>
<form method="post" id="additionalModuleForm" name="additionalModuleForm">
	<input type="hidden" id="userNameAMF" name="userName" />
</form>