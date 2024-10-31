package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.I;
import com.squareup.okhttp.x;

/* compiled from: RealResponseBody.java */
/* loaded from: classes3.dex */
public final class r extends I {

    /* renamed from: a, reason: collision with root package name */
    private final x f25482a;

    /* renamed from: b, reason: collision with root package name */
    private final okio.i f25483b;

    public r(x xVar, okio.i iVar) {
        this.f25482a = xVar;
        this.f25483b = iVar;
    }

    @Override // com.squareup.okhttp.I
    public long b() {
        return q.a(this.f25482a);
    }

    @Override // com.squareup.okhttp.I
    public okio.i c() {
        return this.f25483b;
    }
}
