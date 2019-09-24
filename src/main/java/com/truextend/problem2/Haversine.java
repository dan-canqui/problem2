package com.truextend.problem2;

import com.truextend.problem2.coordinate.Coordinate;

/**
 * Implements the Haversine Algorithm.
 */
public final class Haversine {

    /**
     * Stores the earth radios in kilometers.
     */
    private static final int EARTH_RADIUS = 6371;

    /**
     * Store the value of number 2.
     */
    private static final int TWO = 2;

    /**
     * Calculates the distance between two coordinates using the haversine algorithm.
     *
     * @param first  first coordinate.
     * @param second second coordinates.
     * @return the calculated distance.
     */
    public static double calculateDistance(Coordinate first, Coordinate second) {
        double firstLatitude = Math.toRadians(first.getLatitude());
        double secondLatitude = Math.toRadians(second.getLatitude());
        double deltaLongitude = Math.toRadians(second.getLongitude() - first.getLongitude());
        double deltaLatitude = secondLatitude - firstLatitude;

        double haversine = Math.pow(Math.sin(deltaLatitude / TWO), TWO)
                + Math.cos(firstLatitude)
                * Math.cos(secondLatitude)
                * Math.pow(Math.sin(deltaLongitude / TWO), TWO);
        double inverseHaversine = Math.atan2(Math.sqrt(haversine), Math.sqrt(1 - haversine));
        return TWO * EARTH_RADIUS * inverseHaversine;
    }
}
