package fr.craftinglabs.pi.ledmatrix4j.font;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {
    @Test
    public void should_be_created_from_string_and_have_a_length() {
        Line line = new Line("000000");

        assertEquals(6, line.getLength());
    }

    @Test
    public void should_have_a_represenation_as_a_string() {
        Line line = new Line("000000");

        assertEquals("000000", line.toString());
    }
    
    @Test
    public void should_return_new_Line_of_concatenated_values_when_two_lines_are_concatenated() {
        Line line = new Line("000000");
        Line line2 = new Line("1111");

        assertEquals(new Line("0000001111"), line.concat(line2));
    }

    @Test
    public void should_return_sub_line_starting_a_offset_with_specified_size() {
        Line line = new Line("010011");

        assertEquals(new Line("100"), line.subLine(3, 1));
    }
}