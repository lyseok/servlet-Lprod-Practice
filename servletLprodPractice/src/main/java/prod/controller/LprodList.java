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
import prod.vo.LprodVO;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service 객체를 얻는다
		IProdService service = ProdServiceImpl.getInstance(ProdDaoImpl.getInstance());
		
		// service 메서드 호출 - 결과값 List<LprodVO>
		List<LprodVO> list =service.selectLprod();
		
		// request에 저장
		request.setAttribute("Lprod", list);
		
		// view로 이동
		request
			.getRequestDispatcher("/view/lprodlist.jsp")
			.forward(request, response);
		
	}

}
