package pe.edu.upeu.exa3backendestebanvalverde.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pe.edu.upeu.exa3backendestebanvalverde.dao.AccesoDao;
import pe.edu.upeu.exa3backendestebanvalverde.dao.RolDao;
import pe.edu.upeu.exa3backendestebanvalverde.dao.UsuarioDao;
import pe.edu.upeu.exa3backendestebanvalverde.entity.Usuario;


@Component
public class InfoAdicionalToken implements TokenEnhancer{
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private RolDao rolDao;
	@Autowired
	private AccesoDao accesoDao;

	Gson g = new Gson();
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario user = usuarioDao.read(authentication.getName());
		List<Map<String,Object>> accesos = new ArrayList<>();
		//List<Map<String,Object>> roles = new ArrayList<>();
		//roles = rolDao.getRoles(user.getIdusuario());
		accesos = accesoDao.getAccesos(user.getIdusuario());
		Map<String, Object> datos= new HashMap<>();
		datos.put("iduser", user.getIdusuario());
		datos.put("nombre", user.getUsername());
		//datos.put("accesos", roles);
		datos.put("accesos", accesos);
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(datos);

		return accessToken;
	}

}
