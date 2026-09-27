class TicketBooking {

    int availableSeats;

    TicketBooking(int seats) {
        availableSeats = seats;
    }

    synchronized void bookSeat(int seats) {

        if (seats <= availableSeats) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " booked " + seats + " seat(s) successfully"
            );

            availableSeats = availableSeats - seats;

        } else {

            System.out.println(
                    Thread.currentThread().getName()
                            + " booking failed. Not enough seats"
            );
        }
    }
}

class User1 extends Thread {

    TicketBooking booking;

    User1(TicketBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookSeat(1);
    }
}

class User2 extends Thread {

    TicketBooking booking;

    User2(TicketBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookSeat(2);
    }
}

public class q7 {

    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking(2);

        User1 u1 = new User1(booking);
        User2 u2 = new User2(booking);

        u1.setName("User1");
        u2.setName("User2");

        u1.start();
        try {
            u1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        u2.start();
    }
}
