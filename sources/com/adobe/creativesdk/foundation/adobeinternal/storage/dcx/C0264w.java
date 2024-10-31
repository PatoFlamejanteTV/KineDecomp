package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0264w {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f4468a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4469b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f4470c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0264w(A a2, boolean z, String str) {
        this.f4470c = a2;
        this.f4468a = z;
        this.f4469b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AdobeCSDKException adobeCSDKException) {
        if (this.f4468a) {
            A a2 = this.f4470c;
            a2.f4102c.a(a2.f4103d, a2.f4105f, this.f4469b, adobeCSDKException);
        }
    }
}
