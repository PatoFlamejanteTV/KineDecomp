package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzpl<T> implements zzpi {
    private volatile T result;
    public final int type;
    private final zzov zzagy;
    public final zzoz zzazo;
    private final zzpm<? extends T> zzbhf;
    private volatile boolean zzbhg;
    private volatile long zzbhh;

    public zzpl(zzov zzovVar, Uri uri, int i, zzpm<? extends T> zzpmVar) {
        this.zzagy = zzovVar;
        this.zzazo = new zzoz(uri, 1);
        this.type = i;
        this.zzbhf = zzpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void cancelLoad() {
        this.zzbhg = true;
    }

    public final T getResult() {
        return this.result;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzfe() {
        return this.zzbhg;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzff() throws IOException, InterruptedException {
        zzoy zzoyVar = new zzoy(this.zzagy, this.zzazo);
        try {
            zzoyVar.open();
            this.result = this.zzbhf.zzb(this.zzagy.getUri(), zzoyVar);
        } finally {
            this.zzbhh = zzoyVar.zzgt();
            zzqe.closeQuietly(zzoyVar);
        }
    }

    public final long zzfv() {
        return this.zzbhh;
    }
}
