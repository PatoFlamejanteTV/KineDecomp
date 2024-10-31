package com.android.volley;

import com.android.volley.p;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f8076a;

    /* renamed from: b */
    final /* synthetic */ long f8077b;

    /* renamed from: c */
    final /* synthetic */ Request f8078c;

    public k(Request request, String str, long j) {
        this.f8078c = request;
        this.f8076a = str;
        this.f8077b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        p.a aVar;
        p.a aVar2;
        aVar = this.f8078c.f7973a;
        aVar.a(this.f8076a, this.f8077b);
        aVar2 = this.f8078c.f7973a;
        aVar2.a(toString());
    }
}
