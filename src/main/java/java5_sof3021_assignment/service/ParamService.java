package java5_sof3021_assignment.service;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;
	
	public String getString(String name, String defaultValue) {
		String un = request.getParameter(name);
		return un;
	}
	
	public int getInt(String name, int defaultValue) {
		Integer bb = Integer.parseInt(request.getParameter(name));
		return bb;
	}
	
	public Double getDouble(String name, double defaultValue) {
		Double bb = Double.parseDouble(request.getParameter(name));
		return bb;
	}
	
	public boolean getBoolean(String name) {
		Boolean bb = Boolean.parseBoolean(request.getParameter(name));
		return bb;
	}
	
	public Date getDate(String name, String pattern) {
		return null;
	}
	
	public File save(MultipartFile name, String path) {
		return null;
	}
}
