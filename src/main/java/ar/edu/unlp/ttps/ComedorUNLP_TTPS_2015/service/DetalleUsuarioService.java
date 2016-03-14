package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.PersonaDAO;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.Persona;
import ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model.RolUsuario;

/**
 * 
 * @author Martin
 *
 *         Esta clase es nuestro servicio de usuario personalizado. Implementa
 *         la interfaz UserDetailsService. Su finalidad es obtener, en base a un
 *         dni entrante, el objeto Persona correspondiente. Utilizamos los
 *         atributos dni y contrasena como parámetros de creación del objeto
 *         User, propio de Spring Security, además de una lista de
 *         GrantedAuthority, cuya instancia es seteada con el String que
 *         corresponde al objeto RolUsuario correspondiente a la Persona
 *         obtenida.
 *
 */

@Service("userDetailsService")
public class DetalleUsuarioService implements UserDetailsService {

	@Autowired
	private PersonaDAO personaDAO;

	/**
	 * Este es el método sobre escrito de la interfaz UserDetailsService.
	 * 
	 * @param dni
	 *            | Es el dni que llega del login.
	 */
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String dni)
			throws UsernameNotFoundException {

		Persona persona = personaDAO.findByDNI(dni);
		List<GrantedAuthority> authorities = construirPermiso(persona.getRol());

		return buildUserForAuthentication(persona, authorities);

	}

	/**
	 * Este metodo se encarga de convertir al objeto Persona y a la List de
	 * GrantedAuthority en un objeto User, propio de Spring Security. Es
	 * utilizado internamente.
	 * 
	 * @param persona
	 *            | Es el objeto Persona involucrado en el login.
	 * @param authorities
	 *            | Es la lista de GrantedAuthority correspondiente al parametro
	 *            persona.
	 * @return org.springframework.security.core.userdetails.User
	 */
	private User buildUserForAuthentication(Persona persona,
			List<GrantedAuthority> authorities) {
		return new User(persona.getDni(), persona.getContrasena(), true, true,
				true, true, authorities);
	}

	/**
	 * Este metodo construye una List de GrantedAuthority en base a un
	 * RolUsuario correspondiente al objeto Persona. Es utilizado internamente.
	 * En nuestro caso un usuario siempre tendrá un permiso, sin embargo es
	 * necesario enviar al constructor una implementacion de Collection, por eso
	 * se inserta un GrantedAuthority, creado a partir del nombre de rolUsuario,
	 * en una List.
	 * 
	 * @param rolUsuario
	 *            | Es el rol del usuario logueado.
	 * @return una lista de permisos.
	 */
	private List<GrantedAuthority> construirPermiso(RolUsuario rolUsuario) {
		List<GrantedAuthority> rolesPermitidos = new ArrayList<GrantedAuthority>();
		rolesPermitidos.add(new SimpleGrantedAuthority(rolUsuario.getRol()));
		return rolesPermitidos;
	}
}
