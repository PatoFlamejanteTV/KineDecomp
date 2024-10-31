package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;

/* loaded from: classes2.dex */
public abstract class zzbk {
    private static volatile boolean zzft = true;
    private int zzfq;
    private int zzfr;
    private boolean zzfs;

    /* JADX INFO: Access modifiers changed from: private */
    public zzbk() {
        this.zzfq = 100;
        this.zzfr = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzfs = false;
    }

    public /* synthetic */ zzbk(C1228v c1228v) {
        this();
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzbk zza(byte[] bArr, int i, int i2, boolean z) {
        C1230w c1230w = new C1230w(bArr, 0, i2, false);
        try {
            c1230w.zzl(i2);
            return c1230w;
        } catch (zzco e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zzm(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zzaf();

    public abstract int zzl(int i) throws zzco;
}
