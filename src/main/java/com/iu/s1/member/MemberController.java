package com.iu.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "member";
	}
	
	//filedown
	@RequestMapping(value="photoDown", method=RequestMethod.GET)
	public ModelAndView fileDown(MemberFileDTO memberFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fileDown");
		
		
		
		memberFileDTO = memberService.detailFile(memberFileDTO);
		
		mv.addObject("file", memberFileDTO);
		
		return mv;
	}
	
	//mypage
	@RequestMapping(value = "mypage", method=RequestMethod.GET)
	public ModelAndView mypage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto", memberDTO);
		
		return mv;
	}
	
	//logout
	@RequestMapping(value = "logout", method=RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(HttpSession session, MemberDTO memberDTO,String remember, Model model, HttpServletResponse response)throws Exception{
		
		System.out.println("Remember : "+remember);
		
		if(remember != null && remember.equals("1")) {
			//cookie 생성
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			//cookie.setPath("/");
			cookie.setMaxAge(-1);
			//응답
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		memberDTO = memberService.login(memberDTO);
		
//		String path="redirect:./login";
//		
//		if(memberDTO != null) {
//			session.setAttribute("member", memberDTO);
//			path = "redirect:../";
//		}
		
		String message="Login Fail";
		String p="./login";
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			message="Login Success";
			p="../";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		String path="common/result";
		return path;
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login(Model model, @CookieValue(value="remember",defaultValue ="", required = false)String rememberId)throws Exception{
	 	//model.addAttribute("rememberId", rememberId);
	 	
	}
	
	//insert
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO, MultipartFile photo)throws Exception{
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getSize());//byte
		
		int result= memberService.join(memberDTO, photo);
		
		return "redirect:../";
	}
	
	
	@RequestMapping(value = "join", method=RequestMethod.GET)
	public void join()throws Exception{}
	
	@RequestMapping(value = "joinCheck", method=RequestMethod.GET)
	public void joinCheck()throws Exception{}

}
