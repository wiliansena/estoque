package br.edu.fjn.estoque.estoque.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.fjn.estoque.estoque.models.Produto;


public interface ProdutoRepository extends CrudRepository<Produto, String> {

Produto findByCodigo(long codigo);
}
