package com.facebook.share.internal;

import com.facebook.share.internal.VideoUploader;

/* compiled from: VideoUploader.java */
/* loaded from: classes.dex */
class S implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoUploader.e f9549a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(VideoUploader.e eVar) {
        this.f9549a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoUploader.e eVar = this.f9549a;
        eVar.a(eVar.f9568b + 1);
    }
}
