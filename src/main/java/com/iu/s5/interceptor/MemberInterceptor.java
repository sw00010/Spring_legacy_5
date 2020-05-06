package com.iu.s5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s5.member.MemberVO;
@Component
public class MemberInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check=false;
		Object obj = request.getSession().getAttribute("member");
		
		if(obj!=null) {
			check=true;
			System.out.println("로그인 상태");
		} else {
			System.out.println("로그인 X");
			request.setAttribute("result", "로그인을 하세요");
			request.setAttribute("path", "./memberLogin");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		return check;
	}
	
	
}
