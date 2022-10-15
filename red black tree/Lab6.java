/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lukasbernard
 * I wrote this main from scratch using parts of my previous program 1 from a few weeks ago
 */
public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        RedBlackTree rbt = new RedBlackTree(); //declare a new red black tree
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/lukasbernard/NetBeansProjects/Lab6/src/lab6/inrbt.txt"))) //start a new buffered reader
        {            
            String line; //set the line to null
            String[] contents;//array for the contents of each line
            while((line = br.readLine()) != null) //read lines until there are no lines left to read
            {
                    String value = null; //set the type to null
                    String key = null; //sets the key to null
                    line = line.replace(";",""); //replaces the semicolon with nothing
                    contents = line.split(" "); //split the line into an array by the delimiter
                    if(contents.length == 2) //if there are only 2 parts to the array
                    {
                        value = contents[0];
                        key = contents[1];
                        if(value.equals("float")) //if the value is "float" 
                        {
                            value = value + " 0.0 "; //set the value to string "float 0.0"
                        }
                        else if(value.equals("int")) //if the value is "int"
                        {
                            value = value + " 0 "; //add "0" to the value
                        }
                        
                    }
                    else if(contents.length == 3) //if the array is 3 long
                    {
                        key = contents[0];
                        value = contents[2];
                        try //try to see if it is an int
                        {
                            Integer.parseInt(contents[2]); //if it parses as an integer it is an integer
                            value = "int " + value; //if it is an int add int in front of the value
                        }
                        catch(NumberFormatException e) //if it is not an int it must be a float
                        {
                            Float.parseFloat(contents[2]); //if it is a parsable as a float it will be a float
                            value = "float " + value;
                        }    
                    }
                    rbt.put(key, value); //put the key value pairs into the red black tree
            }
            br.close(); //close the buffered reader file
            
        }
        catch(IOException e) //if the file is not found print out that it was not found
        {
            System.out.println("No file under this name was found.");
        }
        rbt.keys(); //call the keys function to print
        
    }
    
}
