package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.p;

/* compiled from: AdobeUploadErrorSummaryFragment.java */
/* loaded from: classes.dex */
class o implements c.a.a.a.b<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ ImageView f6448a;

    /* renamed from: b */
    final /* synthetic */ p.a f6449b;

    public o(p.a aVar, ImageView imageView) {
        this.f6449b = aVar;
        this.f6448a = imageView;
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(Bitmap bitmap) {
        if (bitmap != null) {
            this.f6448a.setImageBitmap(bitmap);
        }
    }
}
