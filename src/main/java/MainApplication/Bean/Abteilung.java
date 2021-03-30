package MainApplication.Bean;

import java.util.ArrayList;

public class Abteilung implements Comparable{

    private int Abteilung_id;
    private String Abteilung_name;
    private String Abteilung_beschreibung;
    private ArrayList<Arbeitnehmer> arbeitnehmers;

    public int getAbteilung_id() {
        return Abteilung_id;
    }

    public void setAbteilung_id(int abteilung_id) {
        Abteilung_id = abteilung_id;
    }

    public String getAbteilung_name() {
        return Abteilung_name;
    }

    public void setAbteilung_name(String abteilung_name) {
        Abteilung_name = abteilung_name;
    }

    public String getAbteilung_beschreibung() {
        return Abteilung_beschreibung;
    }

    public void setAbteilung_beschreibung(String abteilung_beschreibung) {
        Abteilung_beschreibung = abteilung_beschreibung;
    }


    public ArrayList<Arbeitnehmer> getArbeitnehmers() {
        return arbeitnehmers;
    }

    public void setArbeitnehmers(ArrayList<Arbeitnehmer> arbeitnehmers) {
        this.arbeitnehmers = arbeitnehmers;
    }

    @Override
    public String toString() {
        return "Abteilung{" +
                "Abteilung_id=" + Abteilung_id +
                ", Abteilung_name='" + Abteilung_name + '\'' +
                ", Abteilung_beschreibung='" + Abteilung_beschreibung + '\'' +
                ", arbeitnehmers=" + arbeitnehmers +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Abteilung abteilung = (Abteilung) o;
        return this.Abteilung_id - abteilung.Abteilung_id ;
    }
}
