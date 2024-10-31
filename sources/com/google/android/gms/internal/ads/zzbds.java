package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@zzark
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbds {
    private long zzesa;
    private final long zzerz = TimeUnit.MILLISECONDS.toNanos(((Long) zzwu.zzpz().zzd(zzaan.zzcpd)).longValue());
    private boolean zzesb = true;

    public final void zza(SurfaceTexture surfaceTexture, zzbdh zzbdhVar) {
        if (zzbdhVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.zzesb || Math.abs(timestamp - this.zzesa) >= this.zzerz) {
            this.zzesb = false;
            this.zzesa = timestamp;
            zzayh.zzelc.post(new Qe(this, zzbdhVar));
        }
    }

    public final void zzabf() {
        this.zzesb = true;
    }
}
