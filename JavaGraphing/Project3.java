/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author lukasbernard
 * I wrote this main myself
 */
public class Project3
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Integer> blist = new ArrayList<Integer>(10000); //create a new arraylist
        Random r = new Random(); //create a new instance of random
        for(int i = 0; i < 10000; i++) //run 10000 times
        {
            int result = r.nextInt(9999) + 1; //generate a random number between 1 and 10000
            if(!blist.contains(result)) //if the random number is not in the Arraylist add it
            {
                blist.add(result);
            }
        }
        StopWatchCPU swata = new StopWatchCPU(); //start the first timer
        Graph g = new Graph(blist); //call a new instance of the graph
        g.addEdge(); //add the edges
        System.out.println("Graph time is: " + swata.elapsedTime()); //print the elapsed time of first timer
        StopWatchCPU swatb = new StopWatchCPU(); //start a second timer
        longestSeq ls = new longestSeq(); //create a new longest sequence. 
        ls.getLongest(blist, blist.size()); //get the longest sequence in the array dynamically
        System.out.println("Dynamic time is: " + swatb.elapsedTime()); //print out the dynamic time elapsed
    }
    
}
