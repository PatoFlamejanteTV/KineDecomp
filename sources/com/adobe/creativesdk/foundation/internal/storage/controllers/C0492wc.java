package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.wc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0492wc implements c.a.a.a.c<AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0496xc f6522a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0492wc(C0496xc c0496xc) {
        this.f6522a = c0496xc;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f6522a.f6530a.a((BitmapDrawable) null);
        C0496xc c0496xc = this.f6522a;
        c0496xc.f6530a.s.setTag(c0496xc.f6531b.k());
    }
}
