package Kursovaya;

import Jama.*;

import java.util.Scanner;

public class TrendLine {
    static void TrendLine(){
        //создание массивов по Х и по Y взятые из БД

    }

    static void lineynaya(){
        Scanner sc = new Scanner(System.in);
        double[] x = new double[18];
        double[] y = new double[18];
        double sum_x = 0, sum_y = 0, sum_xx = 0, sum_xy = 0, sum_yy=0;
        for (int i = 0; i < x.length; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
            sum_x += x[i];
            sum_y += y[i];
            sum_xx += x[i] * x[i];
            sum_xy += x[i] * y[i];
            sum_yy+=y[i]*y[i];
        }
        double a, b;
        b = (sum_xy * sum_x - sum_y * sum_xx) / (sum_x * sum_x - 18 * sum_xx);
        a = (sum_y - 18 * b) / sum_x;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
