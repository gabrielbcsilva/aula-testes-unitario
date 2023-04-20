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

public class LocacaoServiceMicroTest {
	
    @Test
    public void testeValorLocacao(){
       
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Joao");
		Filme filme = new Filme("Filme 1", 2, 4.0);
	
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
	
	
		Assert.assertThat(locacao.getValor(),CoreMatchers.is(4.0));
    }
    @Test
    public void testeDataLocacao(){
       
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Joao");
		Filme filme = new Filme("Filme 1", 2, 4.0);

		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
	

		Assert.assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()),CoreMatchers.is(true));
    }
    @Test
    public void testDataRetornoLocacao(){
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Joao");
		Filme filme = new Filme("Filme 1", 2, 4.0);

		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
	
		Assert.assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)),CoreMatchers.is(true));
    }
}
