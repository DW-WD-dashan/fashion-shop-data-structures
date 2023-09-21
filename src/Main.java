import java.util.Scanner;

class Main{
    static int x=0;
    public static final double xs = 600.00;
    public static final double s = 800.00;
    public static final double m = 900.00;
    public static final double l = 1000.00;
    public static final double xl = 1100.00;
    public static final double xxl = 1200.00;
    public static  int processing =0;
    public static  int delivering =1;
    public static  int delivered =2;
    static OrderList order=new OrderList(50,0.5);



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          ");
        System.out.println("\t\t\t\t\t\t\t| $$_____/                | $$      |__/                           /$$__  $$| $$                          ");
        System.out.println("\t\t\t\t\t\t\t| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
        System.out.println("\t\t\t\t\t\t\t| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
        System.out.println("\t\t\t\t\t\t\t| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
        System.out.println("\t\t\t\t\t\t\t| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
        System.out.println("\t\t\t\t\t\t\t| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
        System.out.println("\t\t\t\t\t\t\t|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                | $$      ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                | $$      ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                |__/      ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\t\t\t\t\t\t\t\t\t[1] Place Order");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[2] Search Customer");
        System.out.print("\t\t\t\t\t\t\t\t\t[3] Search order");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[4] View Report");
        System.out.print("\t\t\t\t\t\t\t\t\t[5] Change Order Status");
        System.out.println("\t\t\t\t\t\t\t\t\t\t[6] Delete Order");
        System.out.print("\nEnter Option : ");
        int x = scanner.nextInt();
        switch (x){
            case 1:placeOrder();break;
            case 2: searchCustomer();break;
            case 3:searchOrder();break;
            case 5:changeOrderStatus();break;
            case 4:viewReport();break;
            case 6:deleteOrder();
        }
    }

    private static void placeOrder() {
        System.out.println("  _____  _                   ____          _           \n" +
                " |  __ \\| |                 / __ \\        | |          \n" +
                " | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ \n" +
                " |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|\n" +
                " | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   \n" +
                " |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   \n" +
                "                                                       \n" +
                "                                                       ");
        System.out.println("___________________________________________________");
        Scanner scanner = new Scanner(System.in);
        x++;
        double amount = 0;
        String id = String.format("ODR#%05d", x);
        System.out.println("Enter Order ID : " + id);
        System.out.print("Enter Customer Phone Number : ");
        String phoneNum = scanner.next();
        if (phoneNum.length() == 10 && phoneNum.charAt(0) == '0') {
            System.out.print("Enter T-shirt size (XS/S/M/L/XL/XXL) : ");
            String size = scanner.next();
            System.out.print("Enter Qty : ");
            int qty = scanner.nextInt();
            if (size.equalsIgnoreCase("xs")) {
                amount = qty * xs;
            } else if (size.equalsIgnoreCase("s")) {
                amount = qty * s;
            } else if (size.equalsIgnoreCase("m")) {
                amount = qty * m;
            } else if (size.equalsIgnoreCase("l")) {
                amount = qty * l;
            } else if (size.equalsIgnoreCase("xl")) {
                amount = qty * xl;
            } else if (size.equalsIgnoreCase("xxl")) {
                amount = qty * xxl;
            }
            System.out.println("Amount : " + amount);
            int status = processing;

            order.add(new Orders(id, phoneNum, qty, size, amount, status));
            System.out.print("Do you want to place another Order (Y/N) : ");
            char x=scanner.next().charAt(0);
            if (x=='y'||x=='Y'){
                placeOrder();
            }else {
                main(null);
            }
        }else {
            System.out.println("Wrong phone Number Try again...");
            main(null);
        }
    }
    public static void searchCustomer() {
        System.out.println("  _____                     _        _____          _                            \n" +
                "  / ____|                   | |      / ____|        | |                           \n" +
                " | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ \n" +
                "  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|\n" +
                "  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   \n" +
                " |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   \n" +
                "______________________________________________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Customer Phone Number : ");
        String phoneNum= scanner.next();
        order.search(phoneNum);
    }
    public static void searchOrder(){
        System.out.println("  _____                     _        ____          _           \n" +
                "  / ____|                   | |      / __ \\        | |          \n" +
                " | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ \n" +
                "  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|\n" +
                "  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   \n" +
                " |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_| " +
                "\n_________________________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Order ID : ");
        String id =scanner.next();
        order.searchOrder(id);
        System.out.print("Do you want to search another Order (Y/N): ");
        char x=scanner.next().charAt(0);
        if (x=='y'||x=='Y'){
            searchOrder();
        }else {
            main(null);
        }
    }

    public static void changeOrderStatus(){
        System.out.println("\t\t  ____          _              _____ _        _             ");
        System.out.println("\t\t / __ \\        | |            / ____| |      | |            ");
        System.out.println("\t\t| |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
        System.out.println("\t\t| |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
        System.out.println("\t\t| |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
        System.out.println("\t\t \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
        System.out.println("\t\t____________________________________________________________\n\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Order Id : ");
        String id=scanner.next();
        order.changeOrderStatus(id);
        System.out.print("Do you want to change another Order Status (Y/N) : ");
        char x = scanner.next().charAt(0);
        if (x=='y'||x=='Y'){
            changeOrderStatus();
        }else {
            main(null);
        }
    }
    public static void deleteOrder(){
        System.out.println("\t\t _____       _      _        ____          _           ");
        System.out.println("\t\t|  __ \\     | |    | |      / __ \\        | |       ");
        System.out.println("\t\t| |  | | ___| | ___| |_ ___| |  | |_ __ __| | ___ _ __ ");
        System.out.println("\t\t| |  | |/ _ \\ |/ _ \\ __/ _ \\ |  | | \'__/ _` |/ _ \\ \'__|");
        System.out.println("\t\t| |__| |  __/ |  __/ ||  __/ |__| | | | (_| |  __/ |   ");
        System.out.println("\t\t|_____/ \\___|_|\\___|\\__\\___|\\____/|_|  \\__,_|\\___|_| ");
        System.out.println("\t\t_________________________________________________\n\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Order ID : ");
        String id =scanner.next();
        order.deleteOrder(id);
        main(null);
    }
    public static void viewReport(){
        System.out.println("\t\t _____                       _       ");
        System.out.println("\t\t|  __ \\                     | |      ");
        System.out.println("\t\t| |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println("\t\t|  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|");
        System.out.println("\t\t| | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println("\t\t|_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("\t\t	   | |                       ");
        System.out.println("\t\t	   |_|                       ");
        System.out.println("\t\t______________________________________\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("[1] Customer Report");
        System.out.println("[2] Item Report");
        System.out.println("[3] Orders Report");
        System.out.print("\nEnter Option : ");
        int num = scanner.nextInt();
        if (num==1){
            customerReport();
        }
        else if (num==2){
            ItemReport();
        }
        else if (num==3){
            OrdersReport();
        }
    }

    public static void OrdersReport() {
        System.out.println("\t\t  ____          _                                       _        ");
        System.out.println("\t\t / __ \\        | |                                     | |       ");
        System.out.println("\t\t| |  | |_ __ __| | ___ _ __   _ __ ___ _ __   ___  _ __| |_ ___  ");
        System.out.println("\t\t| |  | | '__/ _` |/ _ \\ '__| | '__/ _ \\ '_ \\ / _ \\| '__| __/ __| ");
        System.out.println("\t\t| |__| | | | (_| |  __/ |    | | |  __/ |_) | (_) | |  | |_\\__ \\ ");
        System.out.println("\t\t \\____/|_|  \\__,_|\\___|_|    |_|  \\___| .__/ \\___/|_|   \\__|___/ ");
        System.out.println("\t\t				      | |                        ");
        System.out.println("\t\t				      |_|                       ");
        System.out.println("\t\t_______________________________________________________________\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("[1] All Orders");
        System.out.println("[2] Orders By Amount");
        System.out.print("\n Enter option : ");
        int num=scanner.nextInt();
        if (num==1){
            allOrders();
        }else if (num==2){
            ordersByAmount();
        }
    }

    public static void ordersByAmount() {
        System.out.println("\t\t  ____          _             ____                                               _   ");
        System.out.println("\t\t / __ \\        | |           |  _ \\            /\\                               | |   ");
        System.out.println("\t\t| |  | |_ __ __| | ___ _ __  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_  ");
        System.out.println("\t\t| |  | | '__/ _` |/ _ \\ '__| |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __| ");
        System.out.println("\t\t| |__| | | | (_| |  __/ |    | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_  ");
        System.out.println("\t\t \\____/|_|  \\__,_|\\___|_|    |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
        System.out.println("\t\t				     __/ |                                            ");
        System.out.println("\t\t				    |___/                                             ");
        System.out.println("\t\t_____________________________________________________________________________________\n");
        order.orderByAmount();
    }

    public static void allOrders() {
        System.out.println("\t\t__      ___                  ____          _           ");
        System.out.println("\t\t\\ \\    / (_)                / __ \\        | |          ");
        System.out.println("\t\t \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ");
        System.out.println("\t\t  \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println("\t\t   \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |   ");
        System.out.println("\t\t    \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  ");
        System.out.println("\t\t_______________________________________________________\n");
        order.allOrders();
    }

    public static void ItemReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t _____ _                   _____                       _        ");
        System.out.println("\t\t|_   _| |                 |  __ \\                     | |       ");
        System.out.println("\t\t  | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___  ");
        System.out.println("\t\t  | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __| ");
        System.out.println("\t\t _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\ ");
        System.out.println("\t\t|_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/ ");
        System.out.println("\t\t				     | |                        ");
        System.out.println("\t\t				     |_|               ");
        System.out.println("\t\t_______________________________________________________________\n");

        System.out.println("[1] Best selling categories sorted by qty");
        System.out.println("[2] Best selling categories sorted by Amount");
        System.out.print("Enter Option : ");
        int selection = scanner.nextInt();
        if (selection==1){
            bestSellingSortedByQty();
        }else if (selection==2){
            bestSellingSortedByAmount();
        }

    }

    public static void bestSellingSortedByAmount() {
        System.out.println("  _____            _           _   ____                                               _   \n" +
                "  / ____|          | |         | | |  _ \\            /\\                               | |  \n" +
                " | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ \n" +
                "  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|\n" +
                "  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ \n" +
                " |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|\n" +
                "                                           __/ |                                           \n" +
                "                                          |___/                                        ");
        order.bestSellingSortedByAmount();
    }

    public static void bestSellingSortedByQty() {
        System.out.println("\t\t  _____            _           _   ____           ____                    _   _ _         ");
        System.out.println("\t\t / ____|          | |         | | |  _ \\         / __ \\                  | | (_) |        ");
        System.out.println("\t\t| (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | |_   _  __ _ _ __ | |_ _| |_ _   _ ");
        System.out.println("\t\t \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | | | |  | | | | |/ _` | '_ \\| __| | __| | | |");
        System.out.println("\t\t ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | |_| | (_| | | | | |_| | |_| |_| |");
        System.out.println("\t\t|_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\\\__,_|\\__,_|_| |_|\\__|_|\\__|\\__, |");
        System.out.println("\t\t				          __/ |                                      __/ |");
        System.out.println("\t\t				         |___/                                      |___/ ");
        System.out.println("\t\t_________________________________________________________________________________________\n");
        order.bestSellingSortedByQty();
    }

    public static void customerReport() {
        System.out.println("\t\t  _____          _                              _____                       _       ");
        System.out.println("\t\t / ____|        | |                            |  __ \\                     | |      ");
        System.out.println("\t\t| |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println("\t\t| |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println("\t\t| |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println("\t\t \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("\t\t							  | |                       ");
        System.out.println("\t\t							  |_|                       ");

        System.out.println("\t\t____________________________________________________________________________________\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("[1] Best in Customer");
        System.out.println("[2] View Customer");
        System.out.println("[3] All Customer Report");
        System.out.print("\nEnter Option :  ");
        int num=scanner.nextInt();
        if (num==1){
            bestInCustomer();
        }else if (num==2){
            viewCustomer();
        } else if (num==3) {
            allCustomerReport();

        }
    }

    public static void allCustomerReport() {
        System.out.println("\t\t	  _ _    _____          _                              _____                       _       ");
        System.out.println("\t\t    /\\   | | |  / ____|        | |                            |  __ \\                     | |      ");
        System.out.println("\t\t   /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println("\t\t  / /\\ \\ | | | | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|");
        System.out.println("\t\t / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println("\t\t/_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("\t\t								         | |                       ");
        System.out.println("\t\t								         |_|                       ");
        System.out.println("\t\t__________________________________________________________________________________________________________\n");
        order.allCustomerReport();

    }

    public static void viewCustomer() {
        System.out.println(" __      ___                  _____          _                            \n" +
                " \\ \\    / (_)                / ____|        | |                           \n" +
                "  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ \n" +
                "   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|\n" +
                "    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   \n" +
                "     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   " +
                "\n____________________________________________________________________________________");
        order.viewCustomer();
    }

    public static void bestInCustomer() {
        System.out.println("\t\t ____            _     _____          _____          _                             ");
        System.out.println("\t\t|  _ \\          | |   |_   _|        / ____|        | |                            ");
        System.out.println("\t\t| |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  ");
        System.out.println("\t\t|  _ < / _ \\/ __| __|   | | | \'_ \\  | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| ");
        System.out.println("\t\t| |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    ");
        System.out.println("\t\t|____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  \n");
        System.out.println("\t\t__________________________________________________________________________________\n");
        order.bestInCustomer();
    }
}