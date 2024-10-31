package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld;

/* compiled from: MobileCreationPackageCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.id, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0421id implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0431kd f6146a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0421id(C0431kd c0431kd) {
        this.f6146a = c0431kd;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        if (this.f6146a.f6169b.t().equals(this.f6146a.f6170c)) {
            C0436ld.a.C0033a.a(this.f6146a.f6169b, r0.f6171d.indexOf(r0.f6168a), bitmapDrawable);
        } else {
            C0436ld.a.C0033a.a(this.f6146a.f6169b, r5.f6171d.indexOf(r5.f6168a), (BitmapDrawable) null);
        }
    }
}
