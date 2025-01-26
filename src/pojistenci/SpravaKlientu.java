package pojistenci;

import java.util.ArrayList;

public class SpravaKlientu {
    private ArrayList<Klient> klienti = new ArrayList<Klient>();

    public void pridejKlienta(Klient klient) {
        for (Klient k : klienti) {
            if (k.getJmeno().toLowerCase().equals(klient.getJmeno().toLowerCase()) &&
                    k.getPrijmeni().toLowerCase().equals(klient.getPrijmeni().toLowerCase()) &&
                    k.getTelefon().equals(klient.getTelefon()) &&
                    k.getVek() == klient.getVek()) {
                System.out.println("Tento klient již v seznamu existuje!");
                return; // Ukončí metodu, pokud je klient již v seznamu
            }
        }
        klienti.add(klient); // Přidání klienta pouze, pokud není duplicita
        System.out.println("Klient byl přidán do seznamu pojištěnců.");
    }

    public void vsichniKlienti() {
        for (int i = 0; i < klienti.size(); i++) {
            Klient klient = klienti.get(i);
            System.out.println(klient);
        }
    }

    public void vyhledejKlienta(String jmeno, String prijmeni) {
        boolean nalezen = false;

        for (Klient klient : klienti) {
            if (klient.getJmeno().equalsIgnoreCase(jmeno) && klient.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println(klient);
                nalezen = true;
            }
        }

        if (!nalezen) {
            System.out.println("Klient nebyl nalezen v seznamu pojištěnců.");
        }
    }

}