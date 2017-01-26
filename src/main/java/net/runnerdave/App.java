package net.runnerdave;

import net.runnerdave.algorithms.sedgwick.wayne.StdDraw;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        //example of the StdDraw library from the book: "Algorithms", code is under package: net.runnerdave.algorithms.sedgwick.wayne
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);
    }
}
