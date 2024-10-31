package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.sd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryBookmarkManager.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0296z implements sd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ka f4670a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f4671b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0296z(B b2, ka kaVar) {
        this.f4671b = b2;
        this.f4670a = kaVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.c
    public void a(Object obj) {
        this.f4670a.a((ka) obj);
    }

    @Override // c.a.a.a.b
    public void b(Object obj) {
        B b2 = this.f4671b;
        b2.f4506f = null;
        b2.a((Boolean) false);
        this.f4670a.a(Boolean.valueOf(this.f4671b.j));
    }
}
