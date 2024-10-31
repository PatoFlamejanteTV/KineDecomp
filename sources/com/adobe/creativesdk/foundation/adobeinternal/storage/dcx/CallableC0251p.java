package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class CallableC0251p implements Callable<com.adobe.creativesdk.foundation.internal.net.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0324c f4424a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4425b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ zb f4426c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ kb f4427d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Handler f4428e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ qb f4429f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC0251p(C0324c c0324c, C0231f c0231f, zb zbVar, kb kbVar, Handler handler, qb qbVar) {
        this.f4424a = c0324c;
        this.f4425b = c0231f;
        this.f4426c = zbVar;
        this.f4427d = kbVar;
        this.f4428e = handler;
        this.f4429f = qbVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.adobe.creativesdk.foundation.internal.net.l call() {
        try {
            this.f4424a.a(true);
            C0233g a2 = Y.a(this.f4425b, this.f4426c, this.f4424a, this.f4427d);
            if (this.f4428e != null) {
                this.f4428e.post(new RunnableC0249o(this, a2));
                return null;
            }
            this.f4424a.a(false);
            if (this.f4429f != null) {
                this.f4429f.a(a2);
            }
            this.f4424a.e();
            this.f4424a.b(this.f4424a.g());
            return null;
        } catch (AdobeCSDKException e2) {
            this.f4424a.a(false);
            qb qbVar = this.f4429f;
            if (qbVar != null) {
                Y.b(qbVar, this.f4428e, e2);
            }
            this.f4424a.e();
            C0324c c0324c = this.f4424a;
            c0324c.b(c0324c.g());
            return null;
        }
    }
}
