package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.ArrayList;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class n implements A.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f5127a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f5128b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ E f5129c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f5130d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ArrayList f5131e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ F f5132f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Handler f5133g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ A f5134h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(A a2, j jVar, m mVar, E e2, String str, ArrayList arrayList, F f2, Handler handler) {
        this.f5134h = a2;
        this.f5127a = jVar;
        this.f5128b = mVar;
        this.f5129c = e2;
        this.f5130d = str;
        this.f5131e = arrayList;
        this.f5132f = f2;
        this.f5133g = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.A.a
    public void a() {
        k kVar;
        if (this.f5134h.f()) {
            String c2 = this.f5134h.c();
            i iVar = new i();
            iVar.a(this.f5127a, c2, this.f5128b, this.f5129c, this.f5130d, this.f5131e);
            try {
                kVar = this.f5134h.l;
                Future<l> submit = kVar.submit(iVar);
                this.f5129c.a(c2);
                this.f5129c.a(submit);
                return;
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", null, e2);
                return;
            }
        }
        this.f5134h.a(this.f5132f, this.f5133g);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
