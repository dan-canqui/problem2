package com.truextend.problem2.coordinate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class ClassroomTest {

    private Classroom classroom;

    @BeforeEach
    public void setup() {
        classroom = new Classroom();
    }

    @Test
    public void getDistanceToCenter_ByDefault_ReturnsTenMeters() {
        assertThat(classroom.getDistanceToCenter(), is(0.010));
    }

    @Test
    public void setDistanceToCenter_WithMultipleValues_returnTheCorrectValues() {
        classroom.setDistanceToCenter(3728.29120);
        assertThat(classroom.getDistanceToCenter(), is(3728.29120));

        classroom.setDistanceToCenter(-1.92012);
        assertThat(classroom.getDistanceToCenter(), is(-1.92012));
    }

    @Test
    public void getName_ByDefault_ReturnsNullValue() {
        assertThat(classroom.getName(), nullValue());
    }

    @Test
    public void setName_WithMultipleValues_returnTheCorrectValues() {
        classroom.setName(null);
        assertThat(classroom.getName(), nullValue());

        classroom.setName("");
        assertThat(classroom.getName(), emptyOrNullString());

        classroom.setName("Introductory Psychobiology");
        assertThat(classroom.getName(), is("Introductory Psychobiology"));
    }

    @Test
    public void getLatitude_ByDefault_ReturnsZeroValue() {
        assertThat(classroom.getLatitude(), is(0.0));
    }

    @Test
    public void getLatitude_WithMultipleValues_returnTheCorrectValues() {
        classroom.setLatitude(567.0);
        assertThat(classroom.getLatitude(), is(567.0));

        classroom.setLatitude(-74.92019);
        assertThat(classroom.getLatitude(), is(-74.92019));
    }

    @Test
    public void getLongitude_ByDefault_ReturnsZeroValue() {
        assertThat(classroom.getLongitude(), is(0.0));
    }

    @Test
    public void getLongitude_ByDefault_WithMultipleValues_returnTheCorrectValues() {
        classroom.setLongitude(9214.12);
        assertThat(classroom.getLongitude(), is(9214.12));

        classroom.setLongitude(-56.1829);
        assertThat(classroom.getLongitude(), is(-56.1829));
    }
}
