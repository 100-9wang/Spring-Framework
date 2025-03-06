package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String viewName = getViewName(request);
	    List membersList = memberService.listMembers();
	    ModelAndView mav = new ModelAndView(viewName);  // View name을 ModelAndView에 설정
	    mav.addObject("membersList", membersList);
	    return mav;
	}

	
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
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
		bind(request, memberVO);
		int result = 0;
		result = memberService.addMember(memberVO);
		System.out.println("addmember" + result);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		memberService.removeMember(id);
		System.out.println("remove" + id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	public ModelAndView modMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("utf-8");
	    
	    MemberVO memberVO = new MemberVO();
	    bind(request, memberVO);  // 수정된 데이터를 MemberVO 객체에 바인딩
	    
	    int result = memberService.modMembers(memberVO);  // 수정 작업 수행
	    
	    ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");  // 수정 후 목록으로 리다이렉트
	    return mav;
	}
	
	public ModelAndView modform(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ModelAndView mav = new ModelAndView("modMember");
	    mav.addObject("id", id);
	    return mav;
	}

	public ModelAndView form (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	private String getViewName(HttpServletRequest request) throws Exception {
	    String contextPath = request.getContextPath();
	    String uri = (String) request.getAttribute("javax.servlet.include.request_uri");

	    if (uri == null || uri.trim().equals("")) {
	        uri = request.getRequestURI();
	    }

	    // contextPath 제거
	    if (uri.startsWith(contextPath)) {
	        uri = uri.substring(contextPath.length());
	    }

	    // 파일 확장자(.do 등) 제거
	    int end = uri.indexOf(".");
	    if (end != -1) {
	        uri = uri.substring(0, end);
	    }

	    // "/member" 경로 제거
	    if (uri.startsWith("/member")) {
	        uri = uri.substring("/member".length());
	    }

	    // 반환된 뷰 이름을 로그로 출력해 확인
	    System.out.println("Returned View Name: " + uri);
	    return uri;
	}


	}
