package main.java;

public class Subtracao implements ExpressaoPedido {

    private double x;
    private double y;

    public Subtracao(ValorItem elementoEsquerda, ValorItem elementoDireita) {
        x = elementoEsquerda.getValor();
        y = elementoDireita.getValor();
    }

    public double interpretar() {
        return x - y;
    }
}
