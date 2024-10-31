package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzev<T> {
    private final Map<String, AtomicReference<T>> zzvc = new HashMap();

    public final AtomicReference<T> zzp(String str) {
        synchronized (this) {
            if (!this.zzvc.containsKey(str)) {
                this.zzvc.put(str, new AtomicReference<>());
            }
        }
        return this.zzvc.get(str);
    }
}
