package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class M implements Y.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0225c f4199a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4200b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0324c f4201c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f4202d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ db f4203e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Ab f4204f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f4205g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f4206h;
    final /* synthetic */ String i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(C0225c c0225c, C0231f c0231f, C0324c c0324c, boolean z, db dbVar, Ab ab, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, boolean z2, String str) {
        this.f4199a = c0225c;
        this.f4200b = c0231f;
        this.f4201c = c0324c;
        this.f4202d = z;
        this.f4203e = dbVar;
        this.f4204f = ab;
        this.f4205g = raVar;
        this.f4206h = z2;
        this.i = str;
    }

    public void a(String str) {
        long b2;
        b2 = Y.b(str, this.f4199a, this.f4200b);
        if (this.f4201c.c()) {
            AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled);
            if (this.f4202d) {
                this.f4203e.a(this.f4199a, this.f4200b, str, (String) null, adobeNetworkException);
            }
            this.f4204f.a(this.f4199a, null, this.f4200b, adobeNetworkException);
            return;
        }
        long j = b2 + 10;
        if (this.f4201c.g() < 0) {
            this.f4201c.b(j);
            this.f4201c.a(0L);
        } else {
            C0324c c0324c = this.f4201c;
            c0324c.b(c0324c.g() + j);
        }
        C0225c c0225c = this.f4199a;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer", "Calling  session.uploadComponent inside pushComponentsInManifest");
        com.adobe.creativesdk.foundation.internal.net.E a2 = this.f4205g.a(this.f4199a, this.f4200b, str, this.f4206h, new K(this, b2, c0225c, str), (Handler) null);
        if (a2 != null) {
            a2.a(new L(this, a2, str));
            this.f4201c.a(a2, j);
        }
    }
}
