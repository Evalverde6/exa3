package pe.edu.upeu.exa3backendestebanvalverde.dao;

import java.util.List;
import java.util.Map;

public interface AccesoDao {
List<Map<String, Object>> getAccesos(int idusuario);
}
