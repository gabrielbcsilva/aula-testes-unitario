package io.gabriel.github.servicos;

import java.util.Date;

import io.gabriel.github.entidades.Filme;
import io.gabriel.github.entidades.Locacao;
import io.gabriel.github.entidades.Usuario;
import io.gabriel.github.utils.DataUtils;


public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega =DataUtils.adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	public static void main(String[] args) {
		//cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Joao");
		Filme filme = new Filme("Filme 1", 2, 1.5);
		//acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
		//verificacao
		System.out.println(locacao.getValor());
		System.out.println(locacao.getDataLocacao());
		System.out.println(locacao.getDataRetorno());

		//Principios para testes unitários 
		/*
		 * Fast - Um teste unitário deve ser executado rápido
		 * independent/isolated - Um teste não deve depender de outro, pode ser executado em qualquer ordem e isoladamente
		 * repeatable - pode ser executado quantas vezes quiser
		 * Self-verifying - Um teste deve saber quando sua execução foi correta e quando falhou
		 * Timely - Oportuno, criado no momento correto
		 */
	}
}