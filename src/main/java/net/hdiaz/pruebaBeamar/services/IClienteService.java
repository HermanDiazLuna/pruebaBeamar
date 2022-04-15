package net.hdiaz.pruebaBeamar.services;

import java.util.List;
import net.hdiaz.pruebaBeamar.models.Cliente;

public interface IClienteService {
	
	List<Cliente> buscarTodos();
	Cliente guardar(Cliente cliente);
	Cliente actualizar(Cliente cliente);
	void eliminar(Integer idCliente);
	Cliente buscarPorId(Integer idCliente);
	
}
