package sakila.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gd.board.service.BoardService;
import gd.board.vo.Board;

@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private BoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		boardService = new BoardService();
		Map<String, Object> map = boardService.getBoardListByPage(currentPage, rowPerPage);
		List<Board> list = (List<Board>)(map.get("list"));
		int boardTotalCount = (Integer)(map.get("boardTotalCount"));
		request.setAttribute("list", list);
		request.setAttribute("boardTotalCount", boardTotalCount);
		// request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/boardList.jsp");
	}

}
