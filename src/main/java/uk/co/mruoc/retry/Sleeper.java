package uk.co.mruoc.retry;

public class Sleeper {

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new SleeperException(e);
        }
    }

}
