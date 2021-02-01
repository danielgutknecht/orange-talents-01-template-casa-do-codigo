package br.com.zup.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zup.casadocodigo.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
