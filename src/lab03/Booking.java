package lab03;

public class Booking {

    public static void main(String[] args) throws Exception {
        Hotel hotel1 = new Hotel(
                "Praia Tropical",
                "Rua Tajubá, 201 - Florianópolis, SC",
                "3225-8997",
                100.00F,
                900.00F
        );

        Hotel hotel2 = new Hotel(
                "Campo Florestal",
                "Rua Monteiro, 456 - Goiânia, GO",
                "3654-8974",
                50.00F,
                2000.00F
        );

        User user1 = new User(
                "Roberci Silva",
                "784245698-21",
                "12/04/1996",
                "Masculino",
                1000.00F,
                true
        );

        User user2 = new User(
                "Marcela Domingues",
                "269784061-45",
                "22/07/1998",
                "Feminino",
                2000.00F,
                false
        );

        //Cenário 4
//        createNewBooking(user1, hotel1, 2, 1);
//        createNewBooking(user2, hotel2, 13, 4);

        //Cenário 5
//        createNewBooking(user1, hotel1, 87, 1);

        //Cenário 6
//        cancelBooking(user2, hotel1, 22);

        //Cenário 7
//        createNewBooking(user2, hotel2, 99, 1);

        //Cenário 8
//        cancelBooking(user2, hotel2, 99);

        //Cenário 9
//        createNewBooking(user1, hotel2, 8, 1);

        hotel1.printHotelCurrentStatus();
        hotel2.printHotelCurrentStatus();

        user1.printUserData();
        user2.printUserData();
    }

    private static void createNewBooking(User user, Hotel hotel, Integer roomNumber, Integer numberOfDays) throws Exception {
        boolean freeRoom = hotel.getAvailableRooms().contains(roomNumber);
        Room room = hotel.findRoom(roomNumber);
        Float dailyRate = hotel.getDailyRate(roomNumber);
        Float totalValue = numberOfDays * dailyRate;

        if (!freeRoom) {
            throw new Exception("Quarto ocupado!!");
        }

        if (user.getCurrentBalance() - totalValue < 0.0) {
            throw new Exception("Saldo insuficiente");
        }

        if (user.isSmoker() && !room.isSmokingAllowed()) {
            throw new Exception("Quarto não aceita fumantes!!");
        }

        user.setCurrentBalance(user.getCurrentBalance() - totalValue);

        room.setOccupied(true);
        room.setOccupant(user);
        room.setBookingValue(totalValue);
    }

    private static void cancelBooking(User user, Hotel hotel, Integer roomNumber) throws Exception {
        Room room = hotel.findRoom(roomNumber);
        Float returnedValue = 0.7F * room.getBookingValue();

        if (room.getOccupant() == null || !room.getOccupant().equals(user)) {
            throw new Exception("Usuário não possui reserva para este quarto!!");
        }

        user.setCurrentBalance(user.getCurrentBalance() + returnedValue);

        room.setOccupied(false);
        room.setOccupant(null);
        room.setBookingValue(0.0F);
    }
}
