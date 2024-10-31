package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Beta
/* loaded from: classes2.dex */
public final class Uninterruptibles {
    public static <V> V a(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException e) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private Uninterruptibles() {
    }
}
