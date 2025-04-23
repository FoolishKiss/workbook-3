package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PayrollCalculatorApp {
    public static void main(String[] args) {
        //starts scanner to get user input
        Scanner userInput = new Scanner(System.in);
        //creates list of employees
        List<Employee> employees = new ArrayList<>();
        try {
             //ask user for name of file
            System.out.println("Enter name of the file to read: ");
            //here is the file name
            String fileName = userInput.nextLine();

            //brings file into app to read
            FileReader theFile = new FileReader("src/main/resources/" + fileName);
            BufferedReader reader = new BufferedReader(theFile);

            //string variable used to hold the unsplit parts of the file
            String theLine;

            //removes header row
            reader.readLine();
            //loop through the file
            while ((theLine = reader.readLine()) !=null) {
                //splits the line by the |
                String[] parts = theLine.split("\\|");

                //the line parts
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                //builds the employee
                Employee employee = new Employee(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                employees.add(employee);
                System.out.printf("ID: %d - Name: %s - Gross Pay: $%.2f\n", employee.getEmployeeID(), employee.getName(), employee.getGrossPay());

            }
            //closes buffer reader
            reader.close();

            //ask user if they want to create a new file
            System.out.println("\n Enter name of file to create");
            String createdFile = userInput.nextLine();
            //starts
            FileWriter writer = new FileWriter(createdFile);

            writer.write("id|name|gross pay\n");
            //loops through list and prints out in formated string
            for (Employee e : employees) {
                writer.write(String.format("%d|%s|%.2f\n", e.getEmployeeID(), e.getName(), e.getGrossPay()));
            }
            //stops the file writer
            writer.close();
            //tells user they created a file
            System.out.println("Payroll file written to: " + createdFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            System.out.println("invalid number format in file");
        }

    }
}
