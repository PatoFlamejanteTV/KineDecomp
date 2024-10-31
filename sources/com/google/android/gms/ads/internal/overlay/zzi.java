package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.TextureView;

/* loaded from: classes.dex */
public abstract class zzi extends TextureView {
    public zzi(Context context) {
        super(context);
    }

    public abstract String a();

    public abstract void a(float f);

    public abstract void a(int i);

    public abstract void a(zzh zzhVar);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setMimeType(String str);

    public abstract void setVideoPath(String str);
}
