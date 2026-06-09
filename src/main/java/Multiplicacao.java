package main.java;

public class Multiplicacao implements ExpressaoPedido {

    private double x;
    private double y;

    public Multiplicacao(ValorItem elementoEsquerda, ValorItem elementoDireita) {
        x = elementoEsquerda.getValor();
        y = elementoDireita.getValor();
    }

    public double interpretar() {
        return x * y;
    }
}
