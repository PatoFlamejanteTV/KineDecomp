package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.oc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0592oc implements c.a.a.a.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0596pc f7372a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0592oc(C0596pc c0596pc) {
        this.f7372a = c0596pc;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobePhotoAsset.class.getSimpleName(), "Request for cache com.adobe.cc.photoended in Error");
    }
}
