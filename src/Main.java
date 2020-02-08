import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date fromThisDate = new Date();
        Date upToThisDate = new Date();
        upToThisDate.setHours(upToThisDate.getHours() + 2);
        System.out.println("All flights up to " + upToThisDate + ":");

        /**
         * Нас интересуют полеты от нынешней даты до нынешняя дата + 2 час, с типом Flight.Type.DEPARTURE
         */

        Airport.getInstance().getTerminals().forEach(terminal -> terminal.getFlights()
                .stream().filter(f -> f.getDate().after(fromThisDate))
                .filter(f -> f.getDate().before(upToThisDate))
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .forEach(f -> System.out.println(f.getType() + " " + f.getAircraft() + " " + f.getDate() + " in terminal " + terminal.getName())));
    }
}
