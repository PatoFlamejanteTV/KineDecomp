package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.a.a;
import java.util.Random;

/* loaded from: classes.dex */
class RandomBackoff implements a {
    final a backoff;
    final double jitterPercent;
    final Random random;

    public RandomBackoff(a aVar, double d2) {
        this(aVar, d2, new Random());
    }

    @Override // io.fabric.sdk.android.services.concurrency.a.a
    public long getDelayMillis(int i) {
        double randomJitter = randomJitter();
        double delayMillis = this.backoff.getDelayMillis(i);
        Double.isNaN(delayMillis);
        return (long) (randomJitter * delayMillis);
    }

    double randomJitter() {
        double d2 = this.jitterPercent;
        double d3 = 1.0d - d2;
        return d3 + (((d2 + 1.0d) - d3) * this.random.nextDouble());
    }

    public RandomBackoff(a aVar, double d2, Random random) {
        if (d2 < 0.0d || d2 > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random != null) {
            this.backoff = aVar;
            this.jitterPercent = d2;
            this.random = random;
            return;
        }
        throw new NullPointerException("random must not be null");
    }
}
