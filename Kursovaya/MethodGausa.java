package Kursovaya;


import java.util.Scanner;

public class MethodGausa {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        double[][] A = new double[3][3];
        double[] d = new double[3];
        double l;
        int m;
        double[][] B = new double[3][3];
        double[] D = new double[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = sr.nextDouble();
            }
            d[i] = sr.nextDouble();
        }
        int n = 0;
        for (int i = 3; i > 0; i--) {
            m = 3 - i;
            l = 1 / A[m][m];
            for (int j = 3 - i; j < 3; j++) {
                for (int k = 3 - i; k < 3; k++) {
                    n++;
                    if (j == k && j == m) {
                        B[j][k] = 1;
                        continue;
                    }
                    if (j == m) {
                        B[j][k] = l * A[j][k];
                        D[j] = l * d[j];
                        continue;
                    }
                    if (k == m) {
                        B[j][k] = 0;
                        continue;
                    }
                    B[j][k] = (-l) * A[j][3 - i] * A[m][k] + A[j][k];
                    n++;
                    D[j]=(-l)*d[i]+d[j];
                }
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    A[j][k] = B[j][k];
                    System.out.printf(A[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }
        System.out.println("количество итераций" + n);
    }
}
