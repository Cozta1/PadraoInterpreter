package main.java;

public class Divisao implements ExpressaoPedido {

    private double x;
    private double y;

    public Divisao(ValorItem elementoEsquerda, ValorItem elementoDireita) {
        x = elementoEsquerda.getValor();
        y = elementoDireita.getValor();
    }

    public double interpretar() {
        return x / y;
    }
}
