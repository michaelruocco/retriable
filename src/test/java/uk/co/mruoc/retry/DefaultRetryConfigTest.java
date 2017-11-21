package uk.co.mruoc.retry;

import org.junit.Test;
import uk.co.mruoc.retry.DefaultRetryConfig.DefaultRetryConfigBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultRetryConfigTest {

    private final DefaultRetryConfigBuilder builder = new DefaultRetryConfigBuilder();

    @Test
    public void maxAttemptsShouldDefaultToFive() {
        RetryConfig config = builder.build();

        assertThat(config.getMaxAttempts()).isEqualTo(5);
    }

    @Test
    public void delayShouldDefaultToOneSecond() {
        RetryConfig config = builder.build();

        assertThat(config.getDelay()).isEqualTo(1000);
    }

    @Test
    public void shouldSetMaxAttempts() {
        int maxAttempts = 10;

        RetryConfig config = builder.setMaxAttempts(maxAttempts).build();

        assertThat(config.getMaxAttempts()).isEqualTo(maxAttempts);
    }

    @Test
    public void shouldSetDelay() {
        int delay = 2000;

        RetryConfig config = builder.setDelay(delay).build();

        assertThat(config.getDelay()).isEqualTo(delay);
    }

    @Test
    public void shouldReturnMaxDelay() {
        RetryConfig config = builder.setMaxAttempts(3).setDelay(2000).build();

        assertThat(config.getMaxDelay()).isEqualTo(6000);
    }

}
