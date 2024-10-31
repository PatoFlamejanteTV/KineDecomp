package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class O implements Y.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0225c f4211a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4212b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0324c f4213c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f4214d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Ab f4215e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f4216f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f4217g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f4218h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(C0225c c0225c, C0231f c0231f, C0324c c0324c, boolean z, Ab ab, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, String str, boolean z2) {
        this.f4211a = c0225c;
        this.f4212b = c0231f;
        this.f4213c = c0324c;
        this.f4214d = z;
        this.f4215e = ab;
        this.f4216f = raVar;
        this.f4217g = str;
        this.f4218h = z2;
    }

    public void a(String str) {
        long b2;
        b2 = Y.b(str, this.f4211a, this.f4212b);
        if (this.f4213c.c()) {
            if (this.f4214d) {
                return;
            }
            this.f4215e.a(this.f4211a, null, this.f4212b, new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled));
            return;
        }
        long j = b2 + 10;
        if (this.f4213c.g() < 0) {
            this.f4213c.b(j);
            this.f4213c.a(0L);
        } else {
            C0324c c0324c = this.f4213c;
            c0324c.b(c0324c.g() + j);
        }
        com.adobe.creativesdk.foundation.internal.net.E a2 = this.f4216f.a(this.f4217g, this.f4211a, this.f4212b, this.f4218h, new N(this), (Handler) null);
        if (a2 != null) {
            this.f4213c.a(a2, j);
        }
    }
}
