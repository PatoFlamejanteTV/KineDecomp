package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.AdobeLibraryErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class Z implements c.a.a.a.c<AdobeLibraryException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4570a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4571b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Integer f4572c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0614ub f4573d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f4574e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ha f4575f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(ha haVar, int i, String str, Integer num, C0614ub c0614ub, boolean z) {
        this.f4575f = haVar;
        this.f4570a = i;
        this.f4571b = str;
        this.f4572c = num;
        this.f4573d = c0614ub;
        this.f4574e = z;
    }

    @Override // c.a.a.a.c
    public void a(AdobeLibraryException adobeLibraryException) {
        int i;
        int i2 = this.f4570a;
        i = this.f4575f.G;
        if (i2 != i) {
            return;
        }
        if (adobeLibraryException == null || adobeLibraryException.getErrorCode() != AdobeLibraryErrorCode.AdobeLibraryErrorNoRenditionCandidate) {
            this.f4575f.a(this.f4571b, this.f4572c, adobeLibraryException, this.f4573d, this.f4574e, this.f4570a);
        }
    }
}
