package fr.craftinglabs.pi.matrix;

import fr.craftinglabs.pi.matrix.io.MatrixIO;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void should_ask_Matrix_IO_to_print_a_frame() {
        RecordedMatrixIO recordedMatrixIO = new RecordedMatrixIO();
        String expected = anExpectedRecord()
                .clearLine()
                .goFirstLine()
                .shiftLine((byte) 255)
                .clearLine()
                .goNextLine()
                .build();
        Matrix matrix = new Matrix(new Size(1, 8), recordedMatrixIO);

        matrix.print(1, new Frame("11111111"));

        assertEquals(expected.toString(), recordedMatrixIO.getRecord());
    }

    @Test
    public void should_ask_MatrixIO_to_print_all_lines() {
        RecordedMatrixIO recordedMatrixIO = new RecordedMatrixIO();
        String expected = anExpectedRecord()
                .clearLine()
                .goFirstLine()
                .shiftLine((byte) 255)
                .clearLine()
                .goNextLine()
                .shiftLine((byte) 1)
                .clearLine()
                .goNextLine()
                .build();
        Matrix matrix = new Matrix(new Size(2, 8), recordedMatrixIO);

        matrix.print(1, new Frame("11111111", "10000000"));

        assertEquals(expected.toString(), recordedMatrixIO.getRecord());
    }

    private ExpectedRecordBuilder anExpectedRecord() {
        return new ExpectedRecordBuilder();
    }

    class ExpectedRecordBuilder {
        StringBuilder recordBuilder = new StringBuilder();


        public ExpectedRecordBuilder clearLine() {
            recordBuilder.append("shiftLine 0\n")
                    .append("releaseShift\n");

            return this;
        }

        public ExpectedRecordBuilder goFirstLine() {
            recordBuilder.append("resetCounter\n");
            return this;
        }

        public ExpectedRecordBuilder shiftLine(byte b) {
            recordBuilder.append("shiftLine ").append(b).append("\n");
            recordBuilder.append("releaseShift\n");
            return this;
        }

        public ExpectedRecordBuilder goNextLine() {
            recordBuilder.append("incrementCounter\n");
            return this;
        }


        public String build() {
            return recordBuilder.toString();
        }
    }

    class RecordedMatrixIO implements MatrixIO {


        StringBuilder record = new StringBuilder();

        @Override
        public void incrementCounter() {
            record.append("incrementCounter\n");
        }

        @Override
        public void resetCounter() {
            record.append("resetCounter\n");
        }

        @Override
        public void releaseShift() {
            record.append("releaseShift\n");
        }

        @Override
        public void shiftLine(byte value) {
            record.append("shiftLine ").append(value).append("\n");
        }

        public String getRecord() {
            return record.toString();
        }
    }
}