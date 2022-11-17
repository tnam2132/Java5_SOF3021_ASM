package java5_sof3021_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java5_sof3021_assignment.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/login/form","/register/form","/register");
	}
	
}
