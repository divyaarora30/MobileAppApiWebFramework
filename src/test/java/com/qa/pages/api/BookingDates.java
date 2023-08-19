package com.qa.pages.api;

public class BookingDates {
    private String checkin;

    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    @Override
    public String toString() {
        return "ClassPojo [checkin = " + checkin + ", checkout = " + checkout + "]";
    }
}