package com.samuel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuel.domain.Produto;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Long>{

}
