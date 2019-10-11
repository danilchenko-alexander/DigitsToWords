import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestConverter {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new BigInteger("123"),"сто двадцать три"},
                {new BigInteger("1187"), "одна тысяча сто восемьдесят семь"},
                {new BigInteger("134345"),"сто тридцать четыре тысячи триста сорок пять"},
                {new BigInteger("1209391230129319203"),"один квинтиллион двесте девять квадриллионов триста " +
                        "девяноста один триллион двесте тридцать миллиардов сто двадцать девять миллионов триста" +
                        " девятнадцать тысяч двесте три"}
        });
    }

    private BigInteger input;
    private String expected;

    public TestConverter(BigInteger input, String expected){
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        Converter con = new Converter();
        assertEquals(expected, con.digitToString(input));
    }


}
