package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.vc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0488vc implements c.a.a.a.b<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0496xc f6511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0488vc(C0496xc c0496xc) {
        this.f6511a = c0496xc;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(BitmapDrawable bitmapDrawable) {
        if (this.f6511a.f6530a.t().k().equals(this.f6511a.f6531b.k())) {
            this.f6511a.f6530a.a(bitmapDrawable);
            C0496xc c0496xc = this.f6511a;
            c0496xc.f6530a.s.setTag(c0496xc.f6531b.k());
        } else {
            this.f6511a.f6530a.a((BitmapDrawable) null);
            C0496xc c0496xc2 = this.f6511a;
            c0496xc2.f6530a.s.setTag(c0496xc2.f6531b.k());
        }
    }
}
