/* Programming 1 S1 2023 A3 Final Assessment 30%
   Due date/time: 12/June 9:00 am, submit your zipped .java files on Canvas

   Student Name:  Lucas Ting
   Student ID:    s3934181 
   Higest level attempted:      PA              (PA/CR/DI/HD)

   Java Grocery Shop must be compilable & runnable on command line 
*/
import java.io.*;
import java.util.*;

class A3_P1_2023 {
    public static final int MAX_NUM = 7;
    
    public static void main(String[] args) throws Exception {
        System.out.println("========= Welcome to Java Grocery ========");

        Item[] items = readItems();        
        Order[] orders = readOrders(args[0]);    
    
        System.out.println("Item Details:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getName() + ": " +
                    items[i].getUnitCost() + " " + items[i].getUnitPrice() + " " + items[i].getStock());
        }

        // Display the order details
        System.out.println("============= " + orders.length + " Order(s) =============");
        for (Order order : orders) {
            System.out.println("#" + order.getCustomer());
            int[] orderedItems = order.getOrderedItems();
            for (int i = 0; i < orderedItems.length; i++) {
                int quantity = orderedItems[i];
                if (quantity > 0) {
                    System.out.println((i + 1) + ". " + getItemName(i) + ": " + quantity);
            }
        }
        System.out.println();
    }
}   // End of main()
    
    // The method to read items from items.txt, returns an array of items
    // There are always 7 items, only 7 items on the file, from Apple to Grapes
    public static Item[] readItems() throws Exception {
        Item[] itemList = new Item[MAX_NUM];          // The array of items 
        int count = 0;
        Scanner input = null;
        
        try {
            input = new Scanner(new File("items.txt"));
        } catch (Exception e) {
            System.out.println("Item file items.txt is missing or unreadable!");
            System.exit(0);
        }
        
        while(input != null && input.hasNext()){      // Read items line by line
            String itemName = input.next();
            Double cost = input.nextDouble();
            Double price = input.nextDouble();
            int quantity = input.nextInt();

            try {
                Item item = new Item(itemName, cost, price, quantity);
                item.validateItem();
                itemList[count++] = item;
            } catch (InvalidItemException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        input.close();                                // Close the file and
        return Arrays.copyOf(itemList, count);         // Return the filtered item list
            // Create an Item object and add to the list
            //itemList[count++] = new Item(itemName, cost, price, quantity);  
        }
        
       // End of readItems()
    
       private static String getItemName(int index) {
        try {
            File file = new File("items.txt");
            Scanner scanner = new Scanner(file);
    
            for (int i = 0; i < index; i++) {
                scanner.nextLine(); // Skip lines until reaching the desired index
            }
    
            String itemName = scanner.next();
            scanner.close();
            return itemName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    // The method to read orders from the given file, returns an array of orders
    public static Order[] readOrders(String orderFile) throws Exception {
        int[] orderedItems = new int[MAX_NUM];        // The array of items for EACH order
        int count = 0;
        Scanner input = null;
        
        try {
            input = new Scanner(new File(orderFile));
        } catch (Exception e) {
            System.out.println("Order file " + orderFile + " is missing or unreadable!");
            System.exit(0);
        }
        
        // Read the first line, which is always the total number of orders in the file
        int numOfOrders = Integer.parseInt(input.nextLine());
        
        Order[] orderList = new Order[numOfOrders];   // Prepare the array for orders accordingly
        
        while(input != null && input.hasNext()){      // Read orders line by line
                                                      // each line is an order
            String customer = input.next();           // Read the customer name

            for (int i = 0; i < MAX_NUM; i ++)        // Read the quantity for each 
                orderedItems[i] = input.nextInt();    // item on that order
            
            // MAKE A COPY of the item array.  No copy no reading!!
            int[] copiedList = Arrays.copyOf(orderedItems, orderedItems.length);  
            
            // add the order into the list
            orderList[count++] = new Order(customer, copiedList);                                                                         
        }
        
        input.close();                                // Close the file and
        return orderList;                             // return the order list
        
    }   // End of readOrders()
}   // End of class A3_P1_2023