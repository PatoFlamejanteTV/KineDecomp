package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Dn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0347Dn {
    public final Map<Integer, AG<AbstractC0351Dr>> A00;

    @Nullable
    public static C0347Dn A02 = null;
    public static long A01 = 0;

    public C0347Dn(Map<Integer, AG<AbstractC0351Dr>> map) {
        this.A00 = map;
    }

    public static synchronized long A00() {
        long j;
        synchronized (C0347Dn.class) {
            j = A01;
        }
        return j;
    }

    @SuppressLint({"UseSparseArrays"})
    public static C0347Dn A01() {
        if (A02 == null) {
            A02 = new C0347Dn(Collections.synchronizedMap(new HashMap()));
        }
        return A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AG != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    private synchronized void A02(AG<AbstractC0351Dr> ag, int i) {
        int i2 = 0;
        boolean z = false;
        if (ag.A00() == 0) {
            z = true;
            i2 = ag.A01().A05();
        }
        int updatedSize = i - i2;
        A01 += (z ? 0 : 4) + updatedSize;
    }

    @SuppressLint({"PublicMethodReturnMutableCollection"})
    public final Map<Integer, AG<AbstractC0351Dr>> A03() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AG != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    public final synchronized void A04(int i, AG<AbstractC0351Dr> ag, int i2) {
        this.A00.put(Integer.valueOf(i), ag);
        A02(ag, i2);
    }
}
