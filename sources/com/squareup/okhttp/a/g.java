package com.squareup.okhttp.a;

import java.io.IOException;
import okio.y;

/* compiled from: FaultHidingSink.java */
/* loaded from: classes3.dex */
class g extends okio.k {

    /* renamed from: b */
    private boolean f25190b;

    public g(y yVar) {
        super(yVar);
    }

    protected void a(IOException iOException) {
        throw null;
    }

    @Override // okio.k, okio.y
    public void a(okio.g gVar, long j) throws IOException {
        if (this.f25190b) {
            gVar.skip(j);
            return;
        }
        try {
            super.a(gVar, j);
        } catch (IOException e2) {
            this.f25190b = true;
            a(e2);
        }
    }

    @Override // okio.k, okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f25190b) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.f25190b = true;
            a(e2);
        }
    }

    @Override // okio.k, okio.y, java.io.Flushable
    public void flush() throws IOException {
        if (this.f25190b) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.f25190b = true;
            a(e2);
        }
    }
}
