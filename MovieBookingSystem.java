import java.util.Scanner;

class Theatre {
    String seats[][];
    String ShowTime[];

    Theatre() {
        seats = new String[][]{{"A1", "A2", "A3", "A4", "A5"},
                {"B1", "B2", "B3", "B4", "B5"},
                {"C1", "C2", "C3", "C4", "C5"},
                {"D1", "D2", "D3", "D4", "D5"},
                {"E1", "E2", "E3", "E4", "E5"}};
        ShowTime = new String[]{"10:00AM", "02:00PM"};
    }
}

class Movie {
    String CustomerName;
    int noofTickets;
    float tktPrice;
    float totalAmt;
    String ShowDate;
    String stime;
    String seatnumbers[];

    // Constructors, getters, and setters go here
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Theatre theatre = new Theatre();
        Movie movie = new Movie();

        while (true) {
            System.out.println("1. Show Available Seats as well as Show Date and Time");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Select an Option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Input Date and Show Time");
                    System.out.print("Date: ");
                    String showDate = scanner.next();
                    System.out.print("Time: ");
                    String showTime = scanner.next();
                    displayAvailableSeats(theatre, showDate, showTime);
                    break;

                case 2:
                    System.out.println("Input Customer Name, Date, Show Time, Number of Tickets, Price");
                    movie.setCustomerName(scanner.next());
                    movie.setShowDate(scanner.next());
                    movie.setStime(scanner.next());
                    movie.setNoofTickets(scanner.nextInt());
                    movie.setTktPrice(scanner.nextFloat());
                    System.out.print("Input Seat Numbers (e.g., B2,D5,E4): ");
                    String seatNumbersInput = scanner.next();
                    movie.setSeatnumbers(seatNumbersInput.split(","));
                    float totalAmount = calculateTotalAmount(movie);
                    movie.setTotalAmt(totalAmount);
                    System.out.println("Total Amount: " + totalAmount);
                    break;

                case 3:
                    System.out.println("Exiting the Movie Booking System");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option. Please choose a valid option.");
            }
        }
    }

    private static void displayAvailableSeats(Theatre theatre, String showDate, String showTime) {
        System.out.println("Date: " + showDate);
        System.out.println("Time: " + showTime);
        for (String[] row : theatre.seats) {
            for (String seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    private static float calculateTotalAmount(Movie movie) {
        return movie.getNoofTickets() * movie.getTktPrice();
    }
}
