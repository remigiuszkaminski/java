import java.lang.Math;
public class Walec {
    
    private double podstawa;
    private double wysokosc;

    public double getPodstawa() {
        return podstawa;
    }
    public double getWysokosc() {
        return wysokosc;
    }

    public void setPodstawa( double newPodstawa) {
        this.podstawa = newPodstawa;
    }
    public void setWysokosc( double newWysokosc) {
        this.wysokosc = newWysokosc;
    }

    public Walec(double pod, double wys) {
        this.podstawa = pod;
        this.wysokosc = wys;
    }

    public Walec() {
        this.podstawa = null;
        this.wysokosc = null;
    }

    public double liczPolePod() {
        return Math.PI * Math.pow(podstawa, 2);
    }

    public double boczne() {
        return 2 * Math.PI * podstawa * wysokosc;
    }

    public double calkowite() {
        return 2 * liczPolePod() + boczne();
    }
    
    public double objetosc() {
        return liczPolePod() * wysokosc;
    }


}
