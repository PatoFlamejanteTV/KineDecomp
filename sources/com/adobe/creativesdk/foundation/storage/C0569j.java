package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0569j implements c.a.a.a.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0573k f7296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0569j(C0573k c0573k) {
        this.f7296a = c0573k;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:getVideoMetadata", String.format("Adding to caches is failed for %s", this.f7296a.f7313c.href));
    }
}
