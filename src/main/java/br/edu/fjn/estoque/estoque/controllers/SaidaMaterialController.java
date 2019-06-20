package br.edu.fjn.estoque.estoque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fjn.estoque.estoque.models.Produto;
import br.edu.fjn.estoque.estoque.models.SaidaMaterial;
import br.edu.fjn.estoque.estoque.repository.ProdutoRepository;
import br.edu.fjn.estoque.estoque.repository.SaidaMaterialRepository;

@Controller
public class SaidaMaterialController {
	
	
	//injeção de dependência da interface produtoRepository
		@Autowired
		private ProdutoRepository er;
		
	
	//injeção de dependência da interface SaidaMaterialRepository
	@Autowired
	private SaidaMaterialRepository smr;
	
	@RequestMapping(value = "/cadastrarSaidaMaterial", method = RequestMethod.GET)
	public String form() {
		return "saidamaterial/SaidaMaterial";
	}

	@RequestMapping(value = "/cadastrarSaidaMaterial", method = RequestMethod.POST)
	public String form(@Valid SaidaMaterial saidamaterial) {
		smr.save(saidamaterial);
		return "redirect:produtosaida/{codigo}";
	}

	
	//listar os produtos cadastrados.
		@RequestMapping(value="/produtosaida")
		public ModelAndView listaProdutosSaida() {
			ModelAndView mv = new ModelAndView("index");
			Iterable<Produto> produtos = er.findAll();
			mv.addObject("produtos", produtos);
			return mv;
		}
	
	 //Buscar um produto e cadastrar uma saida no estoque
		@RequestMapping(value="produtosaida/{codigo}", method=RequestMethod.GET )
		public ModelAndView buscarProdutoSaida(@PathVariable("codigo") long codigo) {
			Produto produto = er.findByCodigo(codigo);
			ModelAndView mv = new ModelAndView("produto/produtosaida");
			mv.addObject("produto", produto);
			
			Iterable<SaidaMaterial> saidamaterial = smr.findByProduto(produto);
			mv.addObject("saidamaterial", saidamaterial);
			return mv;
		}
		
		//listar as saidas do produto buscado
	@RequestMapping(value="produtosaida/{codigo}", method=RequestMethod.POST )
	public String buscarProdutoSaidaPost(@PathVariable("codigo") long codigo, SaidaMaterial saidamaterial) {
		Produto produto = er.findByCodigo(codigo);
		saidamaterial.setProduto(produto);
		smr.save(saidamaterial);
		return "redirect:/{codigo}";
		
	}
}
