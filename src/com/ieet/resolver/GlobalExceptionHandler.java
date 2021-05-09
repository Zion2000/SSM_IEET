package com.ieet.resolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public Model handler(Model model,Exception ex) {
		model.addAttribute("msg", "服务器异常：访问数据失败");
		return model;
	}
}
