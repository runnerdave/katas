package net.runnerdave;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Created by David A. Jiménez (e67997) on 13/01/2017.
 */
public class FunWithListsReduce {

    /**
     *
     Implement the method reduce, which accepts three arguments:

     linked list (head)
     bi-function - (accumulated_value, current_element_data)
     initial value

     This method should return the result of applying the given function on every element with the accumulating result, starting with the initial value.

     For example:

     Given the list: 1 -> 2 -> 3, the function (acc, curr) => acc + curr and an initial value of 0, reduce should return 6, because:

     (0, 1) and the function (acc, curr) => acc + curr gives 1
     (1, 2) and the function (acc, curr) => acc + curr gives 3
     (3, 3) and the function (acc, curr) => acc + curr gives 6

     Another example:

     Given the list: 1 -> 2 -> 3 -> 4, the function (acc, curr) => acc * curr and an initial value of 1, reduce should return 24
     */


    public static <T extends Node<T>> T reduce(Node<T> linkedList, BiFunction<T, T, T> accumulator, T initialValue){
        Node<T> nodeValue = Stream.of(linkedList).reduce(initialValue, (BinaryOperator<Node<T>>) accumulator);
        return nodeValue.data;
    }
}

class Node<T> {
    public T data;
    public Node<T> next;

    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(T data) {
        this(data, null);
    }
}
