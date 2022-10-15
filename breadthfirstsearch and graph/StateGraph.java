/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stategraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lukasbernard
 * I wrote this main method myself, similar try catch method to my previous labs
 */
public class StateGraph
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try(Scanner scan = new Scanner(new File("/Users/lukasbernard/NetBeansProjects/StateGraph/src/stategraph/inlab9.txt"))) //try to open the file
        {
            int M = scan.nextInt(); //scan in the size value
            int V = scan.nextInt(); //scans in the vertex value
            GraphingUtility gu = new GraphingUtility(M); //open a new instance of graphin utility class with int m for size
            breadFirstSearch bFS;
            while(scan.hasNext()) //read through all the lines one by one
            {
                String state = scan.next(); //string of the state name
                String borderState = scan.next(); //string of the border state name
                gu.add(state, borderState); //pass both strings into the graphing utility
            }
            bFS = new breadFirstSearch(gu, M); //new declaration for bFS passing in graphing utility and size as parameter
            bFS.search();
        }
        catch(FileNotFoundException e) //if the file is not found
        {
            System.out.println("File was not found");
        }
    }

}
