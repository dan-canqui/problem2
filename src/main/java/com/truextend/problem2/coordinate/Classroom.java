package com.truextend.problem2.coordinate;

/**
 * Represents a classroom with a specific coordinate and square shape.
 */
public class Classroom extends Coordinate {

    /**
     * Stores the default distance in meters from the any square side to the center.
     */
    private static final double DEFAULT_DISTANCE = 0.01;

    /**
     * Stores the distance in meters from the any square side to the center.
     */
    private double distanceToCenter;

    /**
     * Store the classroom name.
     */
    private String name;

    /**
     * Default constructor.
     */
    public Classroom() {
        distanceToCenter = DEFAULT_DISTANCE;
    }

    /**
     * Returns the value of the 'distanceToCenter' property.
     *
     * @return the distance to the center.
     */
    public double getDistanceToCenter() {
        return distanceToCenter;
    }

    /**
     * Sets the value of the 'distanceToCenter' property.
     *
     * @param distance to be set.
     */
    public void setDistanceToCenter(double distance) {
        this.distanceToCenter = distance;
    }

    /**
     * Return the value of the 'name' property.
     *
     * @return the classroom name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the 'name' property.
     *
     * @param name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
