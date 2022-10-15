/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8p2;

/**
 *
 * @author lukasbernard
 * This is my own node class
 */
public class Node<T> //generic of type T
{
    T key; //type T key
    int value;
    Node next;
    /**
     * 
     * @param key
     * @param value 
     * Takes any type of key and sets it to key
     * Takes an integer value and sets it to value
     */
    Node(T key, int value)
    {
        this.key = key;
        this.value = value;
    }

    public T getKey(){return key;}
    public void setKey(T key){this.key = key;}
    public int getVal(){return value;}
    public void setVal(int value){this.value = value;}
    public void setNext(Node next){this.next = next;}
    public Node getNext(){return next;}           
}
