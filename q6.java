import java.util.Scanner;

class MinimumAmountException extends Exception {

    MinimumAmountException(String message) {
        super(message);
    }
}

class q6 {

    void placeOrder(int amount) throws MinimumAmountException {

        if (amount < 500) {
            throw new MinimumAmountException(
                    "Minimum cart value must be ₹500"
            );
        }

        System.out.println("Order placed successfully");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter cart amount: ");
            int amount = sc.nextInt();

            q6 obj = new q6();
            obj.placeOrder(amount);

        } catch (MinimumAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}