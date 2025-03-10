package prod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prod.dao.ProdDaoImpl;
import prod.service.IProdService;
import prod.service.ProdServiceImpl;
import prod.vo.ProdVO;

import java.io.IOException;

/**
 * Servlet implementation class ProdById
 */
@WebServlet("/prodById.do")
public class ProdById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idValue = request.getParameter("id");
		
		IProdService service = ProdServiceImpl.getInstance(ProdDaoImpl.getInstance());
		
		ProdVO pvo = service.selectProdById(idValue);
		
		request.setAttribute("pvo", pvo);
		
		request
			.getRequestDispatcher("/view/prod.jsp")
			.forward(request, response);
		
	}

}
