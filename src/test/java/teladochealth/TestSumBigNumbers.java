package teladochealth;

import com.teladochealth.BigNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSumBigNumbers {
    private BigNumbers bigNumbers;

    private static final String EMPTY_STRING = "";

    @BeforeEach
    public void setUp() {
        bigNumbers = new BigNumbers();
    }

    @Test
    @DisplayName("Test sum: 123456789012345678901 + 12345678 = 123456789012358024579")
    public void testSumBigNummbers() {
        assertEquals("123456789012358024579", bigNumbers.sum("123456789012345678901", "12345678"));
    }

    @Test
    @DisplayName("Test sum: EMPTY_STRING + 12345678 = 12345678")
    public void testSumBigNummbersFirstOneEmpty() {
        assertEquals("12345678", bigNumbers.sum("", "12345678"));
    }

    @Test
    @DisplayName("Test sum: 123456789012345678901 + EMPTY_STRING = 123456789012345678901")
    public void testSumBigNummbersSecondOneEmpty() {
        assertEquals("123456789012345678901", bigNumbers.sum("123456789012345678901", EMPTY_STRING));
    }

    @Test
    @DisplayName("Test sum: 0 + 12345678")
    public void testSumBigNummbersFirstOneEquals0() {
        assertEquals("12345678", bigNumbers.sum("0", "12345678"));
    }

    @Test
    @DisplayName("Test sum: 123456789012345678901 + 0 = 123456789012345678901")
    public void testSumBigNummbersSecondOneEquals0() {
        assertEquals("123456789012345678901", bigNumbers.sum("123456789012345678901", "0"));
    }

    @Test
    @DisplayName("Test sum: EMPTY_STRING + EMPTY_STRING = EMPTY_STRING")
    public void testSumBigNumbersBothNumbersEmpty() {
        assertEquals("", bigNumbers.sum(EMPTY_STRING, EMPTY_STRING));
    }

    @Test
    @DisplayName("Test sum: 0 + 0 = 0")
    public void testSumBigNumbersBothNumbers0() {
        assertEquals("0", bigNumbers.sum("0", "0"));
    }

    @Test
    @DisplayName("Test sum: 123 + 11 = 134")
    public void testSumNumbers() {
        assertEquals("134", bigNumbers.sum("123", "11"));
    }

    @Test
    @DisplayName("Test sum: 11 + 123 = 134")
    public void testSumNumbersSwitched() {
        assertEquals("134", bigNumbers.sum("11", "123"));
    }


}