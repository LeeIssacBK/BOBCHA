package com.hungry.spring.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hungry.spring.board.service.BoardService;
import com.hungry.spring.board.vo.BoardVO;

@Controller("boardController")
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//게시판 목록
	@RequestMapping("/board")
	public ModelAndView board(HttpServletRequest request, BoardVO b) {
		String b_writer = request.getParameter("b_writer");
		int page = 1; //현재 쪽번호
		int limit = 10;//한페이지에 보여지는 목록 개수
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));//쪽 번호를 받아서 정수숫자로 변경
		}
		b.setStartrow((page-1)*10+1);//시작행 번호
		b.setEndrow(b.getStartrow()+limit-1);//끝행번호
		int totalCount = 0;
		List<BoardVO> blist = new ArrayList<>();
		totalCount = this.boardService.getTotalCount();//총게시물 수
		blist = this.boardService.getBoardList(b);//게시물 목록
		if(b_writer!=null) {
			totalCount = this.boardService.getMyTotalCount(b_writer);
			blist = this.boardService.getMyBoardList(b_writer);//게시물 목록
		}
		for(BoardVO v : blist) {
			v.setRegdate(v.getRegdate().substring(0,10));
		}
		//페이징 연산
		int maxpage = (int)((double)totalCount/limit+0.95);//총페이지 수
		int startpage = (((int)((double)page/10+0.9))-1)*10+1;//현재페이지에 보여질 시작페이지
		int endpage = maxpage;
		
		if(endpage > startpage+10-1) { //마지막 페이지가 시작페이지+10-1 보다 크다면
			endpage = startpage+10-1; //마지막페이지에 시작페이지+10-1 해줌.
		}
		ModelAndView m = new ModelAndView();
		m.addObject("totalCount",totalCount);//totalCount키이름에 총 레코드 개수 저장함.
		m.addObject("list",blist);//list키이름에 blist목록을 저장함.
		//페이지값
		m.addObject("startpage",startpage);//시작페이지값 저장
		m.addObject("endpage",endpage);//끝 페이지값 저장
		m.addObject("maxpage",maxpage);//총 페이지값 저장
		m.addObject("page",page);//page키이름에 현재 쪽번호 저장
		m.setViewName("/board/board");
		return m;
	}
	
	//게시글 내용보기
	@RequestMapping("/boardView")
	public ModelAndView boardView(int b_no, int page, Model m) {//Get방식으로 파라미터값에 전달된 b_no + page값
		BoardVO b = this.boardService.getCont(b_no);//파라미터값으로 받은 번호값으로 해당 게시글 불러옴.
		m.addAttribute("b",b);//b객체 세션에 저장
		m.addAttribute("page",page);//page정보 저장
		return new ModelAndView("/board/boardView");
	}
	
	//게시물 작성
	@RequestMapping("/boardWrite")
	public ModelAndView boardWrite() {
		return new ModelAndView("/board/boardWrite");
	}
	
	//게시물 저장
	@RequestMapping("/boardWrite_ok")
	public String boardWrite_ok(BoardVO b, RedirectAttributes rttr) throws Exception {
		this.boardService.insertBoard(b);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/?pv=board";
	}

	
	//게시글 삭제 
	@RequestMapping("/boardDel_ok")
	public String boardDel_ok(int b_no, int page, RedirectAttributes rttr) {
		this.boardService.delBoard(b_no);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/?pv=board";
	}
	
	//게시글 수정 페이지
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(int b_no, int page) {
		BoardVO b = this.boardService.getCont(b_no);
		ModelAndView m = new ModelAndView("/board/boardEdit");
		m.addObject("b",b);
		m.addObject("page",page);
		return m;
	}
	
	//게시글 수정내용 저장
	@RequestMapping("/boardEdit_ok")
	public String boardEdit_ok(BoardVO b, int page, RedirectAttributes rttr) {
		this.boardService.editBoard(b);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/?pv=board&page="+page;
	}

}
