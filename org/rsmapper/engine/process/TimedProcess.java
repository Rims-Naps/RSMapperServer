//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.engine.process;

import java.util.concurrent.TimeUnit;

public interface TimedProcess {
    Timer getTimer();

    void execute();

    public static class Timer {
        private final int delay;
        private final TimeUnit timeUnit;

        public Timer(int delay, TimeUnit timeUnit) {
            this.delay = delay;
            this.timeUnit = timeUnit;
        }

        public long getDelayInMs() {
            switch (this.timeUnit) {
                case MILLISECONDS:
                    return (long)this.delay;
                case SECONDS:
                    return TimeUnit.SECONDS.toMillis((long)this.delay);
                case MINUTES:
                    return TimeUnit.MINUTES.toMillis((long)this.delay);
                case HOURS:
                    return TimeUnit.MILLISECONDS.toMillis((long)this.delay);
                case DAYS:
                    return TimeUnit.DAYS.toMillis((long)this.delay);
                default:
                    return (long)this.delay;
            }
        }

        public TimeUnit getTimeUnit() {
            return this.timeUnit;
        }

        public int getDelay() {
            return this.delay;
        }
    }
}
