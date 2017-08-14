package uk.co.mruoc.retry;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SleeperExceptionTest {

    private final Throwable cause = new Exception();

    @Test
    public void shouldReturnCause() {
        Throwable sleeperException = new SleeperException(cause);

        assertThat(sleeperException.getCause()).isEqualTo(cause);
    }

}
