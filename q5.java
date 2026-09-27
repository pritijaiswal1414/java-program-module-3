import java.util.Scanner;

class q5 {

    void login(String username) {

        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }

        System.out.println("Login successful");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            // Convert "null" entered by user into actual null
            if (username.equals("null")) {
                username = null;
            }

            q5 obj = new q5();
            obj.login(username);

        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
