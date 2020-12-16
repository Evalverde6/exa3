package pe.edu.upeu.exa3backendestebanvalverde.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.exa3backendestebanvalverde.dao.UsuarioDao;
import pe.edu.upeu.exa3backendestebanvalverde.entity.Usuario;
@Repository
@Component
public class UsuarioDaoImpl implements UsuarioDao {
@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public Usuario read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario read(String nomuser) {
		String SQL = "select * from usuarios where username=?";
		Usuario usuario = jdbcTemplate.queryForObject(SQL, new Object[] {nomuser}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		return usuario;
	}

	@Override
	public Usuario validarUsuario(String nomuser) {
		String SQL = "select * from usuarios where username=?";
		Usuario usuario = jdbcTemplate.queryForObject(SQL, new Object[] {nomuser}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		return usuario;
	}

}
