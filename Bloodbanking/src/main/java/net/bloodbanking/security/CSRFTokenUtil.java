package net.bloodbanking.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class CSRFTokenUtil {
	
	private final static String DEFAULT_PRNG = "SHA1PRNG";
	
	public final static String SESSION_ATTR_KEY = "csrfToken";
	
	private final static String NO_SESSION_ERROR = "No valid session found";
	
	private static boolean uniquePerRequest = true;

	private static String getToken() throws NoSuchAlgorithmException {
		return getToken(DEFAULT_PRNG);
	}

	private static String getToken(String prng) throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance(prng);
		return "" + sr.nextLong();
	}

	public static String getToken(HttpSession session) throws ServletException,
			NoSuchAlgorithmException {
		if (session == null) {
			throw new ServletException(NO_SESSION_ERROR);
		}
		String last_token_val = (String) session.getAttribute(SESSION_ATTR_KEY);
		if (last_token_val == null || uniquePerRequest) {
			String new_token_val = getToken();
			if (last_token_val == null) {
				last_token_val = new_token_val;
			}
			session.setAttribute(SESSION_ATTR_KEY, new_token_val);
		}
		return last_token_val;
	}

	public static boolean isValid(HttpServletRequest request)
			throws ServletException, NoSuchAlgorithmException {
		if (request.getSession(false) == null) {
			throw new ServletException(NO_SESSION_ERROR);
		}
		String lastToken = getToken(request.getSession(false));
		String requestToken = request.getParameter(SESSION_ATTR_KEY);
		return lastToken.equals(requestToken);
	}

}
