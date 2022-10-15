/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author lukasbernard
 */

//This entire code is written from scratch, the node.java file used is from CSCI 132
//This is the driver class
public class driver {
    public static void main(String[] args)
    {
        System.out.println("Problem 1 solution");
        LinkedList ll = new LinkedList();
        ll.split("to be or not to be");
        ll.insert();
        ll.print();
        ll.deleteDups();
        ll.print();
        System.out.println();
        System.out.println("Problem 2 solution: ");
        Stack s = new Stack();
        s.split("to be $ or not $ $ to be that is the question $ $ $");
        s.pushpop();
        s.print();
    }
}
