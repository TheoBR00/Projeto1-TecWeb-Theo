package br.edu.insper;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class atualiza
 */
@WebServlet("/atualiza")
public class atualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public atualiza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/atualiza.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		DAO dao;
		dao = new DAO();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(Integer.valueOf(request.getParameter("id")));
		pessoa.setIdade(Integer.valueOf(request.getParameter("idade")));
		pessoa.setNome(request.getParameter("nome"));
		
		dao.atualiza(pessoa);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
		dispatcher.forward(request, response);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
