package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class Ma implements c.a.a.a.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Na f7060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(Na na) {
        this.f7060a = na;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetPSDFile.getRenditionFromServerForLayer", String.format("Adding to caches is failed for %s", this.f7060a.f7068d.href));
    }
}
