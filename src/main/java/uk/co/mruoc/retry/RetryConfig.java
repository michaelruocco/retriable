package uk.co.mruoc.retry;

public interface RetryConfig {

    int getMaxAttempts();

    int getDelay();

    int getMaxDelay();

}
