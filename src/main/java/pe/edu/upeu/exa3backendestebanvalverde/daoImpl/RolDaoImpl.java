package pe.edu.upeu.exa3backendestebanvalverde.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.exa3backendestebanvalverde.dao.RolDao;
import pe.edu.upeu.exa3backendestebanvalverde.entity.Rol;
@Repository
@Component
public class RolDaoImpl implements RolDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getRoles(int idusuario) {

		return null;
	}

	@Override
	public List<GrantedAuthority> buscarRolUser(int idusuario) {
		List<GrantedAuthority> autores = new ArrayList<GrantedAuthority>();
		String SQL = "SELECT r.idrol, r.nombre FROM usuarios u "
				+ "INNER JOIN usuarios_roles ur ON u.idusuario=ur.idusuario "
				+ "INNER JOIN roles r ON r.idrol=ur.idrol " 
				+ "WHERE u.idusuario = ?";
		List<Rol> roles = jdbcTemplate.query(SQL, new Object[] { idusuario }, new BeanPropertyRowMapper<Rol>(Rol.class));
		for (int i = 0; i < roles.size(); i++) {
			autores.add(new SimpleGrantedAuthority(roles.get(i).getNombre()));
		}
		return autores;
	}

}
