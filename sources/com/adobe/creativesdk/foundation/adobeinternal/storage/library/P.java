package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class P implements qb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4536a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4537b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0231f f4538c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4539d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f4540e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ha f4541f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(ha haVar, int i, String str, C0231f c0231f, String str2, boolean z) {
        this.f4541f = haVar;
        this.f4536a = i;
        this.f4537b = str;
        this.f4538c = c0231f;
        this.f4539d = str2;
        this.f4540e = z;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g) {
        int i;
        int i2 = this.f4536a;
        i = this.f4541f.G;
        if (i2 != i) {
            return;
        }
        this.f4541f.a(this.f4537b, this.f4538c, this.f4539d, c0233g, this.f4540e, (AdobeCSDKException) null);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g, AdobeCSDKException adobeCSDKException) {
        int i;
        int i2 = this.f4536a;
        i = this.f4541f.G;
        if (i2 != i) {
            return;
        }
        this.f4541f.a(this.f4537b, this.f4538c, this.f4539d, c0233g, this.f4540e, adobeCSDKException);
    }
}
