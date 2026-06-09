package main.java;

public class Pedido {
    private double lanche;
    private double bebida;

    public double getLanche() {
        return lanche;
    }

    public void setLanche(double lanche) {
        this.lanche = lanche;
    }

    public double getBebida() {
        return bebida;
    }

    public void setBebida(double bebida) {
        this.bebida = bebida;
    }

    public double calcularTotal() {
        return Caixa.calcularTotal(this.lanche, this.bebida);
    }
}
