package hotel_repo.Services;

import hotel_repo.Exception.IncorrectPasswordException;
import hotel_repo.Exception.UsernameAlreadyExistsException;
import hotel_repo.Exception.UsernameNotFoundException;
import hotel_repo.Exception.UnavailableDateException;
import hotel_repo.Model.Hotel;
import hotel_repo.Model.Reservation;
import hotel_repo.Model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static hotel_repo.Services.FileSystemService.getPathToFile;

public class ReservationService {

    ArrayList<String> rooms = new ArrayList<String>(){{
        add("double");
        add("triple");
        add("apartment");
    }};

    private static ObjectRepository<Reservation> reservationRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("reservation.db").toFile())
                .openOrCreate("test", "test");

        reservationRepository = database.getRepository(Reservation.class);
    }

    public static void addReservation(String User, String Hotel_ID, String Checkin_date, String Checkout_date, String Room_type, int Room_number, String Comment) throws UnavailableDateException {
        checkUnavailableDateException(Checkin_date, Checkout_date);
        reservationRepository.insert(new Reservation(User, Hotel_ID, Checkin_date, Checkout_date, Room_type, Room_number, Comment));

    }

    //to be implemented
    private static void checkUnavailableDateException(String Checkin_date, String Checkout_date) throws UnavailableDateException{
        /*for (Reservation reservation : reservationRepository.find()) {
            if (Objects.equals(Checkin_date, reservation.getCheckin_date()) && Objects.equals(Checkout_date, reservation.getCheckout_date()))
                throw new UnavailableDateException();
        }*/
    }





}