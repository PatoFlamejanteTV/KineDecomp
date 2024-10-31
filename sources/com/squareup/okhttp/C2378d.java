package com.squareup.okhttp;

import com.squareup.okhttp.C2379e;
import com.squareup.okhttp.a.f;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Cache.java */
/* renamed from: com.squareup.okhttp.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2378d extends okio.k {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2379e f25221b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ f.a f25222c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C2379e.a f25223d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2378d(C2379e.a aVar, okio.y yVar, C2379e c2379e, f.a aVar2) {
        super(yVar);
        this.f25223d = aVar;
        this.f25221b = c2379e;
        this.f25222c = aVar2;
    }

    @Override // okio.k, okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        boolean z;
        synchronized (C2379e.this) {
            z = this.f25223d.f25233c;
            if (z) {
                return;
            }
            this.f25223d.f25233c = true;
            C2379e.b(C2379e.this);
            super.close();
            this.f25222c.b();
        }
    }
}
