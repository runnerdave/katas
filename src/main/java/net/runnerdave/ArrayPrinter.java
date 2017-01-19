package net.runnerdave;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by David A. Jiménez (e67997) on 16/01/2017.
 */
public class ArrayPrinter {
    public void print2DStringArrayIterators(String [][]multi){

        Iterable<String[]> outerList = Arrays.asList(multi);
        Iterator<String[]> outer = outerList.iterator();

        while(outer.hasNext()){
            String[] innerMulti = outer.next();
            Iterable<String> innerList = Arrays.asList(innerMulti);
            Iterator<String> inner = innerList.iterator();

            while(inner.hasNext()){
                String pixel = inner.next();
                System.out.print(pixel);
            }
            System.out.println("");
            break;//causes a problem
        }
    }
}
