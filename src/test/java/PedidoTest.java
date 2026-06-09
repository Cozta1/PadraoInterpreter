package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveCalcularTotalComFormula() {
        Pedido pedido = new Pedido();
        pedido.setLanche(18.0);
        pedido.setBebida(6.0);

        assertEquals(42.0, pedido.calcularTotal());
    }

}
