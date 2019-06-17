package br.edu.fjn.estoque.estoque.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.fjn.estoque.estoque.models.UnidadeMedida;

public interface UnidadeMedidaRepository extends CrudRepository<UnidadeMedida, String> {

UnidadeMedida findByCodigo(long codigo);
}