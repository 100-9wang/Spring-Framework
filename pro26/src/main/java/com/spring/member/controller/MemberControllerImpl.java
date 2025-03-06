package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	MemberVO memberVO;
	
	@Override
	@RequestMapping(value = "/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	    String viewName = getViewName(request);
	    List membersList = memberService.listMembers();
	    ModelAndView mav = new ModelAndView(viewName);  // View name을 ModelAndView에 설정
	    mav.addObject("membersList", membersList);
	    return mav;
	}

	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		/*
		 String id = request.getparameter("id");
		 String pwd = request.getparameter("pwd");
		 String name = request.getparameter("name");
		 String email = request.getparameter("email");
		 
		 memberVO.setId(id);
		 memberVO.setPwd(pwd);
		 memberVO.setName(name);
		 memberVO.setEmail(email);
		 */
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/modMembers.do", method = RequestMethod.POST)
	public ModelAndView modMembers(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("UTF-8");
	    int result = memberService.modMembers(member);  // 수정 작업 수행	    
	    ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");  // 수정 후 목록으로 리다이렉트
	    return mav;
	}
	
	@RequestMapping(value = "/member/modMember.do", method = RequestMethod.GET)
	public ModelAndView modform(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		ModelAndView mav = new ModelAndView("modMember");
	    mav.addObject("id", id);
	    return mav;
	}

	@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	public ModelAndView form (HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	private String getViewName(HttpServletRequest request) throws Exception {
	    String contextPath = request.getContextPath();
	    String uri = request.getRequestURI();

	    if (uri.startsWith(contextPath)) {
	        uri = uri.substring(contextPath.length());
	    }

	    // "." 위치가 없을 때 처리
	    int end = uri.indexOf(".");
	    if (end != -1) {
	        uri = uri.substring(0, end);
	    }

	    // "/member" 경로 제거
	    if (uri.startsWith("/member")) {
	        uri = uri.substring("/member".length());
	    }

	    return uri;
	}



	}
