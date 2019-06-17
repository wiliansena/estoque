package br.edu.fjn.estoque.estoque.repository;

import br.edu.fjn.estoque.estoque.models.SaidaMaterial;

import org.springframework.data.repository.CrudRepository;

import br.edu.fjn.estoque.estoque.models.Produto;

public interface SaidaMaterialRepository extends CrudRepository<SaidaMaterial, String> {
	Iterable<SaidaMaterial> findByProduto(Produto produto);
}
