package com.squareup.okhttp;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Cache.java */
/* renamed from: com.squareup.okhttp.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2377c implements com.squareup.okhttp.a.i {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2379e f25220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2377c(C2379e c2379e) {
        this.f25220a = c2379e;
    }

    @Override // com.squareup.okhttp.a.i
    public H a(E e2) throws IOException {
        return this.f25220a.a(e2);
    }

    @Override // com.squareup.okhttp.a.i
    public void b(E e2) throws IOException {
        this.f25220a.b(e2);
    }

    @Override // com.squareup.okhttp.a.i
    public com.squareup.okhttp.internal.http.b a(H h2) throws IOException {
        com.squareup.okhttp.internal.http.b a2;
        a2 = this.f25220a.a(h2);
        return a2;
    }

    @Override // com.squareup.okhttp.a.i
    public void a(H h2, H h3) throws IOException {
        this.f25220a.a(h2, h3);
    }

    @Override // com.squareup.okhttp.a.i
    public void a() {
        this.f25220a.a();
    }

    @Override // com.squareup.okhttp.a.i
    public void a(com.squareup.okhttp.internal.http.d dVar) {
        this.f25220a.a(dVar);
    }
}
