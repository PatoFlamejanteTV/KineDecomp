package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zztq {
    int zzbty;
    int zzbtz;
    private int zzbua;
    C1378ma zzbub;
    private boolean zzbuc;

    private zztq() {
        this.zzbtz = 100;
        this.zzbua = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzbuc = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zztq zza(byte[] bArr, int i, int i2, boolean z) {
        C1376la c1376la = new C1376la(bArr, i, i2, false);
        try {
            c1376la.zzas(i2);
            return c1376la;
        } catch (zzuv e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static zztq zzd(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzvv> T zza(zzwf<T> zzwfVar, zzub zzubVar) throws IOException;

    public abstract void zzap(int i) throws zzuv;

    public abstract boolean zzaq(int i) throws IOException;

    public final int zzar(int i) {
        if (i >= 0) {
            int i2 = this.zzbtz;
            this.zzbtz = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public abstract int zzas(int i) throws zzuv;

    public abstract void zzat(int i);

    public abstract void zzau(int i) throws IOException;

    public abstract int zzuj() throws IOException;

    public abstract long zzuk() throws IOException;

    public abstract long zzul() throws IOException;

    public abstract int zzum() throws IOException;

    public abstract long zzun() throws IOException;

    public abstract int zzuo() throws IOException;

    public abstract boolean zzup() throws IOException;

    public abstract String zzuq() throws IOException;

    public abstract zzte zzur() throws IOException;

    public abstract int zzus() throws IOException;

    public abstract int zzut() throws IOException;

    public abstract int zzuu() throws IOException;

    public abstract long zzuv() throws IOException;

    public abstract int zzuw() throws IOException;

    public abstract long zzux() throws IOException;

    abstract long zzuy() throws IOException;

    public abstract boolean zzuz() throws IOException;

    public abstract int zzva();
}
