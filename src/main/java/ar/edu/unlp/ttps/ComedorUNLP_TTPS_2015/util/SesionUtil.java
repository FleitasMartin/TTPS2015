package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Administrador;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Persona;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Responsable;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Usuario;

/** 
 * @author Martin
 * 
 * Esta clase tiene la finalidad de manejar todo lo referido a la sesion del usuario.
 */
public class SesionUtil {
	
	private static HttpSession sesion;

	
	/**
	 * Este método debería ser utilizado cada vez que sea necesario validar que exista una sesion activa.
	 * 
	 * @return true si existe una sesion activa, false en caso contrario.
	 */
	public static boolean checkLogin(){
		if ( getSesion()==null || getSesion().getAttribute("idUsuario")==null ){
			return false;
		}
		return true;
	}
	
	
	/**
	 * Este método es invocado cuando un usuario se loguea exitosamente.
	 * 
	 * @param usuario, es el usuario traído de la bd, de él obtenemos el id y el nombre,
	 * 	además en base a su clase se define el tipo de usuario.
	 */
	public static void crearSesion(Persona usuario) {
		HttpSession sesion = getSesion(true);
		sesion.setAttribute("idUsuario", usuario.getId());
		sesion.setAttribute("nombre", usuario.getNombre());
		if (usuario instanceof Usuario) {
			sesion.setAttribute("tipo", 3);
		}
		if (usuario instanceof Administrador) {
			sesion.setAttribute("tipo", 1);
		}
		if (usuario instanceof Responsable) {
			sesion.setAttribute("tipo", 2);
		}
		setSesion(sesion);
	}	
	
	/**
	 * Este método es invocado en el cierre de sesion.
	 */
	public static void destruirSesion(){
		if (checkLogin()){
			getSesion().invalidate();
			setSesion(null);
		}
	}

	private static HttpSession getSesion(boolean crear){
		ServletRequestAttributes atributos = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession sesion = atributos.getRequest().getSession(crear);
		return sesion;
	}

	public static HttpSession getSesion() {
		return sesion;
	}

	private static void setSesion(HttpSession ses) {
		sesion = ses;
	}
	
}
