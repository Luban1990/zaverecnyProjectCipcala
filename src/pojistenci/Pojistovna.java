package pojistenci;
import java.util.Scanner;

public class Pojistovna {
    public static void main(String[] args) {

        SpravaKlientu sprava = new SpravaKlientu();
        Scanner scanner = new Scanner(System.in);

        int volba = 0;
        while (volba < 4){
            System.out.println("--------------------");
            System.out.println("Evidence pojištěných");
            System.out.println("--------------------");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");
            System.out.println("Zadejte číslo akce:");

            volba = Integer.parseInt(scanner.nextLine());

            switch (volba){
                case 1:
                    // Příprava na přidání klienta
                    System.out.println("Zadejte jméno: ");
                    String jmeno = scanner.nextLine().trim();
                    System.out.print("Zadejte příjmení: ");
                    String prijmeni = scanner.nextLine().trim();
                    System.out.print("Zadejte telefonní číslo: ");
                    String telefon = scanner.nextLine().trim();
                    System.out.print("Zadejte věk: ");
                    int vek = Integer.parseInt(scanner.nextLine().trim());

                    // Vytvoření klienta
                    Klient klient = new Klient(jmeno, prijmeni, vek, telefon);

                    // Přidání klienta do správy
                    sprava.pridejKlienta(klient);
                    break;

                case 2 :{
                    sprava.vsichniKlienti();
                    break;
                }
                case 3:
                    System.out.println("Zadejte jmeno pojištěného:");
                    String hledaneJmeno = scanner.nextLine().trim();
                    System.out.println("Zadejte přijmení");
                    String hledanePrijmeni = scanner.nextLine().trim();
                    sprava.vyhledejKlienta(hledaneJmeno, hledanePrijmeni);
                    break;

                case 4:
                    System.out.println("Konec programu");
                    break;

                default:
                    System.out.println("Neplatná volba");
                    break;
            }

        }


    }
}
