package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzuv {
    private final byte[] zzccc;
    private int zzccd;
    private int zzcce;
    private final /* synthetic */ zzur zzccf;

    /* JADX INFO: Access modifiers changed from: private */
    public zzuv(zzur zzurVar, byte[] bArr) {
        this.zzccf = zzurVar;
        this.zzccc = bArr;
    }

    public final synchronized void zzbd() {
        try {
            if (this.zzccf.zzcca) {
                this.zzccf.zzcbz.zzc(this.zzccc);
                this.zzccf.zzcbz.zzg(this.zzccd);
                this.zzccf.zzcbz.zzh(this.zzcce);
                this.zzccf.zzcbz.zza(null);
                this.zzccf.zzcbz.zzbd();
            }
        } catch (RemoteException e2) {
            zzbbd.zza("Clearcut log failed", e2);
        }
    }

    public final zzuv zzby(int i) {
        this.zzccd = i;
        return this;
    }

    public final zzuv zzbz(int i) {
        this.zzcce = i;
        return this;
    }

    public /* synthetic */ zzuv(zzur zzurVar, byte[] bArr, Ym ym) {
        this(zzurVar, bArr);
    }
}
