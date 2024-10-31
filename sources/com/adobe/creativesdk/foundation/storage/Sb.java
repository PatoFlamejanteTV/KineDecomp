package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
public class Sb implements Callable<com.adobe.creativesdk.foundation.internal.net.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lb f7112a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa f7113b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f7114c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f7115d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0324c f7116e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb f7117f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Handler f7118g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f f7119h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sb(Lb lb, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa, boolean z, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, C0324c c0324c, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb lbVar, Handler handler, com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f fVar) {
        this.f7112a = lb;
        this.f7113b = fa;
        this.f7114c = z;
        this.f7115d = raVar;
        this.f7116e = c0324c;
        this.f7117f = lbVar;
        this.f7118g = handler;
        this.f7119h = fVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.adobe.creativesdk.foundation.internal.net.l call() {
        try {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a(this.f7112a.c(), this.f7113b, this.f7114c, this.f7115d, this.f7116e, this.f7117f);
            if (this.f7118g != null) {
                this.f7118g.post(new Rb(this));
            } else {
                this.f7116e.e();
                this.f7116e.a(this.f7116e.g());
                if (this.f7119h != null) {
                    this.f7119h.a(true);
                }
            }
            return null;
        } catch (AdobeCSDKException e2) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f fVar = this.f7119h;
            if (fVar != null) {
                _b.a(fVar, this.f7118g, e2);
            }
            this.f7116e.e();
            C0324c c0324c = this.f7116e;
            c0324c.a(c0324c.g());
            return null;
        }
    }
}
