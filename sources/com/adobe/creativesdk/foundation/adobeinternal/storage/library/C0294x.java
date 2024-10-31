package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.Gb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryBookmarkManager.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0294x implements ka {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f4666a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0294x(B b2) {
        this.f4666a = b2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.ka
    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            ((G) Gb.f()).a();
        }
    }

    @Override // c.a.a.a.c
    public void a(Object obj) {
        ((G) Gb.f()).a((C0614ub) null, (AdobeCSDKException) obj);
    }
}
