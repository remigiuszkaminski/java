import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> grades = new ArrayList<Double>();


    public void addOcena(double ocenka){
        grades.add(ocenka);
    }

    public double sredniaOcen(){
        double sum = 0;
        if(grades.isEmpty()){
            return 0;
        } else {
            for (double i : grades) {
                sum += i;
            }
            return sum / grades.size();
        }
    }

    public double najwyzszaOcena(){
        double wysoka = 0;
        if(grades.isEmpty()){
            return 0;
        } else {
            for (double i : grades) {
                if (wysoka <= i) {
                    wysoka = i;
                }
            }
            return wysoka;
        }
    }

    public double najnizszaOcena(){
        if(grades.isEmpty()){
            return 0;
        } else {
            double niska = grades.get(0);
            for (double i : grades) {
                if (niska >= i) {
                    niska = i;
                }
            }
            return niska;
        }
    }



}