package net.hdiaz.pruebaBeamar.services;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.hdiaz.pruebaBeamar.models.Cita;
import net.hdiaz.pruebaBeamar.repositories.CitaRepository;

@Service
public class CitaServiceImpl implements ICitaService {
	
	@Autowired
	private CitaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cita> buscarTodas() {
		List<Cita> listaCitas = repository.findAll();
		return listaCitas;
	}

	@Override
	@Transactional
	public Cita guardar(Cita cita) {
		return repository.save(cita);
	}


	@Override
	@Transactional
	public void eliminar(Integer idCita) {
		repository.deleteById(idCita);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cita buscarPorId(Integer idCita) {
		Cita cita = null;
		Optional<Cita> op = repository.findById(idCita);
		
		if (op.isPresent()) {
			return cita = op.get();
		}
		
		return cita;
		
	}


}
