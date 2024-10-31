package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public class zzhj {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final boolean zzdo() {
        return zzr(Integer.MIN_VALUE);
    }

    public final boolean zzdp() {
        return zzr(4);
    }

    public final boolean zzdq() {
        return zzr(1);
    }

    public final void zzq(int i) {
        this.flags |= Integer.MIN_VALUE;
    }

    public final boolean zzr(int i) {
        return (this.flags & i) == i;
    }
}
