/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.*;
/**
 *
 * @author lukasbernard
 * I wrote this directed graph structure myself
 * I will be using a directed graph data structure
 */
public class Graph
{
    private int length = 1;
    private Node[] pathSet = new Node[10000]; //new node array
    private ArrayList<Integer> test;
    
    public Graph(ArrayList<Integer> p)
    {
        test = p;
    }
    /**
     * addEdge
     * takes the Arraylist from the constructor
     * reads each entry, creates a node
     * If the value is larger add it to the end of every existing linked list in the array
     * if the value is smaller, give it it's own entry into the array and make it the tail of the linked list it is in
     */
    public void addEdge()
    {
        int current;
        int previous = test.get(0); //set the previous number
        int indice = 0;
        for(int i = 0; i < test.size(); i++) //iterate through every element in the arraylist
        {
            current = test.get(i); //set the current to the entry at indice i
            if(i == 0) //if the first entry create a node at indice 0 of the array
            {
                pathSet[0] = new Node(current);
                pathSet[0].setTail(pathSet[0]); //the tail is the first entry
            }
            else //if not the first entry
            {
                if(current > previous) //if the current value is greater than the previous value
                {
                    for(int j = 0; j < indice; j++) //iterate through every entry thats in the array so far
                    {
                        Node temp = new Node(current); //temp is a node with the current number
                        pathSet[j].getTail().setNext(temp); //set the tails next to temp
                        pathSet[j].setTail(temp); //set the tail to temp because it is the end
                        pathSet[j].addWeight(); //add one to the weight of the base node
                    }
                }
                else //if the previous is more than the current
                {
                    int loss = newWeight(indice, current); //call newWeight, send indice and current
                    Node temp = new Node(current); // node temp is the new node with the key of the current value
                    pathSet[indice++] = temp; //put temp in the next available space in the array
                    temp.setWeight(loss); // set the weight of this temp node to the weight given from newWeight
                    temp.setTail(temp); // set the tail of this new array entry to temp
                    length++; //increase the length of the node array
                }
            }
            previous = current; //previous is now current
        }
        printLargest(); //print the largest value
    }
    /**
     * printLargest
     * iterate through the node array and find the entry with the highest
     * weight.
     */
    public void printLargest()
    {
        int largest = 0;
        for(int i = 0; i < length--; i++) //iterate through every indice in the array
        {
            if(i == 0) //if it is the first entry in the array set the max weight to the nodes weight
            {
                largest = pathSet[i].getWeight();
            }
            else //if not the first
            {
                if(pathSet[i].getWeight() > largest) //the the weight of this base node total is larger than the largest
                    largest = pathSet[i].getWeight(); //largest is the weight of this node
            }
        }
        System.out.println("Longest increasing sequence in the graph is: " + largest); //print out the largest
    }
    /**
     * 
     * @param indice
     * @param current
     * @return totalloss
     * 
     * takes the indice place in the arraylist and the current value of the node in question
     * returns the weight lost based on how many values are after its correct place in the array
     */
    public int newWeight(int indice, int current)
    {
        int A = indice - 1; //A is the indice before our entry
        int totalloss = 1; //total loss is 1 so far
        while(A > 0) //while A is larger than 0
        {
            if(current > test.get(A)) //if the current is larger than the current entry return the current total loss
                return totalloss;
            totalloss++; //increase totalloss
            A--; //deduct A again
        }
        return totalloss; //if not found return totalloss
    }
}
