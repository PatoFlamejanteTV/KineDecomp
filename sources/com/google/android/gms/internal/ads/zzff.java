package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzff extends Exception {
    private final int type;
    private final int zzwq;

    private zzff(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.zzwq = i2;
    }

    public static zzff zza(Exception exc, int i) {
        return new zzff(1, null, exc, i);
    }

    public static zzff zza(IOException iOException) {
        return new zzff(0, null, iOException, -1);
    }

    public static zzff zza(RuntimeException runtimeException) {
        return new zzff(2, null, runtimeException, -1);
    }
}
