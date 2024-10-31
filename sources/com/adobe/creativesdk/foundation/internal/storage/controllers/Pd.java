package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;

/* compiled from: PhotosCollectionListView.java */
/* loaded from: classes.dex */
class Pd implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f5787a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Rd f5788b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pd(Rd rd, c.a.a.a.b bVar) {
        this.f5788b = rd;
        this.f5787a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        this.f5787a.b(bitmapDrawable.getBitmap());
    }
}
