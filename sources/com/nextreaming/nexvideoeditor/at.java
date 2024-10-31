package com.nextreaming.nexvideoeditor;

import android.graphics.SurfaceTexture;

/* compiled from: WrapperForSurfaceTextureListener.java */
/* loaded from: classes.dex */
class at implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurfaceTexture f4826a;
    final /* synthetic */ WrapperForSurfaceTextureListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WrapperForSurfaceTextureListener wrapperForSurfaceTextureListener, SurfaceTexture surfaceTexture) {
        this.b = wrapperForSurfaceTextureListener;
        this.f4826a = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4826a.setOnFrameAvailableListener(this.b);
    }
}
