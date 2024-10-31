package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class s implements A.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f5148a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f5149b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ E f5150c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f5151d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Handler f5152e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ A f5153f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(A a2, j jVar, m mVar, E e2, F f2, Handler handler) {
        this.f5153f = a2;
        this.f5148a = jVar;
        this.f5149b = mVar;
        this.f5150c = e2;
        this.f5151d = f2;
        this.f5152e = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.A.a
    public void a() {
        k kVar;
        if (this.f5153f.f()) {
            C0325d c0325d = new C0325d();
            String c2 = this.f5153f.c();
            c0325d.a(this.f5148a, c2, this.f5149b, this.f5150c);
            try {
                kVar = this.f5153f.l;
                this.f5150c.a(kVar.submit(c0325d));
                this.f5150c.a(c2);
                return;
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", null, e2);
                return;
            }
        }
        this.f5153f.a(this.f5151d, this.f5152e);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
