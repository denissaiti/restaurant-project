import java.time.LocalDateTime;

public class Reservations {

    private final String name;
    private final String phoneNumber;

    private final int numberOfGuests;
    private final LocalDateTime reservationTime;
    private int table;

    public Reservations(String name, String phoneNumber, int numberOfGuests, LocalDateTime reservationTime, int table) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.numberOfGuests = numberOfGuests;
        this.reservationTime = reservationTime;
        this.table = table;

}
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public int getTable() {
        return table;
    }
}
