package com.truextend.problem2.util;

import com.truextend.problem2.coordinate.Classroom;
import com.truextend.problem2.coordinate.Student;

import static org.mockito.Mockito.spy;

/**
 * Utility class to manage coordinates.
 */
public class CoordinateUtil {

    /**
     * Builds a new student.
     *
     * @param name      student name.
     * @param longitude longitude of the student.
     * @param latitude  latitude of the student.
     * @return the built student.
     */
    public static Student buildStudent(String name, double longitude, double latitude) {
        Student student = new Student();
        student.setLongitude(longitude);
        student.setLatitude(latitude);
        student.setName(name);
        return spy(student);
    }

    /**
     * Builds a new classroom.
     *
     * @param name      classroom name.
     * @param longitude longitude of the classroom.
     * @param latitude  longitude of the classroom.
     * @return the built classroom.
     */
    public static Classroom buildClassroom(String name, double longitude, double latitude) {
        Classroom classroom = new Classroom();
        classroom.setLongitude(longitude);
        classroom.setLatitude(latitude);
        classroom.setName(name);
        return spy(classroom);
    }
}
