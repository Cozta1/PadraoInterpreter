package main.java;

public class Caixa {

    public static String formula = "lanche * 2 + bebida";

    public static double calcularTotal(double lanche, double bebida) {
        String expressao;
        expressao = formula.replace("lanche", Double.toString(lanche));
        expressao = expressao.replace("bebida", Double.toString(bebida));
        ExpressaoPedido interpretador = new CalculadoraPedido(expressao);
        return interpretador.interpretar();
    }
}
