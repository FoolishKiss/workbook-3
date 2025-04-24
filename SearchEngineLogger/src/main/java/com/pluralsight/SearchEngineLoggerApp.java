package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLoggerApp {

    //create pattern/formatter for time stamp format
    static DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        //logs launch to logs.txt
        logAction("Launch");

        boolean appOn = true;
       //starts loop to repeat question
        while (appOn) {

            //ask user to search or exit and stores it in userResponse
            System.out.println("Enter something to search (or X to exit): ");
            String userResponse = userInput.nextLine();

            //if user presses x or X it exits app, sets appOn to false, and logs to logs.txt
            if (userResponse.equalsIgnoreCase("X")) {
                logAction("Exit");
                System.out.println("Exiting App");
                appOn = false;

            //else whatever user searches gets logged to logs.txt
            } else {
                logAction("Searched " + userResponse);
                System.out.println("\nYou searched for: " + userResponse + "\n");
            }

        }
        userInput.close();

    }

    //the method that will create and maintain our log fle
    public static void logAction(String theAction) {

        //allow us to try and write to the file
        try{

            //create a file writer and set append to true so it adds to the file
            FileWriter logFile = new FileWriter("src/main/resources/logs.txt", true);
            //create the buffered writer to write to the log file
            BufferedWriter bufWriter = new BufferedWriter(logFile);

            //create a date and time
            LocalDateTime timeStamp = LocalDateTime.now();
            //create the line to write to the log file buy concatting the time stamp in the correct format a space and the action
            bufWriter.write(timeStamp.format(timeStampFormatter) + " " + theAction);
            //space between lines
            bufWriter.newLine();
            //closes the buffered writer
            bufWriter.close();

        } catch (Exception e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

}
