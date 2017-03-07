<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle" style="width: 130px;display: inline-block;">Blood Request</h2>
<c:if test="${not empty isPatient}">
	<input type="button" onclick="window.location.href='addBloodRequest.html';" value="Add blood request" style=" width: 140px;" />
</c:if>

<form method="post" action="viewBloodRequest.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div id="tableLayoutContainer">
			<table id="viewResultsTable">
				<tbody>
					<tr>
						<th>Sl. No.</th>
						<th>Patient name</th>
						<c:if test="${empty isPatient}">
							<th>Patient address</th>
						</c:if>
						<th>Blood bank name</th>
						<c:if test="${not empty isPatient}">
							<th>Blood bank address</th>
						</c:if>
						<th>Blood group</th>
						<th>Quantity</th>
						<th>Status</th>
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
							<td><c:out value="${item.patientName}" /></td>
							<c:if test="${empty isPatient}">
								<td><c:out value="${item.patientAddress}" /></td>
							</c:if>
							<td><c:out value="${item.bloodBankName}" /></td>
							<c:if test="${not empty isPatient}">
								<td><c:out value="${item.bloodBankAddress}" /></td>
							</c:if>
							<td><c:out value="${item.bloodGroupName}" /></td>
							<td><c:out value="${item.bloodUnits}" /></td>
							<td>
								<c:if test="${empty isPatient}">
									<c:if test="${item.status == activeFlag}">
										<a href="javascript:doModuleActionWithConfirmation('supplyBloodRequest.html', 'Supply blood as per request, are you sure?', 'patientBloodbankMappingIdAMF', '${item.patientBloodbankMappingId}')">
											Supply
										</a> / 
										<a href="javascript:doModuleActionWithConfirmation('rejectBloodRequest.html', 'Reject blood request, are you sure?', 'patientBloodbankMappingIdAMF', '${item.patientBloodbankMappingId}')">
											Reject
										</a>
									</c:if>
									<c:if test="${item.status != activeFlag}">
										<c:out value="${item.statusStr}" />
									</c:if>
								</c:if>
								<c:if test="${not empty isPatient}">
									<c:if test="${item.status == activeFlag}">
										Pending
									</c:if>
									<c:if test="${item.status != activeFlag}">
										<c:out value="${item.statusStr}" />
									</c:if>
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
	<input type="hidden" id="patientBloodbankMappingIdAMF" name="patientBloodbankMappingId" />
</form>