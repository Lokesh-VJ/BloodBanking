package net.bloodbanking.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import net.bloodbanking.constants.AppConstants;

public class CSRFValidationFilter implements Filter {

	private Logger logger = Logger.getLogger(this.getClass());

	public void init(FilterConfig filterConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);

		if ((request instanceof HttpServletRequest)&& (response instanceof HttpServletResponse)) {

			try {
				if(byPassUris(httpServletRequest)){
					if(null != session){
						boolean isValidRequest = true;
						String token_val = (String) session.getAttribute(CSRFTokenUtil.SESSION_ATTR_KEY);
						if (token_val != null && !httpServletRequest.getRequestURI().endsWith("processLogin.html") ) {
							isValidRequest = true;/*CSRFTokenUtil.isValid(httpServletRequest);*/
							if (!isValidRequest) {
								String userName = (String) session.getAttribute("userName");
								logger.warn("Invalid security Token. Supplied token: " 
										+ request.getParameter(CSRFTokenUtil.SESSION_ATTR_KEY) 
										+ ". Session token: " + token_val 
										+ ". IP: " + request.getRemoteAddr());
								logger.fatal("CSRF attack detected. Date/Time " + new Date() + " \n. User ID:" + userName);
								RequestDispatcher rd = request.getRequestDispatcher(AppConstants.SESSION_TIMEOUT_PAGE);
								rd.forward(request, response);
								return;
							}
						} else {
							CSRFTokenUtil.getToken(session);
						}
					}
				}else{ 
					filterChain.doFilter(request, response); 
					return;
				}
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		filterChain.doFilter(request, response);
	}

	public void destroy() {}

	public boolean byPassUris(HttpServletRequest httpServletRequest) {
		return (httpServletRequest.getRequestURI().indexOf("login.html") == -1 
				&& httpServletRequest.getRequestURI().indexOf("forgotPassword.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("verifySecurityQuestion.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("processForgotPassword.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("signup.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("processSignup.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("enquiry.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("processEnquiry.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("feedback.html") == -1
				&& httpServletRequest.getRequestURI().indexOf("processFeedback.html") == -1);
	}

}
