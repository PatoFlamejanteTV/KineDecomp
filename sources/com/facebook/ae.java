package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressNoopOutputStream.java */
/* loaded from: classes.dex */
public class ae extends OutputStream implements ah {

    /* renamed from: a, reason: collision with root package name */
    private final Map<GraphRequest, ai> f241a = new HashMap();
    private final Handler b;
    private GraphRequest c;
    private ai d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Handler handler) {
        this.b = handler;
    }

    @Override // com.facebook.ah
    public void a(GraphRequest graphRequest) {
        this.c = graphRequest;
        this.d = graphRequest != null ? this.f241a.get(graphRequest) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<GraphRequest, ai> b() {
        return this.f241a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (this.d == null) {
            this.d = new ai(this.b, this.c);
            this.f241a.put(this.c, this.d);
        }
        this.d.b(j);
        this.e = (int) (this.e + j);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        a(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        a(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        a(1L);
    }
}
