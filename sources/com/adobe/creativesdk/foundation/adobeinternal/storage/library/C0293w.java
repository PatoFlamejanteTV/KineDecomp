package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.storage.a.b.va;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeLibraryBookmarkManager.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0293w implements va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f4664a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f4665b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0293w(B b2, sd sdVar) {
        this.f4665b = b2;
        this.f4664a = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f4664a.b(null);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        synchronized (this) {
            if (this.f4665b.a(adobeAssetException)) {
                this.f4665b.a(new C0292v(this));
            } else {
                this.f4664a.a((sd) adobeAssetException);
            }
        }
    }
}
