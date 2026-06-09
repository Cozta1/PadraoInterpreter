package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraPedidoTest {

    @Test
    void deveCalcularExpressaoSoma() {
        ExpressaoPedido interpretador = new CalculadoraPedido("6 + 2");
        assertEquals(8.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoSubtracao() {
        ExpressaoPedido interpretador = new CalculadoraPedido("6 - 2");
        assertEquals(4.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoMultiplicacao() {
        ExpressaoPedido interpretador = new CalculadoraPedido("6 * 2");
        assertEquals(12.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoDivisao() {
        ExpressaoPedido interpretador = new CalculadoraPedido("6 / 2");
        assertEquals(3.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoCombinada() {
        ExpressaoPedido interpretador = new CalculadoraPedido("10 / 2 * 3 + 1 - 4");
        assertEquals(12.0, interpretador.interpretar());
    }

    @Test
    void deveRetonarExcecaoElementoInvalido() {
        try {
            ExpressaoPedido interpretador = new CalculadoraPedido("2 ^ 2");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pedido com elemento invalido", e.getMessage());
        }
    }

    @Test
    void deveRetonarExcecaoInvalida() {
        try {
            ExpressaoPedido interpretador = new CalculadoraPedido("2 +");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pedido invalido", e.getMessage());
        }
    }
}
