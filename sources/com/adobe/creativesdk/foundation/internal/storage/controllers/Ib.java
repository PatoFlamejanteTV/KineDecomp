package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;

/* compiled from: CCFilesGridView.java */
/* loaded from: classes.dex */
class Ib implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f5668a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Kb f5669b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ib(Kb kb, c.a.a.a.b bVar) {
        this.f5669b = kb;
        this.f5668a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        this.f5668a.b(bitmapDrawable.getBitmap());
    }
}
