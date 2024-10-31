package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f3510a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, Bitmap bitmap) {
        this.b = pVar;
        this.f3510a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.d.sendResult(this.f3510a);
    }
}
