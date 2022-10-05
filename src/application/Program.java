package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.println("Enter the number of tax payers");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            System.out.println("Tax payer #" + (i+1) + " data: ");
            System.out.println("Individual or Company (i/c)");
            char opc = sc.next().charAt(0);
            sc.nextLine();
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println();
            System.out.println("Anunal Income:");
            double annualIncome = sc.nextDouble();
                if(opc == 'i' || opc == 'I') {
                    System.out.println("Health Expenditures");
                    double expenditures = sc.nextDouble();
                    list.add(new Individual(name, annualIncome, expenditures));
                } else if (opc == 'c') {
                    System.out.println("Number of Employees");
                    int numberOfEmployee = sc.nextInt();
                    list.add(new Company(name, annualIncome, numberOfEmployee));
                }
        }
        double sum = 0.0;
        System.out.println();
        System.out.println("Taxes Paid");
        for (TaxPayer t: list) {
            double tax = t.tax();
            System.out.println(t.getName() + ": " + String.format("%.2f", tax));

            sum += t.tax();
        }
        System.out.printf("Total Taxes $ %.2f%n", sum);

        sc.close();
    }
}

