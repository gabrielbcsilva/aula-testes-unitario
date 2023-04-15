package io.gabriel.github.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import io.gabriel.github.entidades.Filme;
import io.gabriel.github.entidades.Locacao;
import io.gabriel.github.entidades.Usuario;
import io.gabriel.github.utils.DataUtils;

public class LocacaoServiceTest {
    @Test
    public void test(){
        //cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Joao");
		Filme filme = new Filme("Filme 1", 2, 4.0);
		//acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
		//verificacao
		Assert.assertTrue(locacao.getValor()==4.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()) );
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)));
    }
}
