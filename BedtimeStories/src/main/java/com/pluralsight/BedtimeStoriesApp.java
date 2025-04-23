package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStoriesApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //ask user what story
        System.out.println("Enter the name of the story: ");
        //stores user input in variable bedtimeStory
        String bedtimeStory = userInput.nextLine();

        try {
            //opens file and passes it to scanner
            FileInputStream stories = new FileInputStream("src/main/resources/" + bedtimeStory);
            //
            Scanner fileScanner = new Scanner(stories);

            int lineNumber = 1;
            while(fileScanner.hasNextLine()) {
                System.out.println(lineNumber + ": " + fileScanner.nextLine());
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found buddy.");
        }

    }
}
