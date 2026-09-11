import java.util.Scanner;

class Canteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char orderUlit;

        int totalItems = 0;
        double finalSubtotal = 0.0;
        double finalDiscount = 0.0;
        double finalTotal = 0.0;

        do {
            System.out.println("\n=====     MENU     =====");
            System.out.println("1. Burger       - $80.00");
            System.out.println("2. Pizza        - $120.00");
            System.out.println("3. Fries        - $50.00");
            System.out.println("4. Milk Tea     - $70.00");
            System.out.println("5. Shawarma     - $90.00");
            System.out.println("=========================");

            System.out.print("\nEnter item number: ");
            int item = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if ((item >= 1 && item <= 5) && (quantity >= 1 && quantity <= 10)) {

                double price = switch (item) {
                    case 1 -> 80.00;
                    case 2 -> 120.00;
                    case 3 -> 50.00;
                    case 4 -> 70.00;
                    case 5 -> 90.00;
                    default -> 0.00;
                };

                double subtotal = price * quantity;

                System.out.print("Are you a student? (Y/N): ");
                char isStudent = scanner.next().charAt(0);
                double discount = 0.0;

                if (isStudent == 'Y' || isStudent == 'y') {
                    if (subtotal >= 500) {
                        discount = 0.15;
                    } else {
                        discount = 0.10;
                    }
                }

                double discountAmount = subtotal * discount;
                double total = subtotal - discountAmount;

                totalItems += quantity;
                finalSubtotal += subtotal;
                finalDiscount += discountAmount;
                finalTotal += total;

                System.out.println("\n=====  ORDER SUMMARY  =====");
                System.out.println("Subtotal: $" + subtotal);
                System.out.println("Discount: $" + discountAmount);
                System.out.println("Order Total:    $" + total);

            } else if (item < 1 || item > 5) {
                System.out.println("Invalid order! Item must be around (1-5).");
            } else {
                System.out.println("Invalid order! Quantity must be around (1-10).");
            }

            System.out.print("\nWould you like to order again? (Y/N): ");
            orderUlit = scanner.next().charAt(0);

        } while (orderUlit == 'Y' || orderUlit == 'y');

        System.out.println("\n=====  ORDER SUMMARY  =====");
        System.out.println("Total Items Purchased: " + totalItems);
        System.out.println("Total Before Discount: $" + finalSubtotal);
        System.out.println("Total Discount:        $" + finalDiscount);
        System.out.println("Final Amount:          $" + finalTotal);
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}