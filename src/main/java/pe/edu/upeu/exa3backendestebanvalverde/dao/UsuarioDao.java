package pe.edu.upeu.exa3backendestebanvalverde.dao;

import pe.edu.upeu.exa3backendestebanvalverde.entity.Usuario;

public interface UsuarioDao {
	Usuario read(int id);
	Usuario read(String nomuser);
	Usuario validarUsuario(String nomuser);
}
