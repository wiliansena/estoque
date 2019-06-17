package br.edu.fjn.estoque.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.edu.fjn.estoque.estoque.models.UnidadeMedida;
import br.edu.fjn.estoque.estoque.repository.UnidadeMedidaRepository;

	@Controller
	public class UnidadeMedidaController {

		// injeção de dependência da interface UnidadeMedidaRepository
		@Autowired
		private UnidadeMedidaRepository er;

		// cadastro de Unidade de medida
		@RequestMapping(value = "/cadastrarUnidadeMedida", method = RequestMethod.GET)
		public String form() {
			return "unidademedida/formUnidadeMedida";
		}

		@RequestMapping(value = "/cadastrarUnidadeMedida", method = RequestMethod.POST)
		public String form(UnidadeMedida unidademedida) {
			er.save(unidademedida);
			return "redirect:cadastrarUnidadeMedida";
		}

	}
