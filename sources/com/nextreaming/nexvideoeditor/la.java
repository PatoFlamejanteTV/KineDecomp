package com.nextreaming.nexvideoeditor;

import android.graphics.SurfaceTexture;

/* compiled from: WrapperForSurfaceTextureListener.java */
/* loaded from: classes3.dex */
class la implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SurfaceTexture f24726a;

    /* renamed from: b */
    final /* synthetic */ WrapperForSurfaceTextureListener f24727b;

    public la(WrapperForSurfaceTextureListener wrapperForSurfaceTextureListener, SurfaceTexture surfaceTexture) {
        this.f24727b = wrapperForSurfaceTextureListener;
        this.f24726a = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24726a.setOnFrameAvailableListener(this.f24727b);
    }
}
