package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryBookmarkManager.java */
/* loaded from: classes.dex */
public class A implements ja {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ka f4499a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f4500b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(B b2, ka kaVar) {
        this.f4500b = b2;
        this.f4499a = kaVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.ja
    public void a(ArrayList<C0291u> arrayList) {
        if (arrayList != null) {
            B b2 = this.f4500b;
            b2.f4506f = null;
            b2.f4507g = arrayList;
            b2.a((Boolean) false);
        }
        this.f4499a.a(Boolean.valueOf(this.f4500b.j));
    }

    @Override // c.a.a.a.c
    public void a(Object obj) {
        this.f4499a.a((ka) obj);
    }
}
