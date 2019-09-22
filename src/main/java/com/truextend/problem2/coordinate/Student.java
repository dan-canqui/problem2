package com.truextend.problem2.coordinate;

/**
 * Represents a student with a specific coordinate.
 */
public class Student extends Coordinate {

    /**
     * Stores the student name.
     */
    private String name;

    /**
     * Return the value of the 'name' property.
     *
     * @return the student name.
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
