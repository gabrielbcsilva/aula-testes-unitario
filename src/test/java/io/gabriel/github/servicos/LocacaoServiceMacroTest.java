package io.gabriel.github.servicos;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import io.gabriel.github.entidades.Filme;
import io.gabriel.github.entidades.Locacao;
import io.gabriel.github.entidades.Usuario;
import io.gabriel.github.utils.DataUtils;

public class LocacaoServiceMacroTest {
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();
    @Test
    public void testeLocacao(){
        //cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Joao");
		Filme filme = new Filme("Filme 1", 2, 4.0);
		//acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
	
		//verificacao
		errorCollector.checkThat(locacao.getValor(),CoreMatchers.is(14.0));
		errorCollector.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()),CoreMatchers.is(false));
		errorCollector.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)),CoreMatchers.is(true));
    }
}
