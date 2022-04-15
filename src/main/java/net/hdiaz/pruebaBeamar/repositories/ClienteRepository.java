package net.hdiaz.pruebaBeamar.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import net.hdiaz.pruebaBeamar.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
