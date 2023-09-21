import java.util.Objects;
import java.util.Scanner;

public class OrderList {
    private static Orders[] orderArray;
    private static Orders[] tempOrder;

    private int initialSize;
    private double loadFactor;
    private static int nextIndex;
    private static Orders[] tempArray;

    OrderList(int initialSize, double loadFactor) {
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        nextIndex = 0;
        orderArray = new Orders[initialSize];
        tempArray = new Orders[orderArray.length];
        tempOrder = new Orders[orderArray.length];
    }

    public OrderList() {
    }

    private boolean isEmpty() {
        return nextIndex == 0;
    }

    private boolean isFull() {
        return nextIndex >= orderArray.length;
    }

    public void add(Orders orders) {
        if (!isFull()) {
            orderArray[nextIndex] = orders;
            nextIndex++;
        } else {
            extendArray();
            orderArray[nextIndex] = orders;
            nextIndex++;
        }
    }

    private void extendArray() {
        Orders[] tempArray = new Orders[(int) (initialSize + (initialSize * loadFactor))];
        for (int i = 0; i < nextIndex; i++) {
            tempArray[i] = orderArray[i];
        }
        orderArray = tempArray;
    }

    public void search(String number) {
        if (!isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < nextIndex; i++) {
                String number2 = orderArray[i].phoneNumber;
                if (number.equals(number2)) {
                    System.out.print("Size : " + orderArray[i].size);
                    System.out.print("Qty : " + orderArray[i].qty);
                    System.out.print("Amount : " + orderArray[i].amount);
                    System.out.println("Do you want to search another customer (Y/N) : ");
                    char x = scanner.next().charAt(0);
                    if (x == 'y' || x == 'Y') {
                        Main.searchCustomer();
                    } else {
                        Main.main(null);
                    }
                } else {
                    System.out.println("Wrong input Try again...");
                    search(null);
                }
            }
        }
    }

    public void searchOrder(String id) {
        if (!isEmpty()) {
            for (int i = 0; i < nextIndex; i++) {
                String id1 = orderArray[i].OrderId;
                if (id.equals(id1)) {
                    System.out.println("Phone Number : " + orderArray[i].phoneNumber);
                    System.out.println("Size : " + orderArray[i].size);
                    System.out.println("Qty : " + orderArray[i].qty);
                    System.out.println("Amount : " + orderArray[i].amount);
                    if (orderArray[i].status == 0) {
                        System.out.println("Status : Processing");
                    }
                    if (orderArray[i].status == 1) {
                        System.out.println("Status : Delivering");
                    }
                    if (orderArray[i].status == 2) {
                        System.out.println("Status : Delivered");
                    }
                }else{
                    System.out.println("Invalid ID....");
                }
            }
        }
    }

    public void deleteOrder(String id) {
        if (!isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < nextIndex; i++) {
                if (id.equals(orderArray[i].OrderId)) {
                    System.out.println("Phone Number : "+orderArray[i].phoneNumber);
                    System.out.println("size         : "+orderArray[i].size);
                    System.out.println("Qty          : "+orderArray[i].qty);
                    System.out.println("Amount      : "+orderArray[i].amount);
                    if (orderArray[i].status == 0) {
                        System.out.println("Status : Processing");
                    }
                    if (orderArray[i].status == 1) {
                        System.out.println("Status : Delivering");
                    }
                    if (orderArray[i].status == 2) {
                        System.out.println("Status : Delivered");
                    }

                    System.out.print("Do you want to delete this Order (Y/N) : ");
                    char x = scanner.next().charAt(0);
                    if (x == 'y' || x == 'Y') {
                        for (int j = i; j < nextIndex + 1; j++) {
                            orderArray[j] = orderArray[j + 1];

                        }
                        nextIndex--;
                        System.out.println("Order Deleted ... !");
                    }
                }else {
                    System.out.println("Invalid ID... Try again");
                    Main.deleteOrder();
                }
            }
        }
    }

    public void changeOrderStatus(String id) {
        if (!isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < nextIndex; i++) {
                if (id.equals(orderArray[i].OrderId)) {
                    System.out.println("Phone Number : " + orderArray[i].phoneNumber);
                    System.out.println("Size : " + orderArray[i].size);
                    System.out.println("Qty : " + orderArray[i].qty);
                    System.out.println("Amount : " + orderArray[i].amount);
                    if (orderArray[i].status == 0) {
                        System.out.println("Status : Processing");

                    }
                    if (orderArray[i].status == 1) {
                        System.out.println("Status : Delivering");
                    }
                    if (orderArray[i].status == 2) {
                        System.out.println("Status : Delivered");
                    }
                }else {
                    System.out.println("Invalid ID Try again.... ");
                    Main.changeOrderStatus();
                }
                System.out.print("Do you want to change this order status (Y/N) : ");
                char x = scanner.next().charAt(0);
                if (x == 'y' || x == 'Y') {
                    if (orderArray[i].status == 0) {
                        System.out.println("[1] Order Delivering");
                        System.out.println("[2] Order Delivered");
                        System.out.print("Enter Option : ");
                        int op = scanner.nextInt();
                        if (op == 1) {
                            orderArray[i].status = 1;
                        } else {
                            orderArray[i].status = 2;
                        }
                    } else if (orderArray[i].status == 1) {
                        System.out.println("[1] Order Delivered");
                        int op = scanner.nextInt();
                        if (op == 1) {
                            orderArray[i].status = 2;
                        }
                    } else {
                        System.out.println("Can't change this order status order already delivered....!");
                    }
                }
            }
        }
    }

    public void allOrders() {
        if (!isEmpty()) {
            System.out.println("\t\t+-------------+--------------+--------+----------+---------------+---------------+");
            System.out.printf("\t\t|%-13s|%-14s|%-8s|%-10s|%-15s|%-15s|%n", "  Order ID  ", "  Customer ID ", "  Size  ", "  QTY  ", "   Amount   ", "   Status  ");
            System.out.println("\t\t+-------------+--------------+--------+----------+---------------+---------------+");
            for (int i = 0; i < nextIndex; i++) {
                System.out.println("\t\t|             |              |        |          |               |               |");
                System.out.printf("\t\t|  %-11s|  %-12s|   %-5s|   %-7s|  %-13s|", orderArray[i].OrderId, orderArray[i].phoneNumber, orderArray[i].size.toUpperCase(), orderArray[i].qty, orderArray[i].amount);
                if (orderArray[i].status == 0) {
                    System.out.println(" Processing    |");
                }
                if (orderArray[i].status == 1) {
                    System.out.println(" Delivering    |");
                }
                if (orderArray[i].status == 2) {
                    System.out.println(" Delivered    |");
                }
            }
            System.out.println("   +-----------------------------------------------------------------------------+");
        }
    }

    public void orderByAmount() {
        sortAmount();
        System.out.println("\t\t+-------------+--------------+--------+----------+---------------+---------------+");
        System.out.printf("\t\t|%-13s|%-14s|%-8s|%-10s|%-15s|%-15s|%n", "  Order ID  ", "  Customer ID ", "  Size  ", "  QTY  ", "   Amount   ", "   Status  ");
        System.out.println("\t\t+-------------+--------------+--------+----------+---------------+---------------+");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println("\t\t|             |              |        |          |               |               |");
            System.out.printf("\t\t|  %-11s|  %-12s|   %-5s|   %-7s|  %-13s|", orderArray[i].OrderId, orderArray[i].phoneNumber, orderArray[i].size.toUpperCase(), orderArray[i].qty, orderArray[i].amount);
            if (orderArray[i].status == 0) {
                System.out.println(" Processing    |");
            }
            if (orderArray[i].status == 1) {
                System.out.println(" Delivering    |");
            }
            if (orderArray[i].status == 2) {
                System.out.println(" Delivered    |");
            }
        }
        System.out.println("   +-----------------------------------------------------------------------------+");
    }

    private void sortAmount() {
        for (int j = 0; j < nextIndex; j++) {
            for (int i = j; i < nextIndex - 1; i++) {
                double amount = orderArray[i].amount;
                double amount1 = orderArray[i + 1].amount;
                if (amount < amount1) {
                    tempArray[i] = orderArray[i];
                    orderArray[i] = orderArray[i + 1];
                    orderArray[i + 1] = tempArray[i];
                }
            }
        }
    }

    public void bestInCustomer() {
        sortAmount();
        System.out.println("\t\t\t\t+--------------------+----------+----------------+");
        System.out.printf("\t\t\t\t|%-20s|%-9s|%-16s|%n","   Customer ID ","  All QTY ","  Total Amount  ");
        System.out.println("\t\t\t\t+--------------------+----------+----------------+");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println("\t\t\t\t|                    |          |                |");
            System.out.printf("\t\t\t\t|%-20s|%-10s|%-16s|%n",orderArray[i].phoneNumber," "+ orderArray[i].qty," "+orderArray[i].amount);

        }
        System.out.println("\t\t\t\t+--------------------+----------+----------------+\n\n");
    }
    public void viewCustomer(){
        System.out.println("\t\t\t\t+--------------------+----------+----------------+");
        System.out.printf("\t\t\t\t|%-20s|%-9s|%-16s|%n","   Customer ID ","  All QTY ","  Total Amount  ");
        System.out.println("\t\t\t\t+--------------------+----------+----------------+");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println("\t\t\t\t|                    |          |                |");
            System.out.printf("\t\t\t\t|%-20s|%-10s|%-16s|%n",orderArray[i].phoneNumber," "+ orderArray[i].qty," "+orderArray[i].amount);

        }
        System.out.println("\t\t\t\t+--------------------+----------+----------------+\n\n");
    }

    public void bestSellingSortedByAmount() {
        sortAmount();
        System.out.println("\t\t\t\t+--------------------+---------+----------------+");
        System.out.printf("\t\t\t\t|%-20s|%-9s|%-16s|%n","   Size ","   QTY  ","  Total Amount  ");
        System.out.println("\t\t\t\t+--------------------+---------+----------------+");
        for (int i = 0; i <nextIndex; i++) {
            System.out.println("\t\t\t\t|                    |         |                |");
            System.out.printf("\t\t\t\t|  %-18s|  %-7d|   %-13.0f|%n", orderArray[i].size,orderArray[i].qty,orderArray[i].amount);
        }
        System.out.println("\t\t\t\t+--------------------+---------+----------------+\n\n");
    }

    public void bestSellingSortedByQty() {
        sortByQty();
        System.out.println("\t\t\t\t+--------------------+---------+----------------+");
        System.out.printf("\t\t\t\t|%-20s|%-9s|%-16s|%n","   Size ","   QTY  ","  Total Amount  ");
        System.out.println("\t\t\t\t+--------------------+---------+----------------+");
        for (int i = 0; i <nextIndex; i++) {
            System.out.println("\t\t\t\t|                    |         |                |");
            System.out.printf("\t\t\t\t|  %-18s|  %-7d|   %-13.0f|%n", orderArray[i].size,orderArray[i].qty,orderArray[i].amount);
        }
        System.out.println("\t\t\t\t+--------------------+---------+----------------+\n\n");

    }
    private void sortByQty(){
        for (int j = 0; j <nextIndex ; j++) {
            for (int i = j; i < nextIndex-1; i++) {
                int qty=orderArray[i].qty;
                int qty1=orderArray[i+1].qty;
                if (qty<qty1){
                    tempOrder[i]=orderArray[i];
                    orderArray[i]=orderArray[i+1];
                    orderArray[i+1]=tempOrder[i];
                }
            }
        }
    }
    public void allCustomerReport() {
        System.out.println("\t\t+----------------+-------+-------+-------+-------+-------+-------+---------------+");
        System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%15s  |%n", "Phone Number", "  " + "XS", "  " + "S", "  " + "M", "  " + "L", "  " + "XL", "  " + "XXL", "TOTAL");
        System.out.println("\t\t+----------------+-------+-------+-------+-------+-------+-------+---------------+");
        for (int i = 0; i <nextIndex ; i++) {
            System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%13.2f  |%n",orderArray[i].phoneNumber, "  " + [0], "  " + tempSizes[1], "  " + tempSizes[2], "  " + tempSizes[3], "  " + tempSizes[4], "  " + tempSizes[5], total);
            System.out.println("\t\t+----------------+-------+-------+-------+-------+-------+-------+---------------+");
        }
    }
}
