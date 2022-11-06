package baseball.strategy;

import java.util.List;

public class FixedNumberProducingStrategy implements NumberProducingStrategy {

    @Override
    public List<Integer> produceNumbers() {
        return List.of(1, 2, 3);
    }
}
