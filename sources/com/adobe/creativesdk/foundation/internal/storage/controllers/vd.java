package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;

/* compiled from: PhotosAssetListView.java */
/* loaded from: classes.dex */
class vd implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6512a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ xd f6513b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vd(xd xdVar, c.a.a.a.b bVar) {
        this.f6513b = xdVar;
        this.f6512a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        this.f6512a.b(bitmapDrawable.getBitmap());
    }
}
