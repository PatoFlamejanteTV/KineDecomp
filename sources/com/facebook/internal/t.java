package com.facebook.internal;

import android.graphics.Bitmap;
import com.facebook.internal.ImageRequest;

/* compiled from: ImageDownloader.java */
/* loaded from: classes.dex */
final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageRequest f298a;
    final /* synthetic */ Exception b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Bitmap d;
    final /* synthetic */ ImageRequest.Callback e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap, ImageRequest.Callback callback) {
        this.f298a = imageRequest;
        this.b = exc;
        this.c = z;
        this.d = bitmap;
        this.e = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.onCompleted(new ImageResponse(this.f298a, this.b, this.c, this.d));
    }
}
