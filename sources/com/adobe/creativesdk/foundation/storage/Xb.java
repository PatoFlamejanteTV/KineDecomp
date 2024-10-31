package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
public class Xb implements Callable<com.adobe.creativesdk.foundation.internal.net.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f7166a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Lb f7167b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.imageservice.t f7168c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f7169d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0324c f7170e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Handler f7171f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e f7172g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xb(boolean[] zArr, Lb lb, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, C0324c c0324c, Handler handler, com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar) {
        this.f7166a = zArr;
        this.f7167b = lb;
        this.f7168c = tVar;
        this.f7169d = raVar;
        this.f7170e = c0324c;
        this.f7171f = handler;
        this.f7172g = eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.adobe.creativesdk.foundation.internal.net.l call() {
        try {
            this.f7166a[0] = true;
            Mb b2 = _b.b(this.f7167b, this.f7168c, this.f7169d, this.f7170e);
            if (this.f7171f != null) {
                this.f7171f.post(new Wb(this, b2));
                return null;
            }
            if (this.f7172g != null) {
                this.f7172g.a(b2);
            }
            this.f7170e.e();
            this.f7170e.a(this.f7170e.g());
            return null;
        } catch (AdobeCSDKException e2) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar = this.f7172g;
            if (eVar != null) {
                _b.a(eVar, this.f7171f, e2);
            }
            this.f7170e.e();
            C0324c c0324c = this.f7170e;
            c0324c.a(c0324c.g());
            return null;
        }
    }
}
