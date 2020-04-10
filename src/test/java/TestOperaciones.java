import junit.framework.TestCase;

public class TestOperaciones extends TestCase {
    private OperacionEgreso operacionPintura;
    private OperacionEgreso operacionaire;
    private Item lataPintura;
    private Item pincel;
    private Item aguarras;
    private Item aireAcondicionado;
    private Item instalacionAire;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        lataPintura = new Item(true,500);
        pincel = new Item(true,30);
        aguarras = new Item(true,50);

        aireAcondicionado = new Item(true,15500);
        instalacionAire = new Item(false,4000);

        operacionPintura = new OperacionEgreso();
        operacionPintura.addItem(lataPintura);
        operacionPintura.addItem(pincel);
        operacionPintura.addItem(aguarras);

        operacionaire = new OperacionEgreso();
        operacionaire.addItem(aireAcondicionado);
        operacionaire.addItem(instalacionAire);
    }

    public void testCalculoMontoOperacion() {
        assertEquals(operacionPintura.calcularMonto(),580.0);
    }

    public void testCalculoMontoOperacionCerrada() {
        operacionPintura.setEstaCerrada(true);
        pincel.setValor(10.0);

        assertEquals(operacionPintura.calcularMonto(),580.0);
    }

    public void testCalculoMontoOperacionAbierta() {
        pincel.setValor(10.0);

        assertEquals(operacionPintura.calcularMonto(),560.0);
    }

    public void testGeneracionRemitoOperacion() {
        assertTrue(operacionPintura.debeGenerarRemito());
    }

    public void testNoGeneracionRemitoOperacion() {
        assertFalse(operacionaire.debeGenerarRemito());
    }
}
