package io.gabriel.github.servicos;

import org.junit.Assert;
import org.junit.Test;

import io.gabriel.github.entidades.Usuario;

public class AssertTest {
    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.assertEquals(1, 1);
        Assert.assertEquals(0.51234, 0.512,0.001);//omparar float e doubles
        Assert.assertEquals(Math.PI, 3.14,0.01);
        
        int i =5;
        Integer i2=5;
        
        Assert.assertEquals(i, i2.intValue());

        //String
        Assert.assertEquals("bola", "bola");
        Assert.assertTrue("bola".equalsIgnoreCase("bola"));
        
        Usuario u1 = new Usuario("Pessoa");
        Usuario u3 = new Usuario("Pessoa");
        Assert.assertEquals(u1, u3);

        Assert.assertNotNull(u3);
    }
}
