package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class u implements A.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f5158a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5159b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f5160c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ E f5161d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ F f5162e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Handler f5163f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ A f5164g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(A a2, j jVar, String str, m mVar, E e2, F f2, Handler handler) {
        this.f5164g = a2;
        this.f5158a = jVar;
        this.f5159b = str;
        this.f5160c = mVar;
        this.f5161d = e2;
        this.f5162e = f2;
        this.f5163f = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.A.a
    public void a() {
        k kVar;
        if (this.f5164g.f()) {
            C0326e c0326e = new C0326e();
            String c2 = this.f5164g.c();
            c0326e.a(this.f5158a, c2, this.f5159b, this.f5160c, this.f5161d);
            try {
                kVar = this.f5164g.l;
                this.f5161d.a(kVar.submit(c0326e));
                this.f5161d.a(c2);
                return;
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", null, e2);
                return;
            }
        }
        this.f5164g.a(this.f5162e, this.f5163f);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
