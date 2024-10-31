package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class fa implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra f5402a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Handler f5403b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f5404c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f5405d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0351v f5406e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.F f5407f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ ra f5408g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ra raVar, ra raVar2, Handler handler, com.adobe.creativesdk.foundation.internal.net.j jVar, boolean z, C0351v c0351v, com.adobe.creativesdk.foundation.internal.net.F f2) {
        this.f5408g = raVar;
        this.f5402a = raVar2;
        this.f5403b = handler;
        this.f5404c = jVar;
        this.f5405d = z;
        this.f5406e = c0351v;
        this.f5407f = f2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 404 && g2 != 409 && g2 != 412) {
            this.f5407f.a(lVar);
        } else {
            new C0350u(this.f5408g, this.f5404c, this.f5403b, this.f5402a).a(this.f5405d, this.f5406e.f5480a, this.f5407f);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5407f.a(adobeNetworkException);
    }
}
