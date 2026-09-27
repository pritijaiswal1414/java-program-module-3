class BankTransaction extends Thread {

    String transactionType;
    int amount;

    BankTransaction(String transactionType, int amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public void run() {

        System.out.println(
                transactionType +
                        " transaction of ₹" + amount +
                        " processed"
        );
    }
}

public class q10 {

    public static void main(String[] args) {

        BankTransaction low =
                new BankTransaction("Low-value", 5000);

        BankTransaction high =
                new BankTransaction("High-value", 50000);


        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        System.out.println("High-value transaction processed first");
        high.start();

        try {
            high.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Low-value transaction processed later");
        low.start();
    }
}
