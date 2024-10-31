package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressOutputStream.java */
/* loaded from: classes.dex */
public class af extends FilterOutputStream implements ah {

    /* renamed from: a, reason: collision with root package name */
    private final Map<GraphRequest, ai> f242a;
    private final GraphRequestBatch b;
    private final long c;
    private long d;
    private long e;
    private long f;
    private ai g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, ai> map, long j) {
        super(outputStream);
        this.b = graphRequestBatch;
        this.f242a = map;
        this.f = j;
        this.c = FacebookSdk.getOnProgressThreshold();
    }

    private void a(long j) {
        if (this.g != null) {
            this.g.a(j);
        }
        this.d += j;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            a();
        }
    }

    private void a() {
        if (this.d > this.e) {
            for (GraphRequestBatch.Callback callback : this.b.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.b.getCallbackHandler();
                    GraphRequestBatch.OnProgressCallback onProgressCallback = (GraphRequestBatch.OnProgressCallback) callback;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.b, this.d, this.f);
                    } else {
                        callbackHandler.post(new ag(this, onProgressCallback));
                    }
                }
            }
            this.e = this.d;
        }
    }

    @Override // com.facebook.ah
    public void a(GraphRequest graphRequest) {
        this.g = graphRequest != null ? this.f242a.get(graphRequest) : null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        a(bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        a(i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        a(1L);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<ai> it = this.f242a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        a();
    }
}
