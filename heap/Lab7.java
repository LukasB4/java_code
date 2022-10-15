/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
/**
 *
 * @author lukasbernard
 * this main code is written by myself
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayList<String> book = new ArrayList<String>(); //declare a new array list
        Heap heap = new Heap(); //declare a new heap
        //try to open the file and catch an exception if it doesnt open
        try(Scanner scan = new Scanner(new File("/Users/lukasbernard/NetBeansProjects/Lab7/src/lab7/tale.txt")))//start a new buffered reader
        {      
            while(scan.hasNext()) //while there exists a next String
            {
                String word = scan.next(); //the next word is scanned in 
                if(!book.contains(word)) //if the arraylist does not contain the word add it to the arraylist
                {
                    book.add(word);
                }
                
            }
            scan.close(); //close the scanner
        }
        catch(FileNotFoundException e) //for if no file is found
        {
            System.out.println("No file was found"); //print if there is no file
        }
        String[] thebook = book.toArray(new String[0]); //convert the arraylist to a string array so it can be sent to the function
        heap.sort(thebook); //send the book to the heap sort
    }
    
}
