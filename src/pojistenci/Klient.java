package pojistenci;


public class Klient {
    private String jmeno;
    private String prijmeni;
    private String telefon;
    private int vek;


    public Klient(String jmeno,String prijmeni, int vek , String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.vek = vek;

        if (jmeno == null || jmeno.isEmpty()) {
            throw new IllegalArgumentException("Jméno nesmí být prázdné!");
        }
        if ( prijmeni == null || prijmeni.isEmpty()){
            throw new IllegalArgumentException ("Přijmení nesmí být prázdné!");
        }
        if (vek<=0){
            throw new IllegalArgumentException("Věk musí být větší než 0 a nesmí být záporné číslo!");
        }
        if (telefon == null || telefon.isEmpty()){
            throw new IllegalArgumentException("Telefonní číslo by mělo obsahovat alespoň 9 číslic a nemělo by být prázdné!");
        }
    }


    @Override
    public String toString(){
        return jmeno + " " + prijmeni + " " + vek + " " + telefon;
    }


    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

}
