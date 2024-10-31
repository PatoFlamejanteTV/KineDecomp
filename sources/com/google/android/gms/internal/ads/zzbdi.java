package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@zzark
@TargetApi(14)
/* loaded from: classes2.dex */
public abstract class zzbdi extends TextureView implements Ve {
    protected final zzbds zzera;
    protected final zzbec zzerb;

    public zzbdi(Context context) {
        super(context);
        this.zzera = new zzbds();
        this.zzerb = new zzbec(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f2, float f3);

    public abstract void zza(zzbdh zzbdhVar);

    public abstract String zzaaz();

    public abstract void zzabd();

    public void zzcz(int i) {
    }

    public void zzda(int i) {
    }

    public void zzdb(int i) {
    }

    public void zzdc(int i) {
    }
}
