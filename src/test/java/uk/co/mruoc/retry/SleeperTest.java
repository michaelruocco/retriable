package uk.co.mruoc.retry;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SleeperTest {

    private Sleeper sleeper = new Sleeper();

    @Test
    public void shouldSleepForGivenDelay() {
        int delay = 500;

        Instant start = Instant.now();
        sleeper.sleep(delay);
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        assertThat(duration.toMillis()).isGreaterThanOrEqualTo(delay);
    }

}
