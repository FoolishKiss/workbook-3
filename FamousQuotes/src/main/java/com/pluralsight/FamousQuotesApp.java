package com.pluralsight;

import java.util.Scanner;

public class FamousQuotesApp {
    public static void main(String[] args) {
        //list of quotes
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
        //user inputs
        Scanner userInput = new Scanner(System.in);
        //runs while loop for app
        boolean appOn = true;


        System.out.println("Welcome to Famous Quotes!");

        //loop to keep the app going until user exits
        while (appOn) {
            try {
                //ask user to pick a number
                System.out.println("Enter a number between 1 and 10 ( or 0 for random quote):");
                //stores users input in variable userChoice as int
                int userChoice = userInput.nextInt();
                //eats character leftover
                userInput.nextLine();

                //if user picks 0 it generates random quote by index
                if (userChoice == 0) {
                    int randomIndex = (int)(Math.random() * quotes.length);
                    System.out.println("Random quote: ");
                    System.out.println(quotes[randomIndex]);
                } else {
                    int quoteIndex = userChoice - 1;
                    System.out.println("Here's your quote:");
                    System.out.println(quotes[quoteIndex]);
                }
            } catch (Exception e) {
                System.out.println("\nThat number was out of range or not valid. (Please enter number between 0-10)\n");
                userInput.nextLine();
            }

            System.out.println("Want another quote? (yes/no): ");
            String answer = userInput.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                appOn = false;
            }


        }

        System.out.println("Thanks, see you later!");

    }

}
