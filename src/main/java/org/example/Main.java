package org.example;                    // Oct 2023
// Demonstrates: Reading from CSV Text File using Scanner and String.split()
//
// A Comma Separated Values (CSV) file is a file with text only data, where each field item (token)
// is separated by a comma. It can be created in an Excel spreadsheet, and saved as type .CSV.
// Each line of data in the file represents the record of one student. (One per row)
// We read each line into a String and then split the line into individual tokens/fields, and
// add each field value as an element into a String array (called data below)
//
// Finally, we access each String token in the array using the appropriate getter to
// parse it into the correct data type and assign it to a variable.
// (String), int or double, as required.

import java.io. * ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fileName = "studentDataCSV.csv"; // file should be in the project (below pom.xml)

        // Format of each row of data is:
        // Name,Age,Height(m),GPA  - these heading names are included as the first row in file
        // John Malone,20,1.78,3.55   for example

        // Use a Regular Expression to set both comma and newline as delimiters.
        //  sc.useDelimiter("[,\\r\\n]+");
        // Text files in windows have lines ending with "CR-LF" or "\r\n" sequences.
        // or may have only a newline - "\n"
        try (Scanner sc = new Scanner(new File("studentDataCSV.csv"))
                .useDelimiter("[,\\r\\n]+"))
        {

            // skip past the first line, as it has field names (not data)
            if(sc.hasNextLine())
               sc.nextLine();   // read the header line containing column titles, but don't use it

            // while there is a next token to read....
            while (sc.hasNext())
            {
                String name = sc.next();    // read name
                int age = sc.nextInt();     // read age and convert into int
                double height = sc.nextDouble();    // read height and convert to double
                double gpa = sc.nextDouble();

                // Print out the row of field values using format specifiers
                System.out.printf("%-20s %5d %5.2f %5.2f %n",name,age,height,gpa);
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }
    }
}