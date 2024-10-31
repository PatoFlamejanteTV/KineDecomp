package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@zzark
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbec implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager mAudioManager;
    private boolean zzeri;
    private final Ve zzeui;
    private boolean zzeuj;
    private boolean zzeuk;
    private float zzeul = 1.0f;

    public zzbec(Context context, Ve ve) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.zzeui = ve;
    }

    private final void zzacg() {
        boolean z;
        boolean z2;
        boolean z3 = this.zzeri && !this.zzeuk && this.zzeul > 0.0f;
        if (z3 && !(z2 = this.zzeuj)) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null && !z2) {
                this.zzeuj = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.zzeui.zzabd();
            return;
        }
        if (z3 || !(z = this.zzeuj)) {
            return;
        }
        AudioManager audioManager2 = this.mAudioManager;
        if (audioManager2 != null && z) {
            this.zzeuj = audioManager2.abandonAudioFocus(this) == 0;
        }
        this.zzeui.zzabd();
    }

    public final float getVolume() {
        float f2 = this.zzeuk ? 0.0f : this.zzeul;
        if (this.zzeuj) {
            return f2;
        }
        return 0.0f;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.zzeuj = i > 0;
        this.zzeui.zzabd();
    }

    public final void setMuted(boolean z) {
        this.zzeuk = z;
        zzacg();
    }

    public final void setVolume(float f2) {
        this.zzeul = f2;
        zzacg();
    }

    public final void zzacd() {
        this.zzeri = true;
        zzacg();
    }

    public final void zzace() {
        this.zzeri = false;
        zzacg();
    }
}
