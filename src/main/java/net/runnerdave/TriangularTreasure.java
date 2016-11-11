package net.runnerdave;

/**
 * Created by David A. Jimene (e67997) on 11/11/2016.
 */
public class TriangularTreasure {
    public static int triangular(int n) {
        return 0;
    }

    public static void main(String[] args) {
//        String[][] matrix = fillMatrix(3);
//        System.out.println(laidAsTriangle(matrix));
//        printStaticTriangle(6);
    }

    public static void jumper(int qty) {
        for (int i = 0; i < (qty/2 + 1); i++) {

        }
    }
    
    public static String laidAsTriangle(String[][] matrix) {
        String str = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                    if (matrix[i][j].equals("*")) {
                        str += matrix[i][j];
                    } else {
                        str += " ";
                    }
            }
            str += "\n";
        }
        return str;
    }

    public static void printStaticTriangle(int size) {
        int i, j;
        for(i=size;i>=1;i--)
        {
            for(j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static String[][] fillMatrix(int dots) {
        String[][] matrix = new String[dots/2 + 1][dots/2 + 1];
        boolean across = true;
        matrix[0][0] = "*";
        int i = 0;
        int j = 0;
        while(dots>0) {
            if(across){
                i++;
                across = false;
            } else {

            }
            matrix[i][j] = "";
            dots--;
        }
        return matrix;
    }
}
