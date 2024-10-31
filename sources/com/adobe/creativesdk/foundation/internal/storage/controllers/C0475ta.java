package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXLibraryItemCollectionOneUpViewerActivity;

/* compiled from: AdobeUXLibraryItemCollectionOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ta, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0475ta implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0486va f6411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0475ta(C0486va c0486va) {
        this.f6411a = c0486va;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        RelativeLayout.LayoutParams layoutParams;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        this.f6411a.f6502a.B();
        if (bitmap == null) {
            this.f6411a.f6506e.A();
            return;
        }
        if (this.f6411a.f6506e.getActivity() == null) {
            return;
        }
        if (this.f6411a.f6506e.f5557f == null || (bitmap.getWidth() > this.f6411a.f6506e.f5557f.f5560a && bitmap.getHeight() > this.f6411a.f6506e.f5557f.f5561b)) {
            this.f6411a.f6506e.z();
            this.f6411a.f6506e.f5557f = new AdobeUXLibraryItemCollectionOneUpViewerActivity.e();
            this.f6411a.f6506e.f5557f.f5560a = bitmap.getWidth();
            this.f6411a.f6506e.f5557f.f5561b = bitmap.getHeight();
            DisplayMetrics displayMetrics = this.f6411a.f6506e.getResources().getDisplayMetrics();
            if (bitmap.getWidth() >= displayMetrics.widthPixels && bitmap.getHeight() >= displayMetrics.heightPixels) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            this.f6411a.f6505d.setImageBitmap(com.adobe.creativesdk.foundation.internal.utils.p.a(bitmap, displayMetrics.widthPixels, displayMetrics.heightPixels));
            layoutParams.addRule(13);
            this.f6411a.f6505d.setLayoutParams(layoutParams);
            this.f6411a.f6506e.c(false);
        }
    }
}
