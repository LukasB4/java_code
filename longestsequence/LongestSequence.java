/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsequence;

/**
 *
 * @author lukasbernard
 * I wrote this code from scratch myself
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LongestSequence
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner fin; //declare a new scanner
        longSet lS = new longSet(); //declare a new longSet lS
        try
        {
            fin = new Scanner(new File("/Users/lukasbernard/NetBeansProjects/LongestSequence/src/longestsequence/lab10in.txt")); //try to open the file with scanner
            while(fin.hasNext()) //while the file has a next
            {
                int size = fin.nextInt(); //the size is the lone number
                int[] numSet = new int[size]; //make a new number set of size size
                for(int i = 0; i < size; i++) //iterate i through each number smaller than the size
                {
                    numSet[i] = fin.nextInt(); //add to the numset the next int
                }
                lS.getLongest(numSet, size); //call getLongest, pass in the set and size
            }
            fin.close(); //close the scanner
        }
        catch(IOException e) //catch an IOexception and print it
        {
            System.err.println(e);
        }
    }
    
}
