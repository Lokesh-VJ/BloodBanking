package net.bloodbanking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.dto.BaseDTO;

@SuppressWarnings("unchecked")
public abstract class BaseController {

	protected void setUserDetailsFromSession(HttpServletRequest request, final BaseDTO... dtoArray) {
		for (BaseDTO baseDTO : dtoArray) {
			baseDTO.setLogginUserName((String) getValueFromSession(request, AppConstants.USERNAME));
			// TODO, role to be enabled...
			//baseUiDTO.setLoginUserRoleName(((LoginUserUiDTO) getValueFromSession(request, WebConstants.LOGIN_USER)).getRoleName());
			// validateSuperUser(baseDTO, request);
		}
	}

	protected void setValueInSession(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute(key, value);
		}
	}

	protected Object getValueFromSession(HttpServletRequest request, String key) {
		HttpSession session = request.getSession(false);
		Object object = null;
		if (session != null) {
			object = session.getAttribute(key);
		}
		return object;
	}

	/*protected boolean validateSuperUser(final BaseDTO baseDTO, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginUserUiDTO loginUserUiDTO = (LoginUserUiDTO) session.getAttribute(AppConstants.USERNAME);
			baseDTO.setSuperUser(false);
			baseDTO.setMerchantAdmin(false);
			baseDTO.setOutletUser(false);
			if (loginUserUiDTO.getRoleName().equals(AppConstants.SUPER_USER)) {
				baseDTO.setSuperUser(true);
				return true;
			} else if (loginUserUiDTO.getRoleName().equals(AppConstants.MERCHANT_ADMIN)) {
				baseDTO.setMerchantAdmin(true);
			} else if (loginUserUiDTO.getRoleName().equals(AppConstants.OUTLET_USER)) {
				baseDTO.setOutletUser(true);
			}
		}
		return false;
	}*/
}
