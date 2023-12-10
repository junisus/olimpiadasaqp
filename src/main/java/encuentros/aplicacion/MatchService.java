package encuentros.aplicacion;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import encuentros.dominio.Encuentro;

public interface MatchService {
	void save(int idEquipoA, int idEquipoB, Date fecha, Time hora, String lugar);
    Encuentro getMatch(int id);
    void update(int id, int idEquipoA, int idEquipoB, Date fecha, Time hora, String lugar);
    void delete(int id);
	List<Encuentro> getAllMatch();
}
