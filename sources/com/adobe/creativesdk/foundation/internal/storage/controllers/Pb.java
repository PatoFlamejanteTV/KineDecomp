package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesListView.java */
/* loaded from: classes.dex */
public class Pb implements c.a.a.a.b<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.storage.sd f5783a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Rb f5784b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pb(Rb rb, com.adobe.creativesdk.foundation.storage.sd sdVar) {
        this.f5784b = rb;
        this.f5783a = sdVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Bitmap bitmap) {
        if (bitmap != null) {
            this.f5783a.b(bitmap);
        } else {
            this.f5783a.a((com.adobe.creativesdk.foundation.storage.sd) new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnsupportedMedia));
        }
    }
}
