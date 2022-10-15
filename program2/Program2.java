/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.pkg2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/**
 *
 * @author lukasbernard
 * This main function is written by me
 */
public class Program2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //open the filepaths for our three csv files
        File co = new File("/Users/lukasbernard/NetBeansProjects/Program 2/src/program/pkg2/co2.csv");
        File temper = new File("/Users/lukasbernard/NetBeansProjects/Program 2/src/program/pkg2/temperature_anomaly.csv");
        File sea = new File("/Users/lukasbernard/NetBeansProjects/Program 2/src/program/pkg2/sea_level.csv");
        
        
        //create scanners for each file
        Scanner scanco;
        Scanner scantemp;
        Scanner scansea; 
        //create 3 red black trees for CO2, Temp, and Sea levels
        RedBlackTree rbtCo = new RedBlackTree();
        RedBlackTree rbtTemp = new RedBlackTree();
        RedBlackTree rbtSea = new RedBlackTree();
        
        try //try to open the files with a scanner
        {
            scanco = new Scanner(co);
            scantemp = new Scanner(temper);
            scansea = new Scanner(sea);
            //I want to start on line 2
            scanco.next();
            scantemp.next();
            scansea.next();
            while(scantemp.hasNext()) //while there is a next line to scan
            {
                String entry = scantemp.next(); //scan in the line
                String[] val = entry.split(","); //split the line over the comma
                String date;
                float key;
                if(val[0].equals("World")) //to check if this is world data
                {
                    if(val[2].contains("-")) //to see if the date format needs changing
                    {
                        String da = val[2]; //get the date
                        String[] d = da.split("-"); //split the date into an array
                        String year = d[0]; //get the year date and month
                        String month = d[1];
                        String day = d[2];
                        date = month + "/" + day + "/" + year; //add the year date and month to the new date format
                    }
                    else
                    {
                        String[] da = val[2].split("/");
                        if(da[0].length() == 1)
                            da[0] = "0" + da[0];
                        date = da[0] + "/" + da[1] + "/" + da[2];
                    }
                    key = (Float.parseFloat(val[3])*(float)1.8); // convert the temp to farenheit
                    rbtTemp.put(key, date); //insert the temp and date to red black tree
                }
            }
            while(scanco.hasNext()) //while there is a next line
            {
                String entry = scanco.next();
                String[] val = entry.split(","); //split the entry string
                String[] da = val[2].split("/");
                if(da[0].length() == 1)
                    da[0] = "0" + da[0];
                String date = da[0] + "/" + da[1] + "/" + da[2];
                rbtCo.put(Float.parseFloat(val[3]), date); //insert the co2 level and date after converting to float
            }
            while(scansea.hasNext()) //while the sea file has a next line
            {
                String[] val = scansea.next().split(","); //split the line into a string array
                String date;
                if(val[2].contains("-")) //convert the date if it contains -
                {
                        String da = val[2];
                        String[] d = da.split("-");
                        String year = d[0]; //once I get the year month and day, add them correctly to date string
                        String month = d[1];
                        String day = d[2];
                        date = month + "/" + day + "/" + year;
                }
                else //if the date is already correct
                {
                    String[] da = val[2].split("/");
                    if(da[0].length() == 1)
                        da[0] = "0" + da[0];
                    date = da[0] + "/" + da[1] + "/" + da[2];
                }
                rbtSea.put(Float.parseFloat(val[3]), date); //convert the sea level to float and insert with date into rbt
            }
        }
        catch(FileNotFoundException e) //if a file is not found
        {
            System.out.println("One or more files were not found.");
        }
        
        //node values to store the highest and lowest values of each tree
        
        Node lowSea = rbtSea.lowestVal();
        Node highSea = rbtSea.highestVal();
        Node lowTemp = rbtTemp.lowestVal();
        Node highTemp = rbtTemp.highestVal();
        Node lowCo = rbtCo.lowestVal();
        Node highCo = rbtCo.highestVal();
        
        //nodes to store the sameday values
        Node sSea;
        Node sCO;
        Node sTemp;
        
        PrintStream fout; //declare a printstream  fout
        try
        {
            fout = new PrintStream(new FileOutputStream("p2output.txt")); //try to open the printstream file
            
            /**
             * basic format over next lines is repeated so I'll describe each aspect once here
             * fout.println the lowest and highest into the file
             * find and assign the key of the same date in other red black trees
             * check if these same day nodes are null, if not add their keys to the file
             * print an empty line, repeat
             */
            
            fout.println("Lowest temperature anomaly (F): " + lowTemp.key() + " on " + lowTemp.value());
            sSea = rbtSea.sameDay(lowTemp.value());
            sCO = rbtCo.sameDay(lowTemp.value());
            if(sCO != null)
                fout.println("On that same date, the Average CO2 concentration was " + sCO.key());
            if(sSea != null)
                fout.println("On that same date, the Sea Level Rise was " + sSea.key());
            fout.println();
            fout.println("Highest temperature anomaly (F): " + highTemp.key() + " on " + highTemp.value());
            sSea = rbtSea.sameDay(highTemp.value());
            sCO = rbtCo.sameDay(highTemp.value());
            if(sCO != null)
                fout.println("On that same date, the Average CO2 concentration was " + sCO.key());
            if(sSea != null)
                fout.println("On that same date, the Sea Level Rise was " + sSea.key());
            fout.println();
            fout.println("Lowest Sea Level Rise: " + lowSea.key() + " on " + lowSea.value());
            sTemp = rbtTemp.sameDay(lowSea.value());
            sCO = rbtCo.sameDay(lowSea.value());
            if(sCO != null)
                fout.println("On that same date, the Average CO2 concentration was " + sCO.key());
            if(sTemp != null)
                fout.println("On that same date, the Temperature Anomaly (F) was " + sTemp.key());
            fout.println();
            fout.println("Highest Sea Level Rise: " + highSea.key() + " on " + highSea.value());
            sTemp = rbtTemp.sameDay(highSea.value());
            sCO = rbtCo.sameDay(highSea.value());
            if(sCO != null)
                fout.println("On that same date, the Average CO2 concentration was " + sCO.key());
            if(sTemp != null)
                fout.println("On that same date, the Temperature Anomaly (F) was " + sTemp.key());
            fout.println();
            fout.println("Lowest Average CO2 concentration: " + lowCo.key() + " on " + lowCo.value());
            sTemp = rbtTemp.sameDay(lowCo.value());
            sSea = rbtSea.sameDay(lowCo.value());
            if(sSea != null)
                fout.println("On that same date, the Sea Level Rise was " + sSea.key());
            if(sTemp != null)
                fout.println("On that same date, the Temperature Anomaly (F) was " + sTemp.key());
            fout.println();
            fout.println("Highest Average CO2 concentration: " + highCo.key() + " on " + highCo.value());
            sTemp = rbtTemp.sameDay(highCo.value());
            sSea = rbtSea.sameDay(highCo.value());
            if(sSea != null)
                fout.println("On that same date, the Sea Level Rise was " + sSea.key());
            if(sTemp != null)
                fout.println("On that same date, the Temperature Anomaly (F) was " + sTemp.key());
            
            fout.close(); //close the file stream
        }
        catch(IOException fo) //if there is an output exception state the output exception
        {
            System.out.println(fo);
        }
        
    }
    
}
