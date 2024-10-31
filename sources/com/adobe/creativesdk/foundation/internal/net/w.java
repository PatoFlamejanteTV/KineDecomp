package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class w implements A.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f5169a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5170b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f5171c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ E f5172d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ F f5173e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Handler f5174f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ A f5175g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(A a2, j jVar, String str, m mVar, E e2, F f2, Handler handler) {
        this.f5175g = a2;
        this.f5169a = jVar;
        this.f5170b = str;
        this.f5171c = mVar;
        this.f5172d = e2;
        this.f5173e = f2;
        this.f5174f = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.A.a
    public void a() {
        k kVar;
        if (this.f5175g.f()) {
            String c2 = this.f5175g.c();
            C0328g c0328g = new C0328g();
            c0328g.a(this.f5169a, c2, this.f5170b, this.f5171c, this.f5172d);
            try {
                kVar = this.f5175g.l;
                Future<l> submit = kVar.submit(c0328g);
                this.f5172d.a(c2);
                this.f5172d.a(submit);
                return;
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", null, e2);
                return;
            }
        }
        this.f5175g.a(this.f5173e, this.f5174f);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
