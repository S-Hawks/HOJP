import java.util.Scanner;

public class Main {

    public static Scanner  scanner = new Scanner(System.in);
    public static GroceryList groceryList = new GroceryList(); //Making list of grocery class.

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstruction();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstruction();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;

            }

        }
    }
    public static void printInstruction(){
        System.out.println("\nPress");
        System.out.println("\t0- To print choice option.");
        System.out.println("\t1- To print the list of grocery item.");
        System.out.println("\t2- To add an item to the list.");
        System.out.println("\t3- To modify an item in the list.");
        System.out.println("\t4- To remove an item form the list.");
        System.out.println("\t5- To search for an item in the list.");
        System.out.println("\t6- To quit the application.");
    }

    public static void addItem(){
        System.out.println("Please enter the grocery item");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem(){
        System.out.println("Current item name: ");
        String itemNo = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }
    public static void removeItem(){
        System.out.println("Enter item number: ");
        String itemNo = scanner.nextLine();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }
    public static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found " + searchItem + " in our grocery list");
        }else{
            System.out.println(searchItem + " is not in the shopping list");
        }
    }
}
