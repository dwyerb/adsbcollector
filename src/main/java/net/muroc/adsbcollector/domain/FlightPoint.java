package net.muroc.adsbcollector.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightPoint {

    private String hex;
    private String squawk;
    private String flight;
    private double lat;
    private double lon;
    private double nucp;
    private double seen_pos;
    private long altitude;
    private int vert_rate;
    private int track;
    private int speed;
    private String category;
    private int messages;
    private long seen;
    private long rssi;

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getSquawk() {
        return squawk;
    }

    public void setSquawk(String squawk) {
        this.squawk = squawk;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight.trim();
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getNucp() {
        return nucp;
    }

    public void setNucp(double nucp) {
        this.nucp = nucp;
    }

    public double getSeen_pos() {
        return seen_pos;
    }

    public void setSeen_pos(double seen_pos) {
        this.seen_pos = seen_pos;
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    public int getVert_rate() {
        return vert_rate;
    }

    public void setVert_rate(int vert_rate) {
        this.vert_rate = vert_rate;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }

    public long getSeen() {
        return seen;
    }

    public void setSeen(long seen) {
        this.seen = seen;
    }

    public long getRssi() {
        return rssi;
    }

    public void setRssi(long rssi) {
        this.rssi = rssi;
    }
}
