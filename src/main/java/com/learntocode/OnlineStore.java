package com.learntocode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) {

        // create new ArrayList to pass product file
        ArrayList<Product> inventory = getInventory();
        // create cart array to hold the items for purchase and to hold duplicates
        ArrayList<Product> cart = new ArrayList<>();


        Scanner myScanner =  new Scanner(System.in);
        int choice = -1;

        // create Home Screen
        while(choice != 3) {
            // Display Menu for HomeScreen
            System.out.println("----------------------------------");
            System.out.println("The Store Home Screen");
            System.out.println("----------------------------------");
            System.out.println(" ");
            System.out.println("1 - Show Products");
            System.out.println("2 - Show Cart");
            System.out.println("3 - [Exit] - close out of application ");
            System.out.println("----------------------------------");
            System.out.println("");
            System.out.println("Enter your choice (1-3) : ");
            choice = myScanner.nextInt();
            myScanner.nextLine(); // eating a line

            // create a switch in order to take care of choices from Home Screen
            switch (choice) {
                case 1:
                    // display the products that we sell
                    displayProducts(inventory);
                    // add item to cart/go back home method
                    addToCart(inventory,myScanner);
                    break;
                case 2:
                    // show cart method as the big feature/prompts if user wants to check out or go back to home screen
                    // SHOW CART - displays list of items and total amount of cart



                    break;
                case 3:
                    System.out.println("Thank You! Exiting application!"); // exit message - 3 will end loop
                    break;
                default:
                    System.out.println("Entered wrong choice! Please enter number from 1-3 "); // in case user enters wrong choice
                    break;
            }
        }
    }

    // create a method to get the inventory from the saved file
    private static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        String line;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            while ((line = reader.readLine()) != null ) {
                String[] parts = line.split("\\|");
                String Id = parts[0];
                String Name = parts[1];
                float Price = Float.parseFloat(parts[2]);
                inventory.add(new Product(Id, Name, Price));
            }
        } catch(Exception e) {
            System.out.println("Exception Found!");
            e.printStackTrace();
        }
        return inventory;
    }

    // create new method for display of products we sell
    private static void displayProducts(ArrayList<Product> inventory) {
        // create for loop to iterate through array
        for (Product product : inventory) {
            System.out.printf("Id: %s - Name: %s - Price: $%.2f%n",
                    product.getId(), product.getName(), product.getPrice());
        }
    }

    // method to add items to cart
    private static void addToCart(ArrayList<Product> inventory, Scanner myScanner) {
        // user to enter product ID to add to cart or (X) to go back to home screen
        System.out.println("----------------------------------");
        System.out.println("Enter the product Id to add to cart or [X] to go back to Home Screen:  ");
        String productId = myScanner.nextLine();
        if (productId.equalsIgnoreCase("X")) { // exit back to home screen
            return;
        } else { // use id to add to cart
           for (Product product : inventory) {
               ArrayList<Product> cart = new ArrayList<>();
               cart.add(product);
               System.out.println(product + "has been added to the cart!");
           }
        }
    }

    private static void showCart(ArrayList<Product> cart) {
        // iterate through the arrayList and display all items
        for (Product product : cart) {
            System.out.printf("Id: %s - Name: %s - Price: $%.2f%n",
                    product.getId(), product.getName(), product.getPrice());
            // get total amount of cart
            int sum = 0;
            while (product != null) {
                sum += product.getPrice();
                System.out.println(sum);
            }
        }
    }

    private static void checkOut(ArrayList<Product> cart, Scanner myScanner){
        // ask user if they want to check out or go back to home screen
        System.out.println("----------------------------------");
        System.out.println("Do you want to Check Out (C) or go back to Home Screen (X): ");
        String choice = myScanner.nextLine();
        if (choice.equalsIgnoreCase("X")) { // exit back to home screen
            return;





        }
    }






}
