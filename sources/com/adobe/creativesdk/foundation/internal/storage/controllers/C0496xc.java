package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0500yc;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.io.File;

/* compiled from: DesignLibraryCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.xc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0496xc implements com.adobe.creativesdk.foundation.storage.sd<String, AdobeLibraryException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0500yc.a.C0039a f6530a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0614ub f6531b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0622wb f6532c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0582ma f6533d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0500yc.a f6534e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0496xc(C0500yc.a aVar, C0500yc.a.C0039a c0039a, C0614ub c0614ub, C0622wb c0622wb, C0582ma c0582ma) {
        this.f6534e = aVar;
        this.f6530a = c0039a;
        this.f6531b = c0614ub;
        this.f6532c = c0622wb;
        this.f6533d = c0582ma;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        if (str != null && !str.isEmpty()) {
            if (new File(str).exists()) {
                C0500yc.this.r.a(this.f6532c.c(), str, this.f6533d, new C0488vc(this), new C0492wc(this));
                return;
            } else {
                this.f6530a.a((BitmapDrawable) null);
                this.f6530a.s.setTag(this.f6531b.k());
                return;
            }
        }
        this.f6530a.a((BitmapDrawable) null);
        this.f6530a.s.setTag(this.f6531b.k());
    }

    @Override // c.a.a.a.c
    public void a(AdobeLibraryException adobeLibraryException) {
        this.f6530a.a((BitmapDrawable) null);
        this.f6530a.s.setTag(this.f6531b.k());
    }
}
