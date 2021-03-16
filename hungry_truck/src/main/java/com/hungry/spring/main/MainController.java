package com.hungry.spring.main;

import com.hungry.spring.counter.service.CounterService;
import com.hungry.spring.member.service.MemberService;
import com.hungry.spring.member.vo.MemberVO;
import com.hungry.spring.review.service.ReviewService;
import com.hungry.spring.review.vo.ReviewVO;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")
public class MainController {
  @Autowired
  MemberService memberService;
  
  @Autowired
  ReviewService reviewService;
  
  @Autowired
  CounterService counterService;
  
  //홈화면
  @RequestMapping({"/"})
  public ModelAndView main(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String m_id = (String)session.getAttribute("m_id");
    ModelAndView mv = new ModelAndView("/main/main");
    if (m_id != null) {
      MemberVO m = this.memberService.getMember(m_id);
      mv.addObject("m", m);
    } else {
      out.println("<script>");
      out.println("alert('다시 로그인해주세요.')");
      out.println("history.back();");
      out.println("</script>");
    } 
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      byte b;
      int j;
      Cookie[] arrayOfCookie;
      for (j = (arrayOfCookie = cookies).length, b = 0; b < j; ) {
        Cookie c = arrayOfCookie[b];
        if (c.getName().equals("m_id"))
          session.setAttribute("m_id", c.getValue()); 
        if (c.getName().equals("m_name"))
          session.setAttribute("m_name", c.getValue()); 
        b++;
      } 
    } 
    //방문자수
    this.counterService.setTotalCount();
    int totalCount = this.counterService.getTotalCount();
    int todayCount = this.counterService.getTodayCount();
    session.setAttribute("totalCount", Integer.valueOf(totalCount));
    session.setAttribute("todayCount", Integer.valueOf(todayCount));
    
    //밥차 리스트 뽑기
    List<ReviewVO> reviewlist = this.reviewService.getReviewList();
    mv.addObject("rvlist", reviewlist);
    
    //밥차 갯수
    int bobCount = this.reviewService.getTotalCount();
    mv.addObject("bobchaCount", Integer.valueOf(bobCount));
    List<HashMap<String, Object>> rvlatlng = new ArrayList<>();
    for (int i = 0; i < reviewlist.size(); i++) {
      HashMap<String, Object> rv = new HashMap<>();
      rv.put("title", ((ReviewVO)reviewlist.get(i)).getRv_title());
      rv.put("lat", ((ReviewVO)reviewlist.get(i)).getRv_lat());
      rv.put("lng", ((ReviewVO)reviewlist.get(i)).getRv_lng());
      rv.put("rv_no", Integer.valueOf(((ReviewVO)reviewlist.get(i)).getRv_no()));
      rvlatlng.add(rv);
    } 
    mv.addObject("rvlatlng", rvlatlng);
    return mv;
  }
  
  //로그아웃
  @RequestMapping({"/logout"})
  public void logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      byte b;
      int i;
      Cookie[] arrayOfCookie;
      for (i = (arrayOfCookie = cookies).length, b = 0; b < i; ) {
        Cookie c = arrayOfCookie[b];
        if (c.getName().equals("m_id")) {
          c.setMaxAge(0);
          c.setPath("/");
          response.addCookie(c);
        } 
        if (c.getName().equals("m_name")) {
          c.setMaxAge(0);
          c.setPath("/");
          response.addCookie(c);
        } 
        b++;
      } 
    } 
    session.invalidate();
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('로그아웃 되었습니다.')");
    out.println("location.reload();");
    out.println("</script>");
  }
}
