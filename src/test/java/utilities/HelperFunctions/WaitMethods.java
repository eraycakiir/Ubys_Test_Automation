package utilities.HelperFunctions;

import java.util.concurrent.TimeUnit;

public class WaitMethods {
    public static void customWait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
