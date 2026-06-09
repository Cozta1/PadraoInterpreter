package main.java;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CalculadoraPedido implements ExpressaoPedido {

    private ExpressaoPedido interpretadorInicial;

    public CalculadoraPedido(String contexto) {

        Stack<ExpressaoPedido> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilhaInterpretadores.push(new ValorItem(Double.parseDouble(elemento)));
            } else if (elemento.equals("+")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Pedido invalido");
                ValorItem elementoEsquerda = (ValorItem) pilhaInterpretadores.pop();
                ValorItem elementoDireita = new ValorItem(Double.parseDouble(iterator.next()));
                Adicao interpretador = new Adicao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new ValorItem(interpretador.interpretar()));
            } else if (elemento.equals("-")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Pedido invalido");
                ValorItem elementoEsquerda = (ValorItem) pilhaInterpretadores.pop();
                ValorItem elementoDireita = new ValorItem(Double.parseDouble(iterator.next()));
                Subtracao interpretador = new Subtracao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new ValorItem(interpretador.interpretar()));
            } else if (elemento.equals("*")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Pedido invalido");
                ValorItem elementoEsquerda = (ValorItem) pilhaInterpretadores.pop();
                ValorItem elementoDireita = new ValorItem(Double.parseDouble(iterator.next()));
                Multiplicacao interpretador = new Multiplicacao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new ValorItem(interpretador.interpretar()));
            } else if (elemento.equals("/")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Pedido invalido");
                ValorItem elementoEsquerda = (ValorItem) pilhaInterpretadores.pop();
                ValorItem elementoDireita = new ValorItem(Double.parseDouble(iterator.next()));
                Divisao interpretador = new Divisao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new ValorItem(interpretador.interpretar()));
            } else {
                throw new IllegalArgumentException("Pedido com elemento invalido");
            }
        }
        interpretadorInicial = pilhaInterpretadores.pop();
    }

    public double interpretar() {
        return interpretadorInicial.interpretar();
    }
}
