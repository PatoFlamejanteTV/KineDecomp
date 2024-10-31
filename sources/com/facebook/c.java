package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressNoopOutputStream.java */
/* loaded from: classes.dex */
public class C extends OutputStream implements F {

    /* renamed from: a, reason: collision with root package name */
    private final Map<GraphRequest, H> f9118a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f9119b;

    /* renamed from: c, reason: collision with root package name */
    private GraphRequest f9120c;

    /* renamed from: d, reason: collision with root package name */
    private H f9121d;

    /* renamed from: e, reason: collision with root package name */
    private int f9122e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(Handler handler) {
        this.f9119b = handler;
    }

    @Override // com.facebook.F
    public void a(GraphRequest graphRequest) {
        this.f9120c = graphRequest;
        this.f9121d = graphRequest != null ? this.f9118a.get(graphRequest) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<GraphRequest, H> b() {
        return this.f9118a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(long j) {
        if (this.f9121d == null) {
            this.f9121d = new H(this.f9119b, this.f9120c);
            this.f9118a.put(this.f9120c, this.f9121d);
        }
        this.f9121d.b(j);
        this.f9122e = (int) (this.f9122e + j);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        g(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        g(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        g(1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f9122e;
    }
}
