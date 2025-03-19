package pojistenci.service;

import pojistenci.model.Klient;

import java.util.ArrayList;
// Třída obsahující hlavní logiku
public class SpravaKlientu {
    private ArrayList<Klient> klienti = new ArrayList<Klient>();
    // Metoda pro přidání klienta
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
    // Metoda pro výpis všech klientů
    public void vsichniKlienti() {
        for (int i = 0; i < klienti.size(); i++) {
            Klient klient = klienti.get(i);
            System.out.println(klient);
        }
    }
    // Metoda pro vyhledání Klienta
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