/**
 * Abstrakte Basisklasse für Wasserfahrzeuge
 */
public abstract class Wasserfahrzeug {
    protected String name;
    protected double preis;

    public Wasserfahrzeug(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    /**
     * Abstrakte Methode zum Anzeigen von Informationen über das Wasserfahrzeug
     */
    public abstract void zeigeInformationen();

    /**
     * Methode zum Testen von Polymorphie
     */
    public void fahre() {
        System.out.println("Das Wasserfahrzeug " + name + " fährt.");
    }
}