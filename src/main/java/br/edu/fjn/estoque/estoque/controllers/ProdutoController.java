package br.edu.fjn.estoque.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fjn.estoque.estoque.models.Produto;
import br.edu.fjn.estoque.estoque.repository.ProdutoRepository;



@Controller
public class ProdutoController {
	
	//injeção de dependência da interface produtoRepository
	@Autowired
	private ProdutoRepository er;
	
	
	//cadastro de produto
	@RequestMapping(value="/cadastrarProduto", method=RequestMethod.GET)
	public String form() {
		return "produto/formProduto";
	}
	@RequestMapping(value="/cadastrarProduto", method=RequestMethod.POST)
	public String form(Produto produto) {
		er.save(produto);
		return "redirect:cadastrarProduto";
	}
	
	//listar os produtos cadastrados.
	@RequestMapping(value="/produtos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Produto> produtos = er.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}

   //Buscar um produto.
	@RequestMapping(value="produto/{codigo}", method=RequestMethod.GET )
	public ModelAndView buscarProduto(@PathVariable("codigo") long codigo) {
		Produto produto = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("produto/buscarProduto");
		mv.addObject("produto", produto);
		return mv;
		
	}
	
	//deletar um produto.
	@RequestMapping("/deletar")
	public String deletarProduto(long codigo) {
		Produto produto = er.findByCodigo(codigo);
		er.delete(produto);
		return "redirect:/produtos";
	}

	//editar um produto
	@RequestMapping("/editar")
	public ModelAndView editarProduto(long codigo){
		Produto produto = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("produto/editarProduto");
		mv.addObject("produto", produto);
		return mv;
	}
	
}
