package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzet {
    int zzsx;
    int zzsy;
    int zzsz;
    r zzta;
    private boolean zztb;

    /* JADX INFO: Access modifiers changed from: private */
    public zzet() {
        this.zzsy = 100;
        this.zzsz = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zztb = false;
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzet zza(byte[] bArr, int i, int i2, boolean z) {
        C1266o c1266o = new C1266o(bArr, 0, i2, false);
        try {
            c1266o.zzp(i2);
            return c1266o;
        } catch (zzgc e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zzr(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzfi() throws IOException;

    public abstract long zzfj() throws IOException;

    public abstract long zzfk() throws IOException;

    public abstract int zzfl() throws IOException;

    public abstract long zzfm() throws IOException;

    public abstract int zzfn() throws IOException;

    public abstract boolean zzfo() throws IOException;

    public abstract String zzfp() throws IOException;

    public abstract zzeh zzfq() throws IOException;

    public abstract int zzfr() throws IOException;

    public abstract int zzfs() throws IOException;

    public abstract int zzft() throws IOException;

    public abstract long zzfu() throws IOException;

    public abstract int zzfv() throws IOException;

    public abstract long zzfw() throws IOException;

    abstract long zzfx() throws IOException;

    public abstract boolean zzfy() throws IOException;

    public abstract int zzfz();

    public abstract void zzn(int i) throws zzgc;

    public abstract boolean zzo(int i) throws IOException;

    public abstract int zzp(int i) throws zzgc;

    public abstract void zzq(int i);

    public /* synthetic */ zzet(C1264n c1264n) {
        this();
    }
}
