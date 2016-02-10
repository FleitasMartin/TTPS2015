package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** "/admin/altaSede", "/admin/altaUsuario"
 * Servlet implementation class ServletAdmin
 */
@WebServlet(urlPatterns = {"/admin", "/admin/adminUsers", "/admin/home", "/admin/buzonVirtual",
		"/admin/estadisticasMenues", "/admin/cartillaSemanal","/admin/sedes","/admin/altaCartilla"})
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdmin() {
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
		case "adminUsers":
			contentPage = "adminUsers";
			break;
		case "buzonVirtual":
			contentPage = "buzonVirtual";
			break;
		case "administracionComponentes":
			contentPage = "administracionComponentes";
			break;
		case "adminMenues":
			contentPage = "adminMenues";
			break;
		case "altaComponente":
			contentPage = "altaComponente";
			break;
		case "altaMenu":
			contentPage = "altaMenu";
			break;	
		case "estadisticasMenues":
			contentPage = "estadisticasMenues";
			break;
		case "cartillaSemanal":
			contentPage = "cartillaSemanal";
			break;
		case "sedes":
			contentPage = "adminSedes";
			break;
		case "altaCartilla":
			contentPage = "altaCartilla";
			break;
		case "altaSede":
			contentPage = "altaSede";
			break;
		case "altaUsuario":
			contentPage = "altaUsuario";
			break;
		default:
			break;
		}
		request.setAttribute("contentPage", contentPage);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/indexAdmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
