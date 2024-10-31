package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class Q implements lb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0231f f4223a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f4224b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(C0231f c0231f, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar) {
        this.f4223a = c0231f;
        this.f4224b = raVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb
    public com.adobe.creativesdk.foundation.internal.net.E a(Fa fa, boolean z, pb pbVar) {
        return this.f4224b.a(fa, this.f4223a, z, pbVar, (Handler) null);
    }
}
