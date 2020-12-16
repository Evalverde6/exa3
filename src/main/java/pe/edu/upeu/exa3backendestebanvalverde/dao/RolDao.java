package pe.edu.upeu.exa3backendestebanvalverde.dao;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

public interface RolDao {
List<Map<String, Object>> getRoles(int idusuario);
List<GrantedAuthority> buscarRolUser(int idusuario);
}
