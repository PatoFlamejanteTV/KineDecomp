package com.facebook.internal;

import android.graphics.Bitmap;
import com.facebook.internal.ImageRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageDownloader.java */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageRequest f9334a;

    /* renamed from: b */
    final /* synthetic */ Exception f9335b;

    /* renamed from: c */
    final /* synthetic */ boolean f9336c;

    /* renamed from: d */
    final /* synthetic */ Bitmap f9337d;

    /* renamed from: e */
    final /* synthetic */ ImageRequest.Callback f9338e;

    public u(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap, ImageRequest.Callback callback) {
        this.f9334a = imageRequest;
        this.f9335b = exc;
        this.f9336c = z;
        this.f9337d = bitmap;
        this.f9338e = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9338e.onCompleted(new ImageResponse(this.f9334a, this.f9335b, this.f9336c, this.f9337d));
    }
}
