package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.tc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0611tc implements c.a.a.a.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0615uc f7432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0611tc(C0615uc c0615uc) {
        this.f7432a = c0615uc;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobePhotoAsset.class.getSimpleName(), "Request for cache com.adobe.cc.photo ended in Error");
    }
}
