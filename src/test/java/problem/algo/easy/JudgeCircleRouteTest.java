package problem.algo.easy;

import static org.junit.Assert.*;
import org.junit.Test;

public class JudgeCircleRouteTest {
    private JudgeCircleRoute classToTest = new JudgeCircleRoute();

    @Test
    public void judgeCircle() {
        assertTrue(classToTest.judgeCircle("UD"));
        assertTrue(classToTest.judgeCircle("LR"));
        assertTrue(classToTest.judgeCircle("RL"));
        assertTrue(classToTest.judgeCircle("UDLR"));
        assertTrue(classToTest.judgeCircle("UDDDRRUULL"));
        assertFalse(classToTest.judgeCircle("UDDDRRUUL"));

    }

}