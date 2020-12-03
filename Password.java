/*
 * Josh Bartlett
 * February 21, 2020
 * Assignment 4.1
 * Bellevue University
 * Password.java
 */

import javax.swing.*;
import java.util.Scanner;

public class Password {
    public static void main(String[]args){
        // declare a scanner object
        Scanner input = new Scanner(System.in);
        // declare variables
        String password1 = "", 
               password2 = "";

        char character;

        boolean atLeast6 = false,
                atMost10 = false,
                hasUpper = false,
                hasDigit = false;
        // while loop to check conditions for a strong password and loop until all are met
        while ((atLeast6 == false) || (atMost10 == false) || (hasUpper == false) || (hasDigit == false)){
            // message dialog box to display the conditions for a strong password
            JOptionPane.showMessageDialog(null, "A strong password has:\n" +
                    "\t-At least 6 characters\n" +
                    "\t-At most 10 characters\n" +
                    "\t-At least 1 uppercase letter\n" +
                    "\t-At least 1 digit");
            // use an input dialog box to get a password and save it to password1 variable
            password1 = JOptionPane.showInputDialog("Enter a strong password.");
            // ifs to check the length of password1
            if (password1.length() >= 6) {
                atLeast6 = true;
            }
            if (password1.length() <= 10) {
                atMost10 = true;
            }
            // for loop to go through all characters of password1 and check for an uppercase letter and a digit
            for(int i = 0; i < password1.length(); i++){
                character = password1.charAt(i);
                if (Character.isUpperCase(character)) {
                    hasUpper = true;
                }
                if (Character.isDigit(character)) {
                    hasDigit = true;
                }
            }
            // if all conditions are not met display message dialog box and reset all conditions to false
            if ((atLeast6 == false) || (atMost10 == false) || (hasUpper == false) || (hasDigit == false)){
                JOptionPane.showMessageDialog(null, "Try Again");
                atLeast6 = false;
                atMost10 = false;
                hasUpper = false;
                hasDigit = false;
            }
        }
        // while loop checks password2 against password1 and has the user reenter until they match
        while (!password2.equals(password1)) {
            password2 = JOptionPane.showInputDialog("Reenter password.");
            // if passwords don't match display message dialog box
            if (!password2.equals(password1)){
                JOptionPane.showMessageDialog(null, "Try Again");
            }
        }
    }
}