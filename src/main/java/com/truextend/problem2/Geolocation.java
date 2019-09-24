package com.truextend.problem2;

import com.truextend.problem2.coordinate.Classroom;
import com.truextend.problem2.coordinate.Coordinate;
import com.truextend.problem2.coordinate.Student;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Verifies the location of specific classroom and students.
 */
public class Geolocation {

    /**
     * Finds the students inside in a list of classrooms.
     *
     * @param studentList   list of student.
     * @param classroomList list of classroom.
     * @return the list of students found.
     */
    public List<Student> findStudentsInClasses(List<Student> studentList, List<Classroom> classroomList) {
        if (isNotValid(studentList) || isNotValid(classroomList)) {
            return Collections.emptyList();
        }
        return classroomList.stream()
                .flatMap(classroom -> findStudentsInClass(studentList, classroom))
                .collect(Collectors.toList());
    }

    /**
     * Returns the students inside in a specific classroom.
     *
     * @param studentList list of student.
     * @param classroom   single classroom.
     * @return the stream of students found.
     */
    private Stream<Student> findStudentsInClass(List<Student> studentList, Classroom classroom) {
        return studentList.stream()
                .filter(student -> Haversine.calculateDistance(classroom, student) <= classroom.getDistanceToCenter());
    }

    /**
     * Verifies if a list of coordinates is null or empty.
     *
     * @param coordinateList to be analyzed.
     * @param <T>            extend from Coordinate.
     * @return true if is not valid, otherwise return false.
     */
    private <T extends Coordinate> boolean isNotValid(List<T> coordinateList) {
        return coordinateList == null || coordinateList.isEmpty();
    }
}
