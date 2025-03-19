package pojistenci.model;

import java.util.regex.Pattern;

public class Klient {
    private String jmeno;
    private String prijmeni;
    private String telefon;
    private int vek;

    // Regulární výraz pro telefonní číslo (pouze čísla, 9-15 znaků)
    private static final Pattern TELEFONNI_VZOR = Pattern.compile("^\\d{9,15}$");

    // Constructor + validace jmena, přijmeni,veku, telefonu
    public Klient(String jmeno, String prijmeni, int vek, String telefon) {
        if (jmeno == null || jmeno.isEmpty()) {
            throw new IllegalArgumentException("Jméno nesmí být prázdné!");
        }
        if (prijmeni == null || prijmeni.isEmpty()) {
            throw new IllegalArgumentException("Příjmení nesmí být prázdné!");
        }
        if (vek <= 0) {
            throw new IllegalArgumentException("Věk musí být větší než 0 a nesmí být záporné číslo!");
        }
        if (telefon == null || telefon.isEmpty()) {
            throw new IllegalArgumentException("Telefonní číslo nesmí být prázdné!");
        }
        if (!TELEFONNI_VZOR.matcher(telefon).matches()) {
            throw new IllegalArgumentException("Telefonní číslo musí obsahovat pouze číslice (9-15 znaků)!");
        }

        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }
    // Přepsaná metoda pro výpis
    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " (" + vek + " let), Tel: " + telefon;
    }
    // Gettery
    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getVek() {
        return vek;
    }

}