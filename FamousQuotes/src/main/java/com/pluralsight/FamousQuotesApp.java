package com.pluralsight;

import java.util.Scanner;

public class FamousQuotesApp {
    public static void main(String[] args) {
        String[] quotes = {
                "You have power over your mind—not outside events. Realize this, and you will find strength.",
                "The impediment to action advances action. What stands in the way becomes the way.",
                "Difficulties strengthen the mind, as labor does the body.",
                "True happiness is... to enjoy the present, without anxious dependence upon the future.",
                "It is not the man who has too little, but the man who craves more, that is poor.",
                "We are more often frightened than hurt; and we suffer more from imagination than from reality.",
                "Waste no more time arguing what a good man should be. Be one.",
                "If you want to improve, be content to be thought foolish and stupid.",
                "We cannot choose our external circumstances, but we can always choose how we respond to them.",
                "The whole future lies in uncertainty: live immediately."
        };
        Scanner userInput = new Scanner(System.in);


        System.out.println("Welcome to Famous Quotes!");
        System.out.println("Enter a number between 1 and 10");


        try {
            int userChoice = userInput.nextInt();
            int quoteIndex = userChoice - 1;
            System.out.println("Here's your quote:");
            System.out.println(quotes[quoteIndex]);
        } catch (Exception e) {
            System.out.println("That number was out of range or not valid.");

        }


    }

}
