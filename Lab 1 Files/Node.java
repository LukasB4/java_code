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

//written by myself in CSCI 132
//directs previous and next, additionally holds the data
public class Node {
    private String data;
    private Node next;
    private Node prev;
    
    public Node(String d){ data = d;}
    public Node getNext(){return next;}
    public void setNext(Node temp) {next = temp;}
    public Node getPrev(){return prev;}
    public void setPrev(Node temp) { prev = temp;}
    public String getData(){return data;}
}
