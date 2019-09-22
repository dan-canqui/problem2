package com.truextend.problem2;

import com.truextend.problem2.coordinate.Classroom;
import com.truextend.problem2.coordinate.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HaversineTest {

    @Mock
    private Student student;

    @Mock
    private Classroom classroom;

    @InjectMocks
    private Haversine haversine;

    @AfterEach
    public void tearDown() {
        verify(student, never()).getName();
        verify(student, never()).setName(anyString());
        verify(student, never()).setLatitude(any(Double.class));
        verify(student, never()).setLongitude(any(Double.class));

        verify(classroom, never()).getName();
        verify(classroom, never()).setName(anyString());
        verify(classroom, never()).setLatitude(any(Double.class));
        verify(classroom, never()).setLongitude(any(Double.class));
    }

    @Test
    public void calculateDistance_WithCoordinatesByDefault_ReturnsZero() {
        double distance = haversine.calculateDistance(classroom, student);
        assertThat(distance, is(0.0));

        verify(student).getLatitude();
        verify(student).getLongitude();
        verify(classroom).getLatitude();
        verify(classroom).getLongitude();
    }

    @Test
    public void calculateDistance_WithInverseCoordinates_ReturnsTheSameDistance() {
        when(student.getLatitude()).thenReturn(1.0, -1.0);
        when(student.getLongitude()).thenReturn(1.0, -1.0);

        double distance = haversine.calculateDistance(classroom, student);
        double inverseDistance = haversine.calculateDistance(classroom, student);
        assertThat(distance, is(inverseDistance));

        verify(student, times(2)).getLatitude();
        verify(student, times(2)).getLongitude();
        verify(classroom, times(2)).getLatitude();
        verify(classroom, times(2)).getLongitude();
    }
}
