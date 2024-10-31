package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class CallableC0256s implements Callable<com.adobe.creativesdk.foundation.internal.net.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0324c f4443a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f4444b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0231f f4445c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Fa f4446d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ zb f4447e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Handler f4448f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ qb f4449g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC0256s(C0324c c0324c, ArrayList arrayList, C0231f c0231f, Fa fa, zb zbVar, Handler handler, qb qbVar) {
        this.f4443a = c0324c;
        this.f4444b = arrayList;
        this.f4445c = c0231f;
        this.f4446d = fa;
        this.f4447e = zbVar;
        this.f4448f = handler;
        this.f4449g = qbVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.adobe.creativesdk.foundation.internal.net.l call() {
        C0233g b2;
        try {
            this.f4443a.a(true);
            b2 = Y.b(this.f4444b, this.f4445c, this.f4446d, this.f4447e, this.f4443a);
            if (this.f4448f != null) {
                this.f4448f.post(new r(this, b2));
                return null;
            }
            this.f4443a.a(false);
            if (this.f4449g != null) {
                this.f4449g.a(b2);
            }
            this.f4443a.e();
            this.f4443a.b(this.f4443a.g());
            return null;
        } catch (AdobeCSDKException e2) {
            this.f4443a.a(false);
            qb qbVar = this.f4449g;
            if (qbVar != null) {
                Y.b(qbVar, this.f4448f, e2);
            }
            this.f4443a.e();
            C0324c c0324c = this.f4443a;
            c0324c.b(c0324c.g());
            return null;
        }
    }
}
