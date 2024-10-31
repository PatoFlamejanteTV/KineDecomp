package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class y implements A.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f5180a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ InputStream f5181b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f5182c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ E f5183d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ F f5184e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Handler f5185f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ A f5186g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(A a2, j jVar, InputStream inputStream, m mVar, E e2, F f2, Handler handler) {
        this.f5186g = a2;
        this.f5180a = jVar;
        this.f5181b = inputStream;
        this.f5182c = mVar;
        this.f5183d = e2;
        this.f5184e = f2;
        this.f5185f = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.A.a
    public void a() {
        k kVar;
        if (this.f5186g.f()) {
            String c2 = this.f5186g.c();
            C0327f c0327f = new C0327f();
            c0327f.a(this.f5180a, c2, this.f5181b, this.f5182c, this.f5183d);
            try {
                kVar = this.f5186g.l;
                Future<l> submit = kVar.submit(c0327f);
                this.f5183d.a(c2);
                this.f5183d.a(submit);
                return;
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", null, e2);
                return;
            }
        }
        this.f5186g.a(this.f5184e, this.f5185f);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
