public class Main {
    public static void main(String[] args) {
        Wasserfahrzeug[] wasserfahrzeuge = new Wasserfahrzeug[5];
        wasserfahrzeuge[0] = new Motorboot("Motorboot 1", 10000.0, 100, 4);
        wasserfahrzeuge[1] = new MiniUboot("Mini-Uboot 1", 20000.0 , 200, 100);
        wasserfahrzeuge[2] = new Ruderboot("Ruderboot 1", 5000.0, 2, 2);
        wasserfahrzeuge[3] = new Tretboot("Tretboot 1", 6000.0, 4, 2);
        wasserfahrzeuge[4] = new Motorboot("Motorboot 2", 15000.0, 150, 6);

        for (Wasserfahrzeug w : wasserfahrzeuge) {
            w.zeigeInformationen();
            System.out.println();
            w.fahre();
            System.out.println();
        }
    }
}
