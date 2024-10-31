package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzqe {
    int zzawf;
    int zzawg;
    private int zzawh;
    C1315ka zzawi;
    private boolean zzawj;

    private zzqe() {
        this.zzawg = 100;
        this.zzawh = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzawj = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqe zza(byte[] bArr, int i, int i2, boolean z) {
        C1313ja c1313ja = new C1313ja(bArr, i, i2, false);
        try {
            c1313ja.zzaq(i2);
            return c1313ja;
        } catch (zzrk e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static zzqe zzd(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzsk> T zza(zzsu<T> zzsuVar, zzqp zzqpVar) throws IOException;

    public abstract void zzan(int i) throws zzrk;

    public abstract boolean zzao(int i) throws IOException;

    public final int zzap(int i) {
        if (i >= 0) {
            int i2 = this.zzawg;
            this.zzawg = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public abstract int zzaq(int i) throws zzrk;

    public abstract void zzar(int i);

    public abstract void zzas(int i) throws IOException;

    public abstract int zzni() throws IOException;

    public abstract long zznj() throws IOException;

    public abstract long zznk() throws IOException;

    public abstract int zznl() throws IOException;

    public abstract long zznm() throws IOException;

    public abstract int zznn() throws IOException;

    public abstract boolean zzno() throws IOException;

    public abstract String zznp() throws IOException;

    public abstract zzps zznq() throws IOException;

    public abstract int zznr() throws IOException;

    public abstract int zzns() throws IOException;

    public abstract int zznt() throws IOException;

    public abstract long zznu() throws IOException;

    public abstract int zznv() throws IOException;

    public abstract long zznw() throws IOException;

    abstract long zznx() throws IOException;

    public abstract boolean zzny() throws IOException;

    public abstract int zznz();
}
