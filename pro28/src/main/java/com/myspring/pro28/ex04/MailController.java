package com.myspring.pro28.ex04;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping(value= "/sendMail.do", method = RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
		sb.append("<h1>"+"제품소개"+"<h1><br>");
		sb.append("신간 도서를 소개합니다.<br><br>");
		sb.append("<a href='https://www.coupang.com/vp/products/8131259838?itemId=23091855765&vendorItemId=90125277250&sourceType=cmgoms&omsPageId=s2148&omsPageUrl=s2148&isAddedCart='>");
		sb.append("<img src='https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/1148422134576857-b95a4e94-a7d7-4ee3-a11c-f6dcb05285f7.jpg'/> </a><br>");
		sb.append("</a>");
		sb.append("<a href='https://www.coupang.com/vp/products/8131259838?itemId=23091855765&vendorItemId=90125277250&sourceType=cmgoms&omsPageId=s2148&omsPageUrl=s2148&isAddedCart='>상품보기</a>");
		sb.append("</body></html>");
		String str = sb.toString();
		mailService.sendMail("ehtm@naver.com", "신상품을 소개합니다.", str);
		out.print("메일 전송 완료 !!");
	}
}
