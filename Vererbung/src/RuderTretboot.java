/**
 * Abstrakte Klasse für Ruder- und Tretboote
 */
public abstract class RuderTretboot extends Wasserfahrzeug {
    protected int sitzplaetze;

    public RuderTretboot(String name, double preis, int sitzplaetze) {
        super(name, preis);
        this.sitzplaetze = sitzplaetze;
    }

    @Override
    public void zeigeInformationen() {
        System.out.println("Name: " + name);
        System.out.println("Preis: " + preis);
        System.out.println("Sitzplätze: " + sitzplaetze);
    }
}