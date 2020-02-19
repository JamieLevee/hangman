import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
public class Hangman
{
    public static void main(String[] args) throws InterruptedException  {
        System.out.println('\u000C');
        System.out.println("Welcome to Hangman! Enter in a word:");
        Scanner word = new Scanner(System.in);
        String phrase = word.nextLine();
        //sets the string phrase to the scanner
        phrase = phrase.toLowerCase();
        //sets phrase to lowercase
        String underline = "";
        //sets the string underline to an empty character 
        //so that we can set it as a space or an underline
        int count = 0;
        //count is set to zero so we can add to it
        for (int i = 0; i < phrase.length(); i++ )
        {
            if (phrase.charAt(i) == ' ')
            {
                underline += " ";
            }
            else  if (phrase.charAt(i) == '-')
            {
                underline += "-";
            }
            else if (phrase.charAt(i) == '.')
            {
                underline += ".";
            }
            else
            {
                underline += "_";
            }
        }
        char[] under = underline.toCharArray();
        //sets the underline string to an array
        //so we can be accurate with its spaces
        System.out.println('\u000C');
        //clear
        delayDots(3);
        System.out.println(underline);
        while (check(under) && count < 7)
        {
            //while the under array has not been fully printed and
            //the count is less than 7....

            System.out.println("Enter in a char:");
            Scanner input = new Scanner(System.in);
            String guess = input.next().toLowerCase();
            boolean right = false;

            for (int i = 0; i < phrase.length(); i++ )
            {
                //a for loop that goes through the entire phrase
                if (guess.charAt(0) == phrase.charAt(i))
                {
                    right = true;
                    under[i] = phrase.charAt(i);
                    System.out.println("Correct!");
                } 
                //if our guess's character = a character in phrase,
                //the character we said will replace the correct one(s)
                else if(right == false)
                {
                    System.out.println("Try again!");
                    count++;
                }
                //else, add 1 to count
            }
            System.out.println('\u000C');
            System.out.println(under);
            if (count == 0)
            {
                System.out.println("____|____");
                System.out.println("____|____");
                System.out.println("____O____");
            }
            else if (count == 1)
            {
                System.out.println("____|____");
                System.out.println("____|____");
                System.out.println("___(..)__");
            }
            else if (count == 2)
            {
                System.out.println("____|____");
                System.out.println("____|____");
                System.out.println("__(..)___");
                System.out.println("___||____");
                System.out.println("___||____");
            }
            else if (count == 3)
            {
                System.out.println("____|____");
                System.out.println("____|____");
                System.out.println("__(..)___");
                System.out.println("__/||/___");
                System.out.println("___||____");
            }
            else if (count == 4)
            {
                System.out.println("____|____");
                System.out.println("____|____");
                System.out.println("__(..)___");
                System.out.println("__/||/___");
                System.out.println("___||____");
                System.out.println("___//____");
            }
            else if (count == 5)
            {
                System.out.println("____|____");
                System.out.println("____|____");
                System.out.println("__(oo)___");
                System.out.println("__/||/___");
                System.out.println("___||____");
                System.out.println("___//____");
            }
            else if (count == 6)
            {
                System.out.println("____|____");
                System.out.println("____|____");
                System.out.println("__(XX)___");
                System.out.println("__||||___");
                System.out.println("___||____");
                System.out.println("__|__|___");
            }
        }  
        if (count > 6)
        {
            System.out.println("The answer was...");
            delayDots(3);
            System.out.println(phrase + "!");
        }
        if (check(under) == false)
        {
            System.out.println("You win!");
        }
    }
    public static void delayDots(int dotAmount) throws InterruptedException
    {
        for (int i=0; i<dotAmount; i++)  {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }
        System.out.println();
    }
    public static boolean check(char [] u)
    {
        for (char c: u)
        {
            if (c == '_')
            {
                return true;
                //checking if a _ char is there, and if so, continue
            }
        }
        return false;
        //else, you may NOT continue
    }
}