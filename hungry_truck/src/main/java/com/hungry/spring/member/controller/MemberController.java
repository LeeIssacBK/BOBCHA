package com.hungry.spring.member.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hungry.spring.member.service.MemberService;
import com.hungry.spring.member.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;

import pwdconv.PwdChange;

@Controller("memberController")
@RequestMapping("/member")
public class MemberController {
	
	@Autowired// DI주입
	MemberService memberService;

	@Autowired
	private JavaMailSender mailSender;
	
	//약관동의
	@RequestMapping("/userJoin")
	public ModelAndView userJoin() {
		return new ModelAndView("/member/userJoin");
	}
	
	//회원가입
	@RequestMapping("/userJoin2")
	public ModelAndView userJoin2() {
		return new ModelAndView("/member/userJoin2");
	}
	
	//회원가입 아이디 중복검사
	@ResponseBody
	@RequestMapping(value = "/id_check", produces="text/plane")
	public String id_check(@RequestBody String paramData) throws Exception{
		//클라이언트가 보낸 id값
		String id = paramData.trim();
		MemberVO db_id = this.memberService.id_check(id);
		if(db_id != null) {
			//결과값이 있는경우
			return "-1";
		}else {
			//결과값이 없는경우
			return "0";
		}
	}
	
	//회원가입 정보저장
	@PostMapping("join_ok")
	public void join_ok(HttpServletResponse response, HttpServletRequest request, 
			MemberVO m) throws Exception{
		//request는 바이너리파일로 받아서 파라미터로 받을수 없다.
		String saveFolder = request.getRealPath("./resources/upload");
		System.out.println(saveFolder);
		
		int fileSize = 5*1024*1024; //파일업로드 최대 크기
		MultipartRequest multi = null; //cos.jar로 받을 변수
		
		multi = new MultipartRequest(request, saveFolder,fileSize, "utf-8");
		
		m.setM_id(multi.getParameter("m_id"));
		m.setM_pw(PwdChange.getPassWordToXEMD5String(multi.getParameter("m_pw")));
		m.setM_name(multi.getParameter("m_name"));
		m.setM_gender(multi.getParameter("m_gender"));
		m.setM_bir_yy(Integer.parseInt(multi.getParameter("m_bir_yy")));
		m.setM_bir_mm(Integer.parseInt(multi.getParameter("m_bir_mm")));
		m.setM_bir_dd(Integer.parseInt(multi.getParameter("m_bir_dd")));
		m.setM_pho_1(multi.getParameter("m_pho_1"));
		m.setM_pho_2(multi.getParameter("m_pho_2"));
		m.setM_pho_3(multi.getParameter("m_pho_3"));
		m.setM_post(multi.getParameter("m_post"));
		m.setM_addr_1(multi.getParameter("m_addr_1"));
		m.setM_addr_2(multi.getParameter("m_addr_2"));
		m.setM_addr_3(multi.getParameter("m_addr_3"));
		m.setM_email_id(multi.getParameter("m_email_id"));
		m.setM_email_domain(emailCheck(multi.getParameter("m_email_domain")));
		
		File upFile = multi.getFile("m_profile");
		
		if(upFile!=null) {
			String fileName = upFile.getName();
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			int date = c.get(Calendar.DATE);
			
			String homedir = saveFolder+"/"+year+"-"+month+"-"+date;
			File path1 = new File(homedir);
			
			if(!(path1.exists())) {
				path1.mkdir();
			}
			Random r = new Random();
			int random = r.nextInt(10000000);
			int index = fileName.lastIndexOf(".");
			String fileExtendsion = fileName.substring(index+1);
			String refileName = "m_profile"+year+month+date+random+"."+fileExtendsion;
			String fileDBName = "/"+year+"-"+month+"-"+date+"/"+refileName;
			upFile.renameTo(new File(homedir+"/"+refileName));
			m.setM_profile(fileDBName);
		}else {
			String fileDBName = "";
			m.setM_profile(fileDBName);
		}
		System.out.println(m.getM_email_domain());
		response.setContentType("text/html;charset=utf-8");
		this.memberService.insertMember(m);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+m.getM_name()+"님 회원가입을 환영합니다!');");
		out.println("history.back();");
		out.println("</script>");
	}
	
	//로그인화면
	@RequestMapping("/userLogin")
	public ModelAndView userLogin() {
		return new ModelAndView("/member/userLogin");
	}
	
	//로그인처리
	@RequestMapping("login_ok")
	public String login_ok(String m_id, String m_pw, String remid, 
			HttpServletResponse response, HttpServletRequest request,HttpSession session) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		MemberVO m = this.memberService.login_check(m_id);// m_act 컬럼이 1인 회원만 로그인 , 탈퇴시 2로 전환 
		if(m == null) {
			out.println("<script>");
			out.println("alert('가입되지않은 회원이예요.');");
			out.println("history.back();");	
			out.println("</script>");
		}else {
			if(m.getM_pw().equals(PwdChange.getPassWordToXEMD5String(m_pw))) {
				session.setAttribute("m_id", m_id);
				session.setAttribute("m_name", m.getM_name());
				this.memberService.updateLoginDate(m_id);
				MemberVO m2 = this.memberService.getMember(m_id);
				session.setAttribute("m", m2);
				//로그인 유지를 선택할 경우
				//쿠키를 저장시켜준다.
				if(request.getParameter("remid") != null) {
					Cookie c = new Cookie("m_id",m_id);
					c.setMaxAge(60 * 60 * 24 * 14);
					c.setPath("/");
					Cookie c2 = new Cookie("m_name",m.getM_name());
					c2.setMaxAge(60 * 60 * 24 * 14);
					c2.setPath("/");
					response.addCookie(c);
					response.addCookie(c2);
				}
				return "redirect:/";
			}else {
				out.println("<script>");
				out.println("alert('비밀번호가 달라요.');");
				out.println("history.back();");	
				out.println("</script>");
			}
		}
		return null;
	}
	
	//아이디 찾기
	@RequestMapping("/findId")
	public ModelAndView findId() {
		return new ModelAndView("/member/findId");
	}
	
	//아이디 이메일로 전송해주기
	@RequestMapping("/findId_ok")
	public ModelAndView findId_ok(MemberVO mem, HttpServletResponse response)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//같은 사용자가 여러번 회원가입할 수 있으므로 list로 받아서 처리함.
		List<MemberVO> mlist = this.memberService.findId(mem);
		//selectList는 반환값이 없으면 빈 List<E>객체를 반환하고 selectOne은 null을 반환한다. 
		if(mlist.isEmpty()) {
			out.println("<script>");
			out.println("alert('조회되는 정보가 없습니다.');");
			out.println("history.back();");	
			out.println("</script>");
		}else {
			for(MemberVO m : mlist) {
			String setFrom = "issac.lee.div@gmail.com";
			String toMail = m.getM_email_id()+"@"+m.getM_email_domain();
			String title = "[BOBCHA]"+m.getM_name()+"님의 아이디 찾기 결과입니다.";
			String content = m.getM_name()+" 님의 아이디는 ' "+m.getM_id().substring(0,3)+(mulString(m.getM_id().length(),"*"))+" ' 입니다.\n";
			
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setFrom); // 보내는사람 생략시 작동안함
				messageHelper.setTo(toMail); // 받는사람 이메일
				messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용
				mailSender.send(message);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			out.println("<script>");
			out.println("alert('등록된 이메일로 아이디가 전송되었습니다.');");
			out.println("history.back();");	
			out.println("</script>");
			}
		}
		return null;
	}
	
	@RequestMapping("/findPw")
	public ModelAndView findPw() {
		return new ModelAndView("/member/findPw");
	}
	
	//임시 비밀번호를 등록된 이메일로 보내주고 임시비밀번호로 DB값 바꾸기
	@RequestMapping("findPw_ok")
	public ModelAndView findPw_ok(HttpServletRequest request, 
			HttpServletResponse response, MemberVO mem) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//임시비밀번호 생성
		String password = PwdChange.getRandomPassword(8);
		//임시비밀번호를 DB에 넣어 바꿔줌
		mem.setM_pw(PwdChange.getPassWordToXEMD5String(password));
		MemberVO m = this.memberService.findPw(mem);
		if(m == null) {
			out.println("<script>");
			out.println("alert('조회되는 정보가 없습니다.');");
			out.println("history.back();");	
			out.println("</script>");
		}else {
			String setFrom = "issac.lee.div@gmail.com";
			String toMail = m.getM_email_id()+"@"+m.getM_email_domain();
			String title = "[BOBCHA]"+m.getM_name()+"님에게 전송된 임시 비밀번호 입니다.";
			String content = m.getM_name()+" 님의 비밀번호는 ' "+password+" ' 입니다.\n"
					+ "로그인 후에는 반드시 비밀번호 변경을 해주세요.";	
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				
				messageHelper.setFrom(setFrom); // 보내는사람 생략시 작동안함
				messageHelper.setTo(toMail); // 받는사람 이메일
				messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용
				mailSender.send(message);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			out.println("<script>");
			out.println("alert('등록된 이메일로 임시비밀번호가 발급되었습니다.');");
			out.println("history.back();");	
			out.println("</script>");
		}
		return null;
	}
	
	
	
	//문자열 곱하기
	public static String mulString(int num, String s) {
		for(int i=0; i<num-3; i++) {
			s += s;
		}
		System.out.println(s);
		return s;
	}
	
	//직접입력으로 ,self가 입력된경우. ,self를 제거하고 DB에 저장
	public static String emailCheck(String email) {
		if(email.contains(",self")){
			int index = email.lastIndexOf(",");
			return email.substring(0,index);
		}
		return email;
	}

	
}
