package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProgressOutputStream.java */
/* loaded from: classes.dex */
public class E extends FilterOutputStream implements F {

    /* renamed from: a */
    private final Map<GraphRequest, H> f9125a;

    /* renamed from: b */
    private final GraphRequestBatch f9126b;

    /* renamed from: c */
    private final long f9127c;

    /* renamed from: d */
    private long f9128d;

    /* renamed from: e */
    private long f9129e;

    /* renamed from: f */
    private long f9130f;

    /* renamed from: g */
    private H f9131g;

    public E(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, H> map, long j) {
        super(outputStream);
        this.f9126b = graphRequestBatch;
        this.f9125a = map;
        this.f9130f = j;
        this.f9127c = FacebookSdk.getOnProgressThreshold();
    }

    private void g(long j) {
        H h2 = this.f9131g;
        if (h2 != null) {
            h2.a(j);
        }
        this.f9128d += j;
        long j2 = this.f9128d;
        if (j2 >= this.f9129e + this.f9127c || j2 >= this.f9130f) {
            a();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<H> it = this.f9125a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        a();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        ((FilterOutputStream) this).out.write(bArr);
        g(bArr.length);
    }

    private void a() {
        if (this.f9128d > this.f9129e) {
            for (GraphRequestBatch.Callback callback : this.f9126b.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.f9126b.getCallbackHandler();
                    GraphRequestBatch.OnProgressCallback onProgressCallback = (GraphRequestBatch.OnProgressCallback) callback;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.f9126b, this.f9128d, this.f9130f);
                    } else {
                        callbackHandler.post(new D(this, onProgressCallback));
                    }
                }
            }
            this.f9129e = this.f9128d;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        g(i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        g(1L);
    }

    @Override // com.facebook.F
    public void a(GraphRequest graphRequest) {
        this.f9131g = graphRequest != null ? this.f9125a.get(graphRequest) : null;
    }
}
