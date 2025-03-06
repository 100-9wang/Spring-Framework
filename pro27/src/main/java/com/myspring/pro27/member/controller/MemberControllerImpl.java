package com.myspring.pro27.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;

@Controller("memberController")
//@EnableAspectJAutoProxy
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	@Override
	@RequestMapping(value = "/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("viewName : " + viewName);
		logger.debug("viewName : " + viewName);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView();
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
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
	    int result = memberService.modMembers(member);  // 수정 작업 수행	    
	    ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");  // 수정 후 목록으로 리다이렉트
	    return mav;
	}
	
	@RequestMapping(value = "/member/modMember.do", method = RequestMethod.GET)
	public ModelAndView modform(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String viewName = getViewName(request);
		//ModelAndView mav = new ModelAndView("modMember"); //#Origin
		ModelAndView mav = new ModelAndView(); // #2
		mav.setViewName(viewName); // #2
	    mav.addObject("id", id);
	    return mav;
	}
	@RequestMapping(value = {"/member/loginForm.do", "/member/memberForm.do" }, method = RequestMethod.GET)
	//@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	public ModelAndView form (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, 
								HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member);
		if(memberVO != null) {
			HttpSession session = request.getSession();
			System.out.println("#로그인 체크");
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/member/listMembers.do");
		} else {
			rAttr.addAttribute("result", "loginFailed");
			System.out.println("#로그인 체크2");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}
	
	@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required = false) String result,
								HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
	    String contextPath = request.getContextPath();
	    String uri = request.getRequestURI();

	    if (uri.startsWith(contextPath)) {
	        uri = uri.substring(contextPath.length());
	    }
	    int end = uri.indexOf(".");
	    if (end != -1) {
	        uri = uri.substring(0, end);
	    }
	    return uri;
	}

//	private String getViewName (HttpServletRequest request) throws Exception {
//		String contextPath = request.getContextPath();
//		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
//		if(uri == null || uri.trim().equals("")) {
//			uri = request.getRequestURI();
//		}
//		
//		int begin = 0;
//		if(!((contextPath == null) || ("".equals(contextPath)))) {
//			begin = contextPath.length();
//		}
//		
//		int end;
//		if(uri.indexOf(";") != -1) {
//			end = uri.indexOf(";");
//		} else if (uri.indexOf("?") != -1) {
//			end = uri.indexOf("?");
//		} else {
//			end = uri.length();
//		}
//		
//		String viewName = uri.substring(begin, end);
//		if(viewName.indexOf(".") != -1) {
//			viewName = viewName.substring(0, viewName.lastIndexOf("."));
//		}
//		if(viewName.lastIndexOf("/") != -1) {
//			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
//		}
//		return viewName;
//	}
	
	}
