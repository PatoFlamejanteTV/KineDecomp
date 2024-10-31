package com.squareup.okhttp;

import com.squareup.okhttp.C2379e;
import com.squareup.okhttp.a.f;
import java.io.IOException;

/* compiled from: Cache.java */
/* renamed from: com.squareup.okhttp.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2380f extends okio.l {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ f.c f25248b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2379e.b f25249c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2380f(C2379e.b bVar, okio.z zVar, f.c cVar) {
        super(zVar);
        this.f25249c = bVar;
        this.f25248b = cVar;
    }

    @Override // okio.l, okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25248b.close();
        super.close();
    }
}
