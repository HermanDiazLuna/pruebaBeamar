package net.hdiaz.pruebaBeamar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.hdiaz.pruebaBeamar.models.Cita;
import net.hdiaz.pruebaBeamar.models.Cliente;
import net.hdiaz.pruebaBeamar.services.ICitaService;

@RestController
@RequestMapping("/api")
public class CitaController {
	
	@Autowired
	private ICitaService service;
	
	@GetMapping("/buscar-citas")
	public ResponseEntity<?> buscarTodas(){
		List<Cita> listaCitas = service.buscarTodas();
		return ResponseEntity.ok().body(listaCitas);
	}
	
    @PostMapping("/guardar-cita")
	public ResponseEntity<?> guardar(@RequestBody Cita cita) {
    	Map<String, Object> response = new HashMap<String, Object>();
    	
    	Cliente cliente = new Cliente();
    	cliente.setId(cita.getCliente().getId());
    	List<Date> fechasBD = (List<Date>) service.buscarTodas().stream().map(c-> c.getFecha()).collect(Collectors.toList());
    	System.out.println("fechas ingresada --> "+cita.getFecha());
    	System.out.println("fechas BD --> "+fechasBD);
    	
    	if (fechasBD.contains(cita.getFecha())) {
    		response.put("mensaje", "No se puede reservar la cita, escoja otra fecha");
		}else {
			response.put("cita", service.guardar(cita));
		}
    	
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/eliminar-cita/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Integer idCita) {
		service.eliminar(idCita);
		String regElim = "La cita ha sido eliminada";
		return ResponseEntity.ok().body(regElim);
		
	}
	
	@GetMapping("/buscar-cita/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer idCita) {
		Cita cita = service.buscarPorId(idCita);
		return ResponseEntity.ok().body(cita);
		
	}
	
	



}
