package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f20747a;

    /* renamed from: b */
    final /* synthetic */ C1800s f20748b;

    public r(C1800s c1800s, Bitmap bitmap) {
        this.f20748b = c1800s;
        this.f20747a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20748b.f20752d.sendResult(this.f20747a);
    }
}
