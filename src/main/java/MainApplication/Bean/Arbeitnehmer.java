package MainApplication.Bean;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class Arbeitnehmer {

    private int id;
    private String name;
    private String password;
    private String Mail;
    private String telefonnummber;
    private Date eintragungszeit;
    private String Geschlechte;
    private int Abteilung_id;
    private String Geburtsort;
    private Date Geburtsdatum;
    private String Wohnungort;
    private Abteilung abteilung;
    private String Schulische_Ausbildung;
    private String Berufliche_Ausbildung;
    private String Studium;
    private MultipartFile uploadfile;
    private String Bilder;
    private Double Gehalt;
    private String Bewertung;

    public String getBewertung() {
        return Bewertung;
    }

    public void setBewertung(String bewertung) {
        Bewertung = bewertung;
    }

    public Double getGehalt() {
        return Gehalt;
    }

    public void setGehalt(Double gehalt) {
        Gehalt = gehalt;
    }

    public String getBilder() {
        return Bilder;
    }

    public void setBilder(String bilder) {
        Bilder = bilder;
    }

    public MultipartFile getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getTelefonnummber() {
        return telefonnummber;
    }

    public void setTelefonnummber(String telefonnummber) {
        this.telefonnummber = telefonnummber;
    }

    public Date getEintragungszeit() {
        return eintragungszeit;
    }

    public void setEintragungszeit(Date eintragungszeit) {
        this.eintragungszeit = eintragungszeit;
    }

    public String getGeschlechte() {
        return Geschlechte;
    }

    public void setGeschlechte(String geschlechte) {
        Geschlechte = geschlechte;
    }

    public int getAbteilung_id() {
        return Abteilung_id;
    }

    public void setAbteilung_id(int abteilung_id) {
        Abteilung_id = abteilung_id;
    }

    public String getGeburtsort() {
        return Geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        Geburtsort = geburtsort;
    }

    public Date getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public String getWohnungort() {
        return Wohnungort;
    }

    public void setWohnungort(String wohnungort) {
        Wohnungort = wohnungort;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }

    public String getSchulische_Ausbildung() {
        return Schulische_Ausbildung;
    }

    public void setSchulische_Ausbildung(String schulische_Ausbildung) {
        Schulische_Ausbildung = schulische_Ausbildung;
    }

    public String getBerufliche_Ausbildung() {
        return Berufliche_Ausbildung;
    }

    public void setBerufliche_Ausbildung(String berufliche_Ausbildung) {
        Berufliche_Ausbildung = berufliche_Ausbildung;
    }

    public String getStudium() {
        return Studium;
    }

    public void setStudium(String studium) {
        Studium = studium;
    }

    @Override
    public String toString() {
        return "Arbeitnehmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", Mail='" + Mail + '\'' +
                ", telefonnummber='" + telefonnummber + '\'' +
                ", eintragungszeit=" + eintragungszeit +
                ", Geschlechte='" + Geschlechte + '\'' +
                ", Abteilung_id=" + Abteilung_id +
                ", Geburtsort='" + Geburtsort + '\'' +
                ", Geburtsdatum=" + Geburtsdatum +
                ", Wohnungort='" + Wohnungort + '\'' +
                ", abteilung=" + abteilung +
                ", Schulische_Ausbildung='" + Schulische_Ausbildung + '\'' +
                ", Berufliche_Ausbildung='" + Berufliche_Ausbildung + '\'' +
                ", Studium='" + Studium + '\'' +
                ", uploadfile=" + uploadfile +
                ", Bilder='" + Bilder + '\'' +
                ", Gehalt=" + Gehalt +
                ", Bewertung='" + Bewertung + '\'' +
                '}';
    }
}
