package com.google.api.client.util;

import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public final class BackOffUtils {
    public static boolean a(Sleeper sleeper, BackOff backOff) throws InterruptedException, IOException {
        long b = backOff.b();
        if (b == -1) {
            return false;
        }
        sleeper.a(b);
        return true;
    }

    private BackOffUtils() {
    }
}
