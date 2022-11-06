package baseball.rule;

import baseball.domain.BallCount;

public class EndRule {

    private static final String END_NUMBER = "2";

    public static boolean isGameEnd(BallCount ballCount) {
        return ballCount.ballCountResult().equals("3스트라이크");
    }

    public static boolean isProgramEnd(String userInput) {
        validateWrongNum(userInput);
        return userInput.equals(END_NUMBER);
    }

    private static void validateWrongNum(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("1과 2만 입력 가능합니다");
        }
    }

}
