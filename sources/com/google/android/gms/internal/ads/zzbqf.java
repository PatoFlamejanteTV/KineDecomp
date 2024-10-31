package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzbqf {
    int zzflq;
    int zzflr;
    private int zzfls;
    Eh zzflt;
    private boolean zzflu;

    private zzbqf() {
        this.zzflr = 100;
        this.zzfls = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzflu = false;
    }

    public static long zzax(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbqf zzb(byte[] bArr, int i, int i2, boolean z) {
        Dh dh = new Dh(bArr, i, i2, z);
        try {
            dh.zzer(i2);
            return dh;
        } catch (zzbrl e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zzeu(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static zzbqf zzk(byte[] bArr, int i, int i2) {
        return zzb(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzbsl> T zza(zzbsw<T> zzbswVar, zzbqq zzbqqVar) throws IOException;

    public abstract int zzaku() throws IOException;

    public abstract long zzakv() throws IOException;

    public abstract long zzakw() throws IOException;

    public abstract int zzakx() throws IOException;

    public abstract long zzaky() throws IOException;

    public abstract int zzakz() throws IOException;

    public abstract boolean zzala() throws IOException;

    public abstract String zzalb() throws IOException;

    public abstract zzbpu zzalc() throws IOException;

    public abstract int zzald() throws IOException;

    public abstract int zzale() throws IOException;

    public abstract int zzalf() throws IOException;

    public abstract long zzalg() throws IOException;

    public abstract int zzalh() throws IOException;

    public abstract long zzali() throws IOException;

    abstract long zzalj() throws IOException;

    public abstract boolean zzalk() throws IOException;

    public abstract int zzall();

    public abstract void zzeo(int i) throws zzbrl;

    public abstract boolean zzep(int i) throws IOException;

    public final int zzeq(int i) {
        if (i >= 0) {
            int i2 = this.zzflr;
            this.zzflr = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public abstract int zzer(int i) throws zzbrl;

    public abstract void zzes(int i);

    public abstract void zzet(int i) throws IOException;
}
