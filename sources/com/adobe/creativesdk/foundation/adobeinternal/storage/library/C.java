package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryCollection.java */
/* loaded from: classes.dex */
public class C implements ka {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ D f4509a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ D f4510b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(D d2, D d3) {
        this.f4510b = d2;
        this.f4509a = d3;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.ka
    public void a(Boolean bool) {
        synchronized (this) {
            this.f4510b.p = null;
            ((G) this.f4510b.f4513c).a(bool.booleanValue());
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "BOOKMARK", "syncBookmarks ");
            if (!this.f4509a.h()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "BOOKMARK", "syncBookmarks  isSyncing " + this.f4509a.h());
                ((G) this.f4510b.f4513c).a(this.f4509a);
            }
        }
    }

    @Override // c.a.a.a.c
    public void a(Object obj) {
        this.f4510b.p = null;
        if (this.f4509a.h()) {
            return;
        }
        ((G) this.f4510b.f4513c).a(this.f4509a);
    }
}
