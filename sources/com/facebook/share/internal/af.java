package com.facebook.share.internal;

import com.facebook.share.internal.VideoUploader;

/* compiled from: VideoUploader.java */
/* loaded from: classes.dex */
class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoUploader.e f359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(VideoUploader.e eVar) {
        this.f359a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f359a.a(this.f359a.c + 1);
    }
}
