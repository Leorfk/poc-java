package com.leorfk.natureza.repository.interfaces.jpa;

import com.leorfk.natureza.repository.entity.ViewPof;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViewPofRepository extends CrudRepository<ViewPof, Integer> {
    Optional<ViewPof> findByNomeProduto(String nomeProduto);
}
