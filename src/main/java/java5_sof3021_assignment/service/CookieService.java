package java5_sof3021_assignment.service;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse reponse;

	public Cookie add(String name, String value, int hours) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours * 24 * 60 * 60);
		cookie.setPath("/");
		reponse.addCookie(cookie);
		return cookie;
	}

	public Cookie get(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					return cookie;
				}
			}
		}
		return null;
	}

	public String getValue(String name) {
		return null;
	}

	public void remove(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					cookie.setPath("/");
					reponse.addCookie(cookie);
				}
			}
		}
	}

	public void alert() {
		try {
			reponse.getWriter().println("<script type=\"text/javascript\">");
			reponse.getWriter().println("alert('Tài khoản mật khẩu không chính xác');");
			reponse.getWriter().println("location.replace('/assignment/login');");
			reponse.getWriter().println("</script>");
			System.err.println("11");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
