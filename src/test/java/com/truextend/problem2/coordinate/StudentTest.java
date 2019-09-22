package com.truextend.problem2.coordinate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setup() {
        student = new Student();
    }

    @Test
    public void getName_ByDefault_ReturnsNullValue() {
        assertThat(student.getName(), nullValue());
    }

    @Test
    public void setName_WithMultipleValues_returnTheCorrectValues() {
        student.setName(null);
        assertThat(student.getName(), nullValue());

        student.setName("");
        assertThat(student.getName(), emptyOrNullString());

        student.setName("Juan");
        assertThat(student.getName(), is("Juan"));
    }

    @Test
    public void getLatitude_ByDefault_ReturnsZeroValue() {
        assertThat(student.getLatitude(), is(0.0));
    }

    @Test
    public void getLatitude_WithMultipleValues_returnTheCorrectValues() {
        student.setLatitude(15.0);
        assertThat(student.getLatitude(), is(15.0));

        student.setLatitude(-57.5674);
        assertThat(student.getLatitude(), is(-57.5674));
    }

    @Test
    public void getLongitude_ByDefault_ReturnsZeroValue() {
        assertThat(student.getLongitude(), is(0.0));
    }

    @Test
    public void getLongitude_ByDefault_WithMultipleValues_returnTheCorrectValues() {
        student.setLongitude(49.392);
        assertThat(student.getLongitude(), is(49.392));

        student.setLongitude(-172593.12456);
        assertThat(student.getLongitude(), is(-172593.12456));
    }
}
