package com.hungry.spring.review.controller;

import com.hungry.spring.review.service.ReviewService;
import com.hungry.spring.review.vo.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/review"})
public class ReviewController {
  @Autowired
  private ReviewService reviewService;
  
  @RequestMapping({"/review_ok"})
  public String review_ok(ReviewVO vo, HttpServletRequest request) throws Exception {
    String saveFolder = request.getRealPath("./resources/upload");
    System.out.println(saveFolder);
    int fileSize = 10485760;
    MultipartRequest multi = null;
    multi = new MultipartRequest(request, saveFolder, fileSize, "utf-8");
    vo.setRv_title(multi.getParameter("rv_title"));
    vo.setRv_writer(multi.getParameter("rv_writer"));
    vo.setRv_content(multi.getParameter("rv_content"));
    vo.setRv_price(multi.getParameter("rv_price"));
    String s = "";
    byte b;
    int i;
    String[] arrayOfString;
    for (i = (arrayOfString = multi.getParameterValues("rv_days")).length, b = 0; b < i; ) {
      String str = arrayOfString[b];
      s = String.valueOf(s) + str;
      b++;
    } 
    vo.setRv_days(s);
    vo.setRv_times(multi.getParameter("rv_times"));
    vo.setRv_rating(Integer.parseInt(multi.getParameter("rv_rating")));
    vo.setRv_lat(multi.getParameter("rv_lat"));
    vo.setRv_lng(multi.getParameter("rv_lng"));
    File upFile = multi.getFile("rv_image_file");
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
      String refileName = "review_img" + year + month + date + random + "." + fileExtendsion;
      String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
      upFile.renameTo(new File(String.valueOf(homedir) + "/" + refileName));
      vo.setRv_image_file(fileDBName);
    } else {
      String fileDBName = "";
      vo.setRv_image_file(fileDBName);
    } 
    this.reviewService.insertReview(vo);
    return "redirect:/";
  }
  
  @RequestMapping({"/review_del"})
  public String review_del(int rv_no, HttpSession session, HttpServletResponse response) throws Exception {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String m_id = (String)session.getAttribute("m_id");
    if (m_id == null) {
      out.println("<script>");
      out.println("alert('')");
      out.println("location.reload();");
      out.println("</script>");
    } else {
      this.reviewService.deleteReview(rv_no);
    } 
    return "redirect:/";
  }
  
  @RequestMapping({"/review_edit"})
  public String review_edit(ReviewVO vo, HttpServletRequest request) throws Exception {
    String saveFolder = request.getRealPath("./resources/upload");
    System.out.println(saveFolder);
    int fileSize = 10485760;
    MultipartRequest multi = null;
    multi = new MultipartRequest(request, saveFolder, fileSize, "utf-8");
    int rv_no = Integer.parseInt(multi.getParameter("rv_no"));
    File upFile = multi.getFile("rv_image_file");
    ReviewVO rvo = this.reviewService.getReview(rv_no);
    if (upFile != null) {
      String fileName = upFile.getName();
      File delFile = new File(String.valueOf(saveFolder) + rvo.getRv_image_file());
      if (delFile.exists())
        delFile.delete(); 
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
      String refileName = "review_img" + year + month + date + random + "." + fileExtendsion;
      String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
      upFile.renameTo(new File(String.valueOf(homedir) + "/" + refileName));
      vo.setRv_image_file(fileDBName);
    } else {
      String fileDBName = "";
      if (rvo.getRv_image_file() != null) {
        vo.setRv_image_file(rvo.getRv_image_file());
      } else {
        vo.setRv_image_file(fileDBName);
      } 
    } 
    vo.setRv_no(rv_no);
    vo.setRv_title(multi.getParameter("rv_title"));
    vo.setRv_price(multi.getParameter("rv_price"));
    String s = "";
    byte b;
    int i;
    String[] arrayOfString;
    for (i = (arrayOfString = multi.getParameterValues("rv_days")).length, b = 0; b < i; ) {
      String str = arrayOfString[b];
      s = String.valueOf(s) + str;
      b++;
    } 
    vo.setRv_days(s);
    vo.setRv_times(multi.getParameter("rv_times"));
    this.reviewService.editReview(vo);
    return "redirect:/";
  }
}
