package com.google.api.client.util;

import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public final class BackOffUtils {
    private BackOffUtils() {
    }

    public static boolean a(Sleeper sleeper, BackOff backOff) throws InterruptedException, IOException {
        long a2 = backOff.a();
        if (a2 == -1) {
            return false;
        }
        sleeper.a(a2);
        return true;
    }
}
