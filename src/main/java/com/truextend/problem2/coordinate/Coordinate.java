package com.truextend.problem2.coordinate;

/**
 * Represents a specific coordinate in the Earth.
 */
public abstract class Coordinate {

    /**
     * Stores the longitude of the coordinate.
     */
    private double longitude;

    /**
     * Stores the latitude of the coordinate.
     */
    private double latitude;

    /**
     * Return the value of the 'longitude' property.
     *
     * @return the longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the 'longitude' property.
     *
     * @param longitude to be set.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Return the value of the 'latitude' property.
     *
     * @return the latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the 'latitude' property.
     *
     * @param latitude to be set.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
