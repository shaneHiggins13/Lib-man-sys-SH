package com.ait.ui;

import java.util.Scanner;

public class Validator
{
    public static String getString(final Scanner scanner, final String prompt)
    {
        System.out.print(prompt);
        final String string = scanner.next();        // read the first string on the line
        scanner.nextLine();               // discard any other data entered on the line
        return string;
    }

    public static String getLine(Scanner scanner,String prompt)
    {
        System.out.print(prompt);
        String string = scanner.nextLine();        // read the whole line
        return string;
    }

    public static int getInt(Scanner scanner, String prompt)
    {
    	
    	int selection = 0;
        boolean isValid = true; 
       
        while (isValid)
        {
            System.out.print(prompt);
            if (scanner.hasNextInt())
            {
                selection = scanner.nextInt(); 
                isValid = false;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            scanner.nextLine();  // discard any other data entered on the line
        }
        return selection;
    }

    

   

    

}
