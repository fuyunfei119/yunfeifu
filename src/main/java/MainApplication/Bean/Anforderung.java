package MainApplication.Bean;

import java.sql.Date;

public class Anforderung {
    private int Anforderung_id;
    private String Anforderung_name;
    private String Anforderung_beschreibung;
    private Double zu_gewinnen_Umsatz;
    private Date Eintragungszeit;
    private int Auftraggeber;
    private Abteilung abteilung;
    private int Abteilung_id;
    private int Arbeitnehmer;
    private String Abteilung_name;
    private String Arbeinehmer_name;
    private String kundenname;
    private int kundennummer;

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getAbteilung_name() {
        return Abteilung_name;
    }

    public void setAbteilung_name(String abteilung_name) {
        Abteilung_name = abteilung_name;
    }

    public String getArbeinehmer_name() {
        return Arbeinehmer_name;
    }

    public void setArbeinehmer_name(String arbeinehmer_name) {
        Arbeinehmer_name = arbeinehmer_name;
    }

    public String getKundenname() {
        return kundenname;
    }

    public void setKundenname(String kundenname) {
        this.kundenname = kundenname;
    }

    public int getArbeitnehmer() {
        return Arbeitnehmer;
    }

    public void setArbeitnehmer(int arbeitnehmer) {
        Arbeitnehmer = arbeitnehmer;
    }

    public int getAbteilung_id() {
        return Abteilung_id;
    }

    public void setAbteilung_id(int abteilung_id) {
        Abteilung_id = abteilung_id;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }

    public Double getZu_gewinnen_Umsatz() {
        return zu_gewinnen_Umsatz;
    }

    public void setZu_gewinnen_Umsatz(Double zu_gewinnen_Umsatz) {
        this.zu_gewinnen_Umsatz = zu_gewinnen_Umsatz;
    }

    public Date getEintragungszeit() {
        return Eintragungszeit;
    }

    public void setEintragungszeit(Date eintragungszeit) {
        Eintragungszeit = eintragungszeit;
    }

    public int getAuftraggeber() {
        return Auftraggeber;
    }

    public void setAuftraggeber(int auftraggeber) {
        Auftraggeber = auftraggeber;
    }

    public int getAnforderung_id() {
        return Anforderung_id;
    }

    public void setAnforderung_id(int anforderung_id) {
        Anforderung_id = anforderung_id;
    }

    public String getAnforderung_name() {
        return Anforderung_name;
    }

    public void setAnforderung_name(String anforderung_name) {
        Anforderung_name = anforderung_name;
    }

    public String getAnforderung_beschreibung() {
        return Anforderung_beschreibung;
    }

    public void setAnforderung_beschreibung(String anforderung_beschreibung) {
        Anforderung_beschreibung = anforderung_beschreibung;
    }

    @Override
    public String toString() {
        return "Anforderung{" +
                "Anforderung_id=" + Anforderung_id +
                ", Anforderung_name='" + Anforderung_name + '\'' +
                ", Anforderung_beschreibung='" + Anforderung_beschreibung + '\'' +
                ", zu_gewinnen_Umsatz=" + zu_gewinnen_Umsatz +
                ", Eintragungszeit=" + Eintragungszeit +
                ", Auftraggeber=" + Auftraggeber +
                ", abteilung=" + abteilung +
                ", Abteilung_id=" + Abteilung_id +
                ", Arbeitnehmer=" + Arbeitnehmer +
                ", Abteilung_name='" + Abteilung_name + '\'' +
                ", Arbeinehmer_name='" + Arbeinehmer_name + '\'' +
                ", kundenname='" + kundenname + '\'' +
                ", kundennummer=" + kundennummer +
                '}';
    }
}
