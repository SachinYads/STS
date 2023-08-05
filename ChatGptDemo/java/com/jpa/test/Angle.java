package com.jpa.test;

import java.io.FileReader;
import com.opencsv.CSVReader;
public class Angle {
   public static void main(String args[]) throws Exception {
      //Instantiating the CSVReader class
      CSVReader reader = new CSVReader(new FileReader("D://sample.csv"));
      //Reading the contents of the csv file
      StringBuffer buffer = new StringBuffer();
      String line[];
      while ((line = reader.readNext()) != null) {
         for(int i = 0; i<line.length; i++) {
            System.out.print(line[i]+" ");
         }
         System.out.println(" ");
      }
   }
}