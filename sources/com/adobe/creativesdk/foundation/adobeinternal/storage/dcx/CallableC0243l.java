package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class CallableC0243l implements Callable<com.adobe.creativesdk.foundation.internal.net.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0324c f4404a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4405b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ zb f4406c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f4407d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ qb f4408e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC0243l(C0324c c0324c, C0231f c0231f, zb zbVar, Handler handler, qb qbVar) {
        this.f4404a = c0324c;
        this.f4405b = c0231f;
        this.f4406c = zbVar;
        this.f4407d = handler;
        this.f4408e = qbVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.adobe.creativesdk.foundation.internal.net.l call() {
        C0233g b2;
        try {
            this.f4404a.a(true);
            b2 = Y.b(this.f4405b, this.f4406c, this.f4404a);
            if (this.f4407d != null) {
                this.f4407d.post(new RunnableC0241k(this, b2));
                return null;
            }
            this.f4404a.a(false);
            if (this.f4408e != null) {
                this.f4408e.a(b2);
            }
            this.f4404a.e();
            this.f4404a.b(this.f4404a.g());
            return null;
        } catch (AdobeCSDKException e2) {
            this.f4404a.a(false);
            qb qbVar = this.f4408e;
            if (qbVar != null) {
                Y.b(qbVar, this.f4407d, e2);
            }
            this.f4404a.e();
            C0324c c0324c = this.f4404a;
            c0324c.b(c0324c.g());
            return null;
        }
    }
}
