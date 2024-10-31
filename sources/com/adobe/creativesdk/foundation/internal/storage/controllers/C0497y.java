package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;

/* compiled from: AdobeOneUpSinglePageAssetController.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0497y implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f6538a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0497y(C c2) {
        this.f6538a = c2;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        C c2 = this.f6538a;
        if (c2.f5597a == null) {
            return;
        }
        if (bitmapDrawable == null) {
            c2.f5600d.e();
            return;
        }
        c2.f5600d.a(bitmapDrawable);
        C0533a c0533a = this.f6538a.f5602f;
        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
        if (c0533a == null || !adobeAssetFile.getType().startsWith("video/")) {
            return;
        }
        this.f6538a.f5600d.h();
    }
}
