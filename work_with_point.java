package Kurs2;
import java.util.ArrayList;

public class work_with_point {
    ArrayList <Point> array;
     work_with_point(){
        array = new ArrayList<>();
    }
     void add_point(double x, double y){
        if (array.isEmpty())array.add(new Point(x,y));
        else {
            int i = 0;
            while (i<array.size()){
                if (array.get(i).get_x()==x && array.get(i).get_y()==y){
                    System.out.print("Точка уже задана  ");
                    System.out.print("x = "+array.get(i).get_x());
                    System.out.println("  y = "+array.get(i).get_y());
                    break;
                }
                i++;
            }
            if(i==array.size())array.add(i,new Point(x,y));
        }
    }
    //расстояние между точками
     double L(int i, int j){
        double t= Math.pow(array.get(i).get_x()-array.get(j).get_x(),2);
        double p= Math.pow(array.get(i).get_y()-array.get(j).get_y(),2);
        return Math.pow(t+p,0.5);
    }
    //путь между точками
    public double S(int i, int j){
        double s= 0;
        for (int k = i; k < j; k++) {
            double t= Math.pow(array.get(i).get_x()-array.get(j).get_x(),2);
            double p= Math.pow(array.get(i).get_y()-array.get(j).get_y(),2);
            s+=Math.pow(t+p,0.5);
        }
        return s;
    }
}
