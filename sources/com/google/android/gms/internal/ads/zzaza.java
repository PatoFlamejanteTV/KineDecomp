package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

@zzark
/* loaded from: classes2.dex */
public final class zzaza {
    private boolean zzdxd = false;
    private float zzdwx = 1.0f;

    private final synchronized boolean zzaac() {
        return this.zzdwx >= 0.0f;
    }

    public static float zzbb(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdxd = z;
    }

    public final synchronized void setAppVolume(float f2) {
        this.zzdwx = f2;
    }

    public final synchronized float zzkj() {
        if (!zzaac()) {
            return 1.0f;
        }
        return this.zzdwx;
    }

    public final synchronized boolean zzkk() {
        return this.zzdxd;
    }
}
