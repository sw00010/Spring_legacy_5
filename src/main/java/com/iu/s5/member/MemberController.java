package com.iu.s5.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.member.memberPage.MemberPager;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberList", method = RequestMethod.GET)
	public ModelAndView memberList(MemberPager memberPager, ModelAndView mv)throws Exception{
		List<MemberVO> ar = memberService.memberList(memberPager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", memberPager);
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	@RequestMapping(value = "memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}

	@RequestMapping(value= "memberJoin")
	public void memberJoin() {
		
	}
	
	@RequestMapping(value= "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, ModelAndView mv) throws Exception {
		int result = memberService.memberJoin(memberVO);
		String msg ="Member Join Fail";
		if(result>0) {
			msg = "Member Join Success";
		}
		
		mv.addObject("result", msg);
		mv.addObject("path", "../");
		mv.setViewName("../common/result.jsp");
		
		return mv;
	}
	
	@RequestMapping(value= "memberLogin")
	public void memberLogin() {
		
	}
	
	@RequestMapping(value= "memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		
		 memberVO = memberService.memberLogin(memberVO);
		
		 if(memberVO != null) {
			 session.setAttribute("member", memberVO);
			 mv.setViewName("redirect:../");
		 }else {
			 mv.addObject("result", "Login Fail");
			 mv.addObject("path", "./memberJoin");
			 mv.setViewName("../common/result.jsp");
		 }
		 
		//로그인 성공이면 index
		//로그인 실패 하면 로그인 실패 alert login form 이동		 
				 
				 
		return mv;
	}
	
	@RequestMapping(value= "memberPage")
	public void memberPage() {
		
	}

	
	@RequestMapping(value= "memberUpdate")
	public void memberUpdate() {
		
	}
	
	@RequestMapping(value= "memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		String id = ((MemberVO)session.getAttribute("member")).getId();
		memberVO.setId(id);
		
		int result = memberService.memberUpdate(memberVO);
		
		if(result>0) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:./memberPage");
		}else {
			 mv.addObject("result", "Update Fail");
			 mv.addObject("path", "./memberPage");
			 mv.setViewName("../common/result.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping(value= "memberDelete")
	public ModelAndView memberDelete(ModelAndView mv, HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.memberDelete(memberVO);
		if(result>0) {
			session.invalidate();
			mv.addObject("result", "Delete Success");
			mv.addObject("path", "../");
			mv.setViewName("../common/result.jsp");
		}else {
			mv.addObject("result", "Delete Fail");
			mv.addObject("path", "../");
			mv.setViewName("../common/result.jsp");
		}
		
		return mv;
	}
	
}
