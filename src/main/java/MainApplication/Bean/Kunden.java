package MainApplication.Bean;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class Kunden {

    private int kundennummer;
    private String kundenname;
    private int kundensanforderung;
    private Date eintragungszeit;
    private String Bilder;
    private String Standort;
    private Anforderung anforderung;
    private String Branche;
    private String Ansprechpartner;
    private String Adress;
    private MultipartFile uploadfile;

    public MultipartFile getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }

    public String getAnsprechpartner() {
        return Ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        Ansprechpartner = ansprechpartner;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getBranche() {
        return Branche;
    }

    public void setBranche(String branche) {
        Branche = branche;
    }

    public Anforderung getAnforderung() {
        return anforderung;
    }

    public void setAnforderung(Anforderung anforderung) {
        this.anforderung = anforderung;
    }

    public String getBilder() {
        return Bilder;
    }

    public void setBilder(String bilder) {
        Bilder = bilder;
    }

    public String getStandort() {
        return Standort;
    }

    public void setStandort(String standort) {
        Standort = standort;
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getKundenname() {
        return kundenname;
    }

    public void setKundenname(String kundenname) {
        this.kundenname = kundenname;
    }

    public int getKundensanforderung() {
        return kundensanforderung;
    }

    public void setKundensanforderung(int kundensanforderung) {
        this.kundensanforderung = kundensanforderung;
    }

    public Date getEintragungszeit() {
        return eintragungszeit;
    }

    public void setEintragungszeit(Date eintragungszeit) {
        this.eintragungszeit = eintragungszeit;
    }

    @Override
    public String toString() {
        return "Kunden{" +
                "kundennummer=" + kundennummer +
                ", kundenname='" + kundenname + '\'' +
                ", kundensanforderung=" + kundensanforderung +
                ", eintragungszeit=" + eintragungszeit +
                ", Bilder='" + Bilder + '\'' +
                ", Standort='" + Standort + '\'' +
                ", anforderung=" + anforderung +
                ", Branche='" + Branche + '\'' +
                ", Ansprechpartner='" + Ansprechpartner + '\'' +
                ", Adress='" + Adress + '\'' +
                ", uploadfile=" + uploadfile +
                '}';
    }
}
