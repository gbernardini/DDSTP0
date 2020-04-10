
public class Item {
    private boolean esArticulo;
    private double valor;

    public Item(boolean esArticulo, double valor){
         this.esArticulo = esArticulo;
         this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean esArticulo() {
        return esArticulo;
    }
}
