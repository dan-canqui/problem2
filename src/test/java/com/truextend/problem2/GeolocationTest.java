package com.truextend.problem2;

import com.truextend.problem2.coordinate.Classroom;
import com.truextend.problem2.coordinate.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.truextend.problem2.util.CoordinateUtil.buildClassroom;
import static com.truextend.problem2.util.CoordinateUtil.buildStudent;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GeolocationTest {

    private List<Classroom> classroomList;

    private List<Student> studentList;

    @Spy
    private Haversine haversine;

    @InjectMocks
    private Geolocation geolocation;

    @BeforeEach
    public void setup() {
        Classroom engineeringClassroom = buildClassroom("Principles of computational geo-location analysis", 34.069140, -118.442689);
        Classroom geologyClassroom = buildClassroom("Sedimentary Petrology", 34.069585, -118.441878);
        Classroom psychologyClassroom = buildClassroom("Introductory Psychobiology", 34.069742, -118.441312);
        Classroom musicClassroom = buildClassroom("Art of Listening", 34.070223, -118.440193);
        Classroom humanitiesClassroom = buildClassroom("Art Hitory", 34.071528, -118.441211);
        classroomList = Arrays.asList(geologyClassroom, psychologyClassroom, musicClassroom, humanitiesClassroom, engineeringClassroom);
    }

    @AfterEach
    public void tearDown() {
        classroomList = classroomList == null ? Collections.emptyList() : classroomList;
        studentList = studentList == null ? Collections.emptyList() : studentList;

        int total = classroomList.size() * studentList.size();
        verify(haversine, times(total)).calculateDistance(any(Classroom.class), any(Student.class));

        studentList.forEach(student -> {
            verify(student, never()).getName();
            verify(student, never()).setName(anyString());
            verify(student, never()).setLatitude(anyDouble());
            verify(student, never()).setLongitude(anyDouble());
        });

        classroomList.forEach(classroom -> {
            verify(classroom, never()).getName();
            verify(classroom, never()).setName(anyString());
            verify(classroom, never()).setLatitude(anyDouble());
            verify(classroom, never()).setLongitude(anyDouble());
        });
    }

    @Test
    public void findStudentsInClasses_WithNullOrEmptyStudentList_ReturnsAnEmptyStudentFoundList() {
        studentList = null;
        List<Student> studentFoundList = geolocation.findStudentsInClasses(studentList, classroomList);
        assertThat(studentFoundList, empty());

        studentList = Collections.emptyList();
        studentFoundList = geolocation.findStudentsInClasses(studentList, classroomList);
        assertThat(studentFoundList, empty());
    }

    @Test
    public void findStudentsInClasses_WithNullOrEmptyClassroomList_ReturnsAnEmptyStudentFoundList() {
        Student johnStudent = buildStudent("John Wilson", 34.069149, -118.442639);
        studentList = Collections.singletonList(johnStudent);
        classroomList = null;
        List<Student> studentFoundList = geolocation.findStudentsInClasses(studentList, classroomList);
        assertThat(studentFoundList, empty());

        classroomList = Collections.emptyList();
        studentFoundList = geolocation.findStudentsInClasses(studentList, classroomList);
        assertThat(studentFoundList, empty());
    }

    @Test
    public void findStudentsInClasses_WithStudentListInsideClassroom_ReturnsTheStudentFoundList() {
        Student johnStudent = buildStudent("John Wilson", 34.069149, -118.442639); // engineering
        Student janeStudent = buildStudent("Jane Graham", 34.069601, -118.441862); // geology
        Student pamStudent = buildStudent("Pam Bam", 34.071513, -118.441181); // humanities
        studentList = Arrays.asList(johnStudent, janeStudent, pamStudent);

        List<Student> studentFoundList = geolocation.findStudentsInClasses(studentList, classroomList);
        assertThat(studentFoundList, containsInAnyOrder(pamStudent, janeStudent, johnStudent));
    }

    @Test
    public void findStudentsInClasses_WithStudentListOutsideClassroom_ReturnsTheStudentFoundList() {
        Student johnStudent = buildStudent("John Wilson", 34.069849, -118.443539); // engineering
        Student janeStudent = buildStudent("Jane Graham", 34.069901, -118.441562); // geology
        Student pamStudent = buildStudent("Pam Bam", 34.071523, -118.441171); // humanities
        studentList = Arrays.asList(johnStudent, janeStudent, pamStudent);

        List<Student> studentFoundList = geolocation.findStudentsInClasses(studentList, classroomList);
        assertThat(studentFoundList, containsInAnyOrder(pamStudent));
    }
}
