package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0478td;

/* compiled from: MobileCreationPackageItemsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.qd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0464qd implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0473sd f6383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0464qd(C0473sd c0473sd) {
        this.f6383a = c0473sd;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        if (this.f6383a.f6402b.t().equals(this.f6383a.f6401a)) {
            C0478td.a.C0037a.a(this.f6383a.f6402b, bitmapDrawable);
        } else {
            C0478td.a.C0037a.a(this.f6383a.f6402b, (BitmapDrawable) null);
        }
    }
}
