/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author lukasbernard
 */
public class FileOut 
{
    private PrintStream fout; //opens a printstream
    
    FileOut() //constructor for fout new printstream to outputfile.txt
    {
        try //try to open a new file
        {
            fout = new PrintStream ( new FileOutputStream("outputfile.txt"));
        }
        catch(IOException fo) //if file cant be open print cannot print
        {
            System.out.println("Cannot print"); 
        }
    }

    public void writer(String out) //prints out the string and then new line
    {

         fout.println(out + " ");

    }
}
