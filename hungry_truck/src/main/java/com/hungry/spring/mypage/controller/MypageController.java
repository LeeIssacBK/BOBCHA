package com.hungry.spring.mypage.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hungry.spring.board.service.BoardService;
import com.hungry.spring.board.vo.BoardVO;
import com.hungry.spring.dibs.service.DibsService;
import com.hungry.spring.dibs.vo.DibsVO;
import com.hungry.spring.member.service.MemberService;
import com.hungry.spring.member.vo.MemberVO;
import com.hungry.spring.review.service.ReviewService;
import com.hungry.spring.review.vo.ReviewVO;
import com.oreilly.servlet.MultipartRequest;

import pwdconv.PwdChange;

@Controller("mypageController")
@RequestMapping({ "/mypage" })
public class MypageController {
	//회원
	@Autowired
	MemberService memberService;

	//게시판
	@Autowired
	BoardService boardService;

	//밥차
	@Autowired
	ReviewService reviewService;
	
	//좋아요
	@Autowired
	DibsService dibsService;

	@RequestMapping({ "/mypage" })
	public ModelAndView mypage(HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String m_id = (String) session.getAttribute("m_id");
		if (m_id == null) {
			out.println("<script>");
			out.println("alert('세션이 만료되었습니다. 다시 로그인해주세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			ModelAndView mv = new ModelAndView("/mypage/mypage");
			MemberVO m = this.memberService.getMember(m_id);
			mv.addObject("m", m);
			//내가 제보한 밥차
			int reviewCount = this.reviewService.getMyTotalCount(m_id);
			List<ReviewVO> myReviewList = this.reviewService.getMyReviewList(m_id);
			for (ReviewVO r : myReviewList)
				r.setRv_date(r.getRv_date().substring(0, 10));
			mv.addObject("myReviewCount", Integer.valueOf(reviewCount));
			mv.addObject("myReviewList", myReviewList);
			//내가 쓴글
			List<BoardVO> myList = this.boardService.getMyBoardList(m_id);
			int mySize = this.boardService.getMyTotalCount(m_id);
			for (BoardVO b : myList)
				b.setRegdate(b.getRegdate().substring(0, 10));
			mv.addObject("myList", myList);
			mv.addObject("mySize", Integer.valueOf(mySize));
			//찜한 밥차
			List<ReviewVO> likeList = this.reviewService.getMyLikeList(m_id);//찜한 밥차만 뽑아옴
			for(ReviewVO v : likeList) {
				System.out.println(v.getRv_image_file());
			}
			mv.addObject("myLikeList",likeList);
			int myLikeCount = this.dibsService.getMyLikeCount(m_id);
			mv.addObject("myLikeCount",myLikeCount);
			return mv;
		}
		return null;
	}

	@RequestMapping({ "/userEdit" })
	public ModelAndView userEdit(HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String m_id = (String) session.getAttribute("m_id");
		if (m_id == null) {
			out.println("<script>");
			out.println("alert('세션이 만료되었습니다. 다시 로그인해주세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			MemberVO m = this.memberService.getMember(m_id);
			ModelAndView mv = new ModelAndView();
			mv.addObject("m", m);
			mv.setViewName("/mypage/userEdit");
			return mv;
		}
		return null;
	}

	@RequestMapping({ "userEdit_ok" })
	public String userEdit_ok(HttpServletResponse response, HttpServletRequest request, MemberVO m) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String saveFolder = request.getRealPath("./resources/upload");
		System.out.println(saveFolder);
		int fileSize = 5242880;
		MultipartRequest multi = null;
		multi = new MultipartRequest(request, saveFolder, fileSize, "utf-8");
		m.setM_id(multi.getParameter("m_id"));
		m.setM_pw(PwdChange.getPassWordToXEMD5String(multi.getParameter("m_pw")));
		m.setM_name(multi.getParameter("m_name"));
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
		if (upFile != null) {
			String fileName = upFile.getName();
			Calendar c = Calendar.getInstance();
			int year = c.get(1);
			int month = c.get(2) + 1;
			int date = c.get(5);
			String homedir = String.valueOf(saveFolder) + "/" + year + "-" + month + "-" + date;
			File path1 = new File(homedir);
			if (!path1.exists())
				path1.mkdir();
			Random r = new Random();
			int random = r.nextInt(10000000);
			int index = fileName.lastIndexOf(".");
			String fileExtendsion = fileName.substring(index + 1);
			String refileName = "m_profile" + year + month + date + random + "." + fileExtendsion;
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			upFile.renameTo(new File(String.valueOf(homedir) + "/" + refileName));
			m.setM_profile(fileDBName);
		} else {
			String fileDBName = "";
			m.setM_profile(fileDBName);
		}
		this.memberService.updateMember(m);
		out.println("<script>");
		out.println("alert('회원정보가 수정되었어요!');");
		out.println("</script>");
		return "redirect:/?pv=mypage";
	}

	@RequestMapping({ "/userDel" })
	public ModelAndView userDel() {
		return new ModelAndView("/mypage/userDel");
	}

	@RequestMapping({ "/userDel_ok" })
	public ModelAndView userDel_ok(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			MemberVO m) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String m_id = (String) session.getAttribute("m_id");
		MemberVO mem = this.memberService.getMember(m_id);
		if (m_id == null) {
			out.println("<script>");
			out.println("alert('세션이 만료되었습니다. 다시 로그인해주세요.');");
			out.println("location.reload();");
			out.println("</script>");
		} else if (mem.getM_pw().equals(PwdChange.getPassWordToXEMD5String(m.getM_pw()))) {
			mem.setM_del_cont(m.getM_del_cont());
			this.memberService.deleteMember(mem);
			session.invalidate();
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				byte b;
				int i;
				Cookie[] arrayOfCookie;
				for (i = (arrayOfCookie = cookies).length, b = 0; b < i;) {
					Cookie c = arrayOfCookie[b];
					if (c.getName().equals("id")) {
						c.setMaxAge(0);
						c.setPath("/");
						response.addCookie(c);
					}
					if (c.getName().equals("name")) {
						c.setMaxAge(0);
						c.setPath("/");
						response.addCookie(c);
					}
					b++;
				}
			}
			out.println("<script>");
			out.println("alert('그동안 밥차를 이용해주셔서 감사합니다. 다음에 또 만나요!');");
			out.println("location.href = document.referrer;");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 달라요.');");
			out.println("</script>");
		}
		return null;
	}

	public static String mulString(int num, String s) {
		for (int i = 0; i < num - 3; i++)
			s = String.valueOf(s) + s;
		System.out.println(s);
		return s;
	}

	public static String emailCheck(String email) {
		if (email.contains(",self")) {
			int index = email.lastIndexOf(",");
			return email.substring(0, index);
		}
		return email;
	}
}
