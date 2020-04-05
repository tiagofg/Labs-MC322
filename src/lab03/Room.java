package lab03;

public class Room {

    private Integer number;
    private boolean vip;
    private boolean occupied;
    private boolean smokingAllowed;
    private boolean hasAirConditioning;
    private User occupant;
    private Float bookingValue;

    public Room(Integer number, boolean vip, boolean smokingAllowed, boolean hasAirConditioning) {
        this.number = number;
        this.vip = vip;
        this.occupied = false;
        this.smokingAllowed = smokingAllowed;
        this.hasAirConditioning = hasAirConditioning;
        this.bookingValue = 0.0F;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isSmokingAllowed() {
        return smokingAllowed;
    }

    public void setSmokingAllowed(boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
    }

    public boolean isHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public User getOccupant() {
        return occupant;
    }

    public void setOccupant(User occupant) {
        this.occupant = occupant;
    }

    public Float getBookingValue() {
        return bookingValue;
    }

    public void setBookingValue(Float bookingValue) {
        this.bookingValue = bookingValue;
    }
}
