package fr.craftinglabs.pi.ledmatrix4j;

import java.time.Duration;

public class SequenceRepeater {
    public interface Action {
        void execute();
    }

    public void Run(Action action, Duration duration) {
        long startTime = System.currentTimeMillis();
        do {
            action.execute();
        }while (System.currentTimeMillis() - startTime <= duration.toMillis());
    }
}
