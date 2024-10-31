package com.adobe.creativesdk.foundation.internal.storage.controllers.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: ReusableImageBitmapWorker.java */
/* loaded from: classes.dex */
public class d implements c.a.a.a.b<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ String f5921a;

    /* renamed from: b */
    final /* synthetic */ c.a.a.a.b f5922b;

    /* renamed from: c */
    final /* synthetic */ c.a.a.a.c f5923c;

    /* renamed from: d */
    final /* synthetic */ f f5924d;

    public d(f fVar, String str, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f5924d = fVar;
        this.f5921a = str;
        this.f5922b = bVar;
        this.f5923c = cVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(Bitmap bitmap) {
        Resources resources;
        c cVar;
        c cVar2;
        if (bitmap != null) {
            resources = this.f5924d.f5929a;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
            cVar = this.f5924d.f5931c;
            if (cVar != null) {
                cVar2 = this.f5924d.f5931c;
                cVar2.a(this.f5921a, bitmapDrawable);
            }
            this.f5922b.b(bitmapDrawable);
            return;
        }
        this.f5923c.a(new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnsupportedMedia));
    }
}
