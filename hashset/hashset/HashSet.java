/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author lukasbernard
 * I wrote this main function myself
 */
public class HashSet 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        hash hs = new hash(); //declare a new instance of hashset
        try(Scanner scan = new Scanner(new File("/Users/lukasbernard/NetBeansProjects/hashSet/src/hashset/inhash.txt"))) //try to open the file
        {
            while(scan.hasNextLine()) //read through all the lines one by one
            {
                String line = scan.nextLine();
                Boolean unique = hs.add(line); //sends the line, returns true if all unique, false if duplicate
                if(!unique) //if unique returns false
                {
                    System.out.println(line + " has duplicate characters.");
                }
                else //if unique returns true
                {
                    System.out.println(line + " has all unique characters.");
                }
            }
        }
        catch(FileNotFoundException e) //if the file is not found
        {
            System.out.println("File was not found");
        }
    }
    
}
