package br.unicamp.ic.mc322.lab03;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Hotel {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Room> rooms;
    private Float normalDailyRate;
    private Float vipDailyRate;

    public Hotel(String name, String address, String phoneNumber, Float normalDailyRate, Float vipDailyRate) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rooms = buildRooms();
        this.normalDailyRate = normalDailyRate;
        this.vipDailyRate = vipDailyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Float getNormalDailyRate() {
        return normalDailyRate;
    }

    public void setNormalDailyRate(Float normalDailyRate) {
        this.normalDailyRate = normalDailyRate;
    }

    public Float getVipDailyRate() {
        return vipDailyRate;
    }

    public void setVipDailyRate(Float vipDailyRate) {
        this.vipDailyRate = vipDailyRate;
    }

    private List<Room> buildRooms() {
        List<Room> allRooms = new ArrayList<>();
        Room newRoom;

        for (int i = 1; i <= 100; i++) {
            if (i <= 10) {
                newRoom = new Room(i, true, true, true);
            } else {
                newRoom = new Room(i, false, false, false);
            }

            allRooms.add(newRoom);
        }

        return allRooms;
    }

    public List<Integer> getAvailableRooms() {
        List<Integer> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (!room.isOccupied()) {
                availableRooms.add(room.getNumber());
            }
        }

        return availableRooms;
    }

    public Room findRoom(Integer roomNumber) throws Exception {
        for (Room room : rooms) {
            if (room.getNumber().equals(roomNumber)) {
                return room;
            }
        }

        throw new Exception("Quarto não encontrado");
    }

    public Float getDailyRate(Integer roomNumber) throws Exception {
        Room selectedRoom = findRoom(roomNumber);

        if (selectedRoom.isVip()) {
            return vipDailyRate;
        }

        return normalDailyRate;
    }

    public void printHotelCurrentStatus() {
        int availableRoomsAmount = getAvailableRooms().size();
        String availableRooms = getAvailableRooms().stream().map(String::valueOf).collect(Collectors.joining(","));
        NumberFormat formatToReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println("------------Estado do hotel------------");
        System.out.println("O hotel " + name + " possui " + availableRoomsAmount  + " quartos disponíveis.");
        System.out.println("Os quartos disponíveis são: " + availableRooms);
        System.out.println("O preço da diária normal é: " + formatToReal.format(normalDailyRate));
        System.out.println("O preço da diária vip é: " + formatToReal.format(vipDailyRate));
    }
}
