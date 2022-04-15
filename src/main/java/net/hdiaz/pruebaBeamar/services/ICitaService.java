package net.hdiaz.pruebaBeamar.services;

import java.util.List;
import net.hdiaz.pruebaBeamar.models.Cita;

public interface ICitaService {
	List<Cita> buscarTodas();
	Cita guardar(Cita cita);
	void eliminar(Integer idCita);
	Cita buscarPorId(Integer idCita);
	
	
}
