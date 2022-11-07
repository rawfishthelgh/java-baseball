package baseball.gamePlay;

import baseball.domain.BallCount;
import baseball.domain.Numbers;
import baseball.dto.InputToNumbers;
import baseball.rule.EndRule;
import baseball.rule.JudgementRule;
import baseball.strategy.NumberProducingStrategy;
import baseball.view.PrintResult;
import baseball.view.UserInput;

public class GamePlay {

    private static void startGame(NumberProducingStrategy numberProducingStrategy,
        boolean isGameEnd) {
        Numbers computerNumbers = new Numbers(numberProducingStrategy.produceNumbers());
        while (!isGameEnd) {
            Numbers userNumbers = new Numbers(
                InputToNumbers.toNumbers(UserInput.InputUserNumbers()));
            isGameEnd = continuegameUntilGetAnswer(computerNumbers, isGameEnd, userNumbers);
        }
    }

    private static boolean continuegameUntilGetAnswer(Numbers computerNumbers, boolean isGameEnd,
        Numbers userNumbers) {
        BallCount ballCount = JudgementRule.makeBallCounts(computerNumbers, userNumbers);
        PrintResult.printBallCount(ballCount);
        return checkGetAnswer(isGameEnd, ballCount);
    }

    private static boolean checkGetAnswer(boolean isGameEnd, BallCount ballCount) {
        if (EndRule.isGameEnd(ballCount)) {
            PrintResult.gameClearMent(EndRule.isGameEnd(ballCount));
            isGameEnd = EndRule.isGameEnd(ballCount);
        }
        return isGameEnd;
    }
}
