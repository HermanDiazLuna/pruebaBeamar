package net.hdiaz.pruebaBeamar.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.hdiaz.pruebaBeamar.models.Cliente;
import net.hdiaz.pruebaBeamar.services.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping("/buscar-clientes")
	public ResponseEntity<?> buscarTodos(){
		List<Cliente> listaCliente = service.buscarTodos();
		return ResponseEntity.ok().body(listaCliente);
	}
	
    @PostMapping("/guardar-cliente")
	public ResponseEntity<?> guardar(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cliente));
	}
	
	@DeleteMapping("/eliminar-cliente/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Integer idCliente) {
		service.eliminar(idCliente);
		String regElim = "El cliente ha sido eliminado";
		return ResponseEntity.ok().body(regElim);
		
	}
	@GetMapping("/buscar-cliente/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer idCliente) {
		Cliente cliente = service.buscarPorId(idCliente);
		return ResponseEntity.ok().body(cliente);
		
	}
	
	@PutMapping("/actualizar-cliente")
	public ResponseEntity<?> actualizar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(service.actualizar(cliente));
	}

	
}
