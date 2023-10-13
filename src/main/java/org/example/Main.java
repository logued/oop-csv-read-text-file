package org.example;                    // Oct 2023
// Demonstrates: Reading from CSV Text File using Scanner and String.split()
//
// A Comma Separated Values (CSV) file is a file with text only data, where each field item (token)
// is separated by a comma. It can be created in an Excel spreadsheet, and saved as type .CSV.
// Each line of data in the file represents the record of one student. (One per row)
// We read each line into a String and extract each token into a String array using String.split().
// Finally, we convert each String in the array into its correct type: (String), int or double, as required.

import java.io. * ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fileName = "studentDataCSV.csv"; // file should be in the project (below pom.xml)

        // Format of each row of data is:
        // Name,Age,Height(m),GPA  - these heading names are included as the first row in file
        // Ali G,20,1.78,3.55   for example

        try (Scanner sc = new Scanner(new File("studentDataCSV.csv")))
        {
            if(sc.hasNextLine())
               sc.nextLine();   // read the header line containing column titles, but don't use it

            // read one line at a time into a String, and parse the String into tokens (parts)
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();             // read full line ( ending with a "\n" )
                String [] data = line.split(",");  // split string using a comma as the delimiter (separator)

                String name = data[0];  // extract first token/data from the string array (i.e. the name)
                int age = Integer.parseInt(data[1]);  // e.g. Convert String "19" to int value 19
                double height = Double.parseDouble(data[2]);  // e.g. Convert String "1.82" to double 1.82
                double gpa = Double.parseDouble(data[3]);

                // Print out the row of data using format specifiers
                System.out.printf("%-20s %5d %5.2f %5.2f %n",name,age,height,gpa);
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }
    }
}