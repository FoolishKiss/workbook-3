package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PayrollCalculatorApp {
    public static void main(String[] args) {
        try {

            //here is the file name
            String fileName = "employees.csv";

            FileReader theFile = new FileReader("src/main/resources/" + fileName);
            BufferedReader reader = new BufferedReader(theFile);

            String theLine;
            //removes header row
            reader.readLine();
            while ((theLine = reader.readLine()) !=null) {
                //splits the line by the |
                String[] parts = theLine.split("\\|");

                //
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                //builds the employee
                Employee employee = new Employee(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                System.out.printf("the employee id is: %d, the employee name is %s, the employee gross pay is $%.2f\n", employee.getEmployeeID(), employee.getName(), employee.getGrossPay());

            }

        } catch (IOException e) {
            System.out.println();
            throw new RuntimeException(e);
        }

    }
}
