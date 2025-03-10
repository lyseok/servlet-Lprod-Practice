package prod.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prod.dao.ProdDaoImpl;
import prod.service.IProdService;
import prod.service.ProdServiceImpl;
import prod.vo.ProdVO;

/**
 * Servlet implementation class ProdByLgu
 */
@WebServlet("/prodByLgu.do")
public class ProdByLgu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송 데이터 받기
		String guValue = request.getParameter("gu");
		
		// service객체 얻기
		IProdService service = ProdServiceImpl.getInstance(ProdDaoImpl.getInstance());
		  
		// service메서드 호출 -> 결과값 : List<ProdVO>
		List<ProdVO> list = service.selectProdByGu(guValue);
		
		// request 에 저장
		request.setAttribute("list", list);
		
		// view페이지 이동
		request
			.getRequestDispatcher("/view/prodList.jsp")
			.forward(request, response);
	}

}
