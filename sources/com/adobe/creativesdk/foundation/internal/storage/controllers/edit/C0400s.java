package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0401t;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeEditErrorSummaryFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0400s implements sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageView f6071a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0401t.a f6072b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0400s(C0401t.a aVar, ImageView imageView) {
        this.f6072b = aVar;
        this.f6071a = imageView;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        this.f6071a.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }
}
