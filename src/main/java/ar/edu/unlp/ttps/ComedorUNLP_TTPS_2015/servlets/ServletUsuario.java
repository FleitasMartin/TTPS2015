package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet(urlPatterns = {"/user", "/user/home", "/user/tickets", "/user/login", "/user/comentarios", 
		"/user/saldo", "/user/mapa"  })
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		System.out.println(uri[0]+" "+uri[1]+" "+uri[2]);
		System.out.println(uri[uri.length-1]);
		String contentPage="";
		switch (uri[uri.length-1]) {
		case "home":
			contentPage = "home";
			break;
		case "tickets":
			contentPage = "userTicket";
			break;
		case "login":
			contentPage = "userLogin";
			break;
		case "comentarios":
			contentPage = "userComentarios";
			break;
		case "saldo":
			contentPage = "saldo";
			break;
		case "mapa":
			contentPage = "mapa";
			break;
		default:
			break;
		}
		request.setAttribute("contentPage", contentPage);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/indexUsuario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
