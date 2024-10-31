package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* loaded from: classes2.dex */
public final class zzqv {
    private final Handler handler;
    private final zzqu zzbko;

    public zzqv(Handler handler, zzqu zzquVar) {
        Handler handler2;
        if (zzquVar != null) {
            zzpo.checkNotNull(handler);
            handler2 = handler;
        } else {
            handler2 = null;
        }
        this.handler = handler2;
        this.zzbko = zzquVar;
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzbko != null) {
            this.handler.post(new Yl(this, str, j, j2));
        }
    }

    public final void zzc(zzhn zzhnVar) {
        if (this.zzbko != null) {
            this.handler.post(new Xl(this, zzhnVar));
        }
    }

    public final void zzd(zzfs zzfsVar) {
        if (this.zzbko != null) {
            this.handler.post(new Zl(this, zzfsVar));
        }
    }

    public final void zzi(int i, long j) {
        if (this.zzbko != null) {
            this.handler.post(new _l(this, i, j));
        }
    }

    public final void zzb(int i, int i2, int i3, float f2) {
        if (this.zzbko != null) {
            this.handler.post(new RunnableC0835am(this, i, i2, i3, f2));
        }
    }

    public final void zzd(zzhn zzhnVar) {
        if (this.zzbko != null) {
            this.handler.post(new RunnableC0865cm(this, zzhnVar));
        }
    }

    public final void zzb(Surface surface) {
        if (this.zzbko != null) {
            this.handler.post(new RunnableC0850bm(this, surface));
        }
    }
}
