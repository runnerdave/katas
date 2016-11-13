package net.runnerdave;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by davidajimenez on 13/11/2016.
 */
public class QuadraticSolver {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        //Finding out the roots
        double temp1 = Math.sqrt(b * b - 4 * a * c);

        double root1 = (-b +  temp1) / (2*a) ;
        double root2 = (-b -  temp1) / (2*a) ;

        System.out.printf("R1 = %.5f\n", root1);
        System.out.printf("R2 = %.5f\n", root2);

    }
}
