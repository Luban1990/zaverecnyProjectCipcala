package pojistenci.view;

import pojistenci.model.Klient;
import pojistenci.service.SpravaKlientu;

import java.util.Scanner;

public class Menu {
    // isntance tříd
    private final SpravaKlientu sprava;
    private final Scanner scanner;
    // Constructor
    public Menu() {
        this.sprava = new SpravaKlientu();
        this.scanner = new Scanner(System.in);
    }
    // Do- spustí alespoň jednou cyklus

    public void spustit() {
        int volba;

        do {
            zobrazMenu();
            volba = ziskejVolbu();

            switch (volba) {
                case 1:
                    pridatKlienta();
                    break;
                case 2:
                    sprava.vsichniKlienti();
                    break;
                case 3:
                    vyhledatKlienta();
                    break;
                case 4:
                    System.out.println("Konec programu.");
                    break;
                default:
                    System.out.println("Neplatná volba, zkuste to znovu.");
            }

        } while (volba != 4);

        scanner.close();
    }
    // Vykreslení menu s operacemi
    private void zobrazMenu() {
        System.out.println("--------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("--------------------");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
        System.out.print("Zadejte číslo akce: ");
    }

    private int ziskejVolbu() {
        while (!scanner.hasNextInt()) {
            System.out.println("Neplatná volba. Zadejte číslo akce:");
            scanner.next();
        }
        int volba = scanner.nextInt();
        scanner.nextLine();
        return volba;
    }

    private void pridatKlienta() {
        System.out.print("Zadejte jméno: ");
        String jmeno = scanner.nextLine().trim();
        System.out.print("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();
        System.out.print("Zadejte telefonní číslo: ");
        String telefon = scanner.nextLine().trim();
        System.out.print("Zadejte věk: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Neplatný věk. Zadejte číslo:");
            scanner.next();
        }
        int vek = scanner.nextInt();
        scanner.nextLine();

        try {
            sprava.pridejKlienta(new Klient(jmeno, prijmeni, vek, telefon));
        } catch (IllegalArgumentException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    private void vyhledatKlienta() {
        System.out.print("Zadejte jméno: ");
        String hledaneJmeno = scanner.nextLine().trim();
        System.out.print("Zadejte příjmení: ");
        String hledanePrijmeni = scanner.nextLine().trim();
        sprava.vyhledejKlienta(hledaneJmeno, hledanePrijmeni);
    }


}
