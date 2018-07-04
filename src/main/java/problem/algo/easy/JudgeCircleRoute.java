package problem.algo.easy;

import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/judge-route-circle/description/
 * <p>
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should
 * be true or false representing whether the robot makes a circle.
 * <p>
 * Solution:
 * Take an integer increment it whenever we move up or right and decrement it whenever we move
 * down or left. At the end if the integer value it zero then return true otherwise return false.
 */
public class JudgeCircleRoute {

    public boolean judgeCircle(final String path) {
        int relativeDistance = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
            case 'U':
                relativeDistance++;
                break;
            case 'D':
                relativeDistance--;
                break;
            case 'R':
                relativeDistance++;
                break;
            case 'L':
                relativeDistance--;
                break;
            default:
                throw new RuntimeException("Invalid character: " + path.charAt(i));
            }
        }
        return relativeDistance == 0;
    }
}
