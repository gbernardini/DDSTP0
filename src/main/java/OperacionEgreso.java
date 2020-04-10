import java.util.ArrayList;

public class OperacionEgreso {
    ArrayList<Item> items;
    boolean estaCerrada;
    double montoFinal;

    public OperacionEgreso() {
        this.items = new ArrayList<Item>();
        montoFinal = 0.0;
        estaCerrada = false;
    }

    public double calcularMonto(){
        if (estaCerrada) {
            return montoFinal;
        }

        montoFinal = 0.0;

        // actualiza el monto de la operacion en caso de que algun item haya cambiado de precio
        for (Item item : items) {
            montoFinal += item.getValor();
        }

        return montoFinal;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean debeGenerarRemito() {
        for (Item item : items) {
            if(!item.esArticulo()){
                return false;
            }
        }

        return true;
    }

    public void setEstaCerrada(boolean estaCerrada) {

        // sirve para actualizar los precios al momento de cerrar la operacion
        if (estaCerrada) {
            this.montoFinal = this.calcularMonto();
        }

        this.estaCerrada = estaCerrada;
    }

}