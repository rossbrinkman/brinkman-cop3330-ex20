package org.example;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ross Brinkman
 */

public class App 
{
    public static void main( String[] args )
    {
        DecimalFormat f = new DecimalFormat("#0.00");
        Scanner scanner = new Scanner(System.in);
        float orderAmount, taxRate = 0, totalTax, total;
        String state, county;

        System.out.println( "What is the order amount? " );

        while (true) {
            try {
                orderAmount = scanner.nextFloat();
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Must be a number: ");
                scanner.next();
            }
        }

        System.out.println( "What State do you live in? " );
        scanner.next();
        state = scanner.nextLine();
        state = state.toUpperCase();

        switch(state)
        {
            case "WISCONSIN":
                taxRate = .05f;
                System.out.println( "What County do you live in? " );
                county = scanner.nextLine();
                county = county.toUpperCase();
                switch (county){
                    case "Eau Claire":
                        taxRate += .005f;
                        break;
                    case "Dunn":
                        taxRate += .004f;
                        break;
                }
            case "ILLINOIS":
                taxRate = .08f;
                break;
            default:
                System.out.println(" sdfgsgfdh" );
                break;
        }

        totalTax = taxRate * orderAmount;
        total = orderAmount + totalTax;
        System.out.println( "The tax is $" + f.format(totalTax) + "\n" +
                "The total is $" + f.format(total));

        scanner.close();
    }
}
