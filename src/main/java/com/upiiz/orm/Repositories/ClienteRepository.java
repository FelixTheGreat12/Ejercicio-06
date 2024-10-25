package com.upiiz.orm.Repositories;

import com.upiiz.orm.Models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Aternativa a JpaRepositoy existe CrudRepository

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    //Puedo generar metodos personalizados
    //@Query
}
