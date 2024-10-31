package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.C0614ub;

/* compiled from: AdobeLibraryPublicCollection.java */
/* loaded from: classes.dex */
class K implements c.a.a.a.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0614ub f4524a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f4525b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(M m, C0614ub c0614ub) {
        this.f4525b = m;
        this.f4524a = c0614ub;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            this.f4525b.m.i(this.f4524a.k());
        }
        if (this.f4525b.m.j()) {
            return;
        }
        this.f4525b.m.b(true);
    }
}
