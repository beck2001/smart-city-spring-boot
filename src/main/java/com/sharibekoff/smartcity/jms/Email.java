package com.sharibekoff.smartcity.jms;

public class Email {
    private String to;
    private String from;

    public Email() {

    }

    public Email(String to, String from) {
        this.to = to;
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
