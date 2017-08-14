package uk.co.mruoc.retry;

public class DefaultRetryConfig implements RetryConfig {

    private final int maxAttempts;
    private final int delay;

    public DefaultRetryConfig(DefaultRetryConfigBuilder builder) {
        this.maxAttempts = builder.maxAttempts;
        this.delay = builder.delay;
    }

    @Override
    public int getMaxAttempts() {
        return maxAttempts;
    }

    @Override
    public int getDelay() {
        return delay;
    }

    public static class DefaultRetryConfigBuilder {

        private static final int DEFAULT_MAX_ATTEMPTS = 5;
        private static final int DEFAULT_DELAY = 1000;

        private int maxAttempts = DEFAULT_MAX_ATTEMPTS;
        private int delay = DEFAULT_DELAY;

        public DefaultRetryConfigBuilder setMaxAttempts(int maxAttempts) {
            this.maxAttempts = maxAttempts;
            return this;
        }

        public DefaultRetryConfigBuilder setDelay(int delay) {
            this.delay = delay;
            return this;
        }

        public RetryConfig build() {
            return new DefaultRetryConfig(this);
        }

    }

}
