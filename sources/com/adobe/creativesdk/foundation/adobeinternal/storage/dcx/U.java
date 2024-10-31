package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class U implements Callable<com.adobe.creativesdk.foundation.internal.net.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0324c f4239a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4240b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Fa f4241c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f4242d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f4243e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ lb f4244f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Handler f4245g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ rb f4246h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(C0324c c0324c, C0231f c0231f, Fa fa, boolean z, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, lb lbVar, Handler handler, rb rbVar) {
        this.f4239a = c0324c;
        this.f4240b = c0231f;
        this.f4241c = fa;
        this.f4242d = z;
        this.f4243e = raVar;
        this.f4244f = lbVar;
        this.f4245g = handler;
        this.f4246h = rbVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.adobe.creativesdk.foundation.internal.net.l call() {
        try {
            this.f4239a.a(true);
            Y.a(this.f4240b, this.f4241c, this.f4242d, this.f4243e, this.f4239a, this.f4244f);
            if (this.f4245g != null) {
                this.f4245g.post(new T(this));
                return null;
            }
            this.f4239a.a(false);
            if (this.f4246h != null) {
                this.f4246h.onSuccess();
            }
            this.f4239a.e();
            this.f4239a.b(this.f4239a.g());
            return null;
        } catch (AdobeCSDKException e2) {
            this.f4239a.a(false);
            rb rbVar = this.f4246h;
            if (rbVar != null) {
                Y.b(rbVar, this.f4245g, e2);
            }
            this.f4239a.e();
            C0324c c0324c = this.f4239a;
            c0324c.b(c0324c.g());
            return null;
        }
    }
}
