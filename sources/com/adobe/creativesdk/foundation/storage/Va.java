package com.adobe.creativesdk.foundation.storage;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetPackage.java */
/* loaded from: classes.dex */
public class Va implements c.a.a.a.b<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f7145a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ vd f7146b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ya f7147c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Va(Ya ya, WeakReference weakReference, vd vdVar) {
        this.f7147c = ya;
        this.f7145a = weakReference;
        this.f7146b = vdVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa) {
        ((Ya) this.f7145a.get()).p = fa;
        ((Ya) this.f7145a.get()).r = true;
        this.f7146b.a();
    }
}
