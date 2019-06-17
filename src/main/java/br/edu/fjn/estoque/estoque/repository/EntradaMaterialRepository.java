package br.edu.fjn.estoque.estoque.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.fjn.estoque.estoque.models.EntradaMaterial;
import br.edu.fjn.estoque.estoque.models.Produto;

public interface EntradaMaterialRepository extends CrudRepository<EntradaMaterial, String> {
	Iterable<EntradaMaterial> findByProduto(Produto produto);
}
