package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.B;
import okio.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpEngine.java */
/* loaded from: classes3.dex */
public class l implements z {

    /* renamed from: a, reason: collision with root package name */
    boolean f25459a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ okio.i f25460b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f25461c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ okio.h f25462d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ m f25463e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar, okio.i iVar, b bVar, okio.h hVar) {
        this.f25463e = mVar;
        this.f25460b = iVar;
        this.f25461c = bVar;
        this.f25462d = hVar;
    }

    @Override // okio.z
    public long b(okio.g gVar, long j) throws IOException {
        try {
            long b2 = this.f25460b.b(gVar, j);
            if (b2 == -1) {
                if (!this.f25459a) {
                    this.f25459a = true;
                    this.f25462d.close();
                }
                return -1L;
            }
            gVar.a(this.f25462d.d(), gVar.size() - b2, b2);
            this.f25462d.g();
            return b2;
        } catch (IOException e2) {
            if (!this.f25459a) {
                this.f25459a = true;
                this.f25461c.abort();
            }
            throw e2;
        }
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f25459a && !com.squareup.okhttp.a.o.a(this, 100, TimeUnit.MILLISECONDS)) {
            this.f25459a = true;
            this.f25461c.abort();
        }
        this.f25460b.close();
    }

    @Override // okio.z
    public B e() {
        return this.f25460b.e();
    }
}
