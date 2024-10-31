package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;

/* compiled from: IOContext.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    protected final Object f434a;
    protected JsonEncoding b;
    protected final boolean c;
    protected final BufferRecycler d;
    protected byte[] e = null;
    protected byte[] f = null;
    protected byte[] g = null;
    protected char[] h = null;
    protected char[] i = null;
    protected char[] j = null;

    public c(BufferRecycler bufferRecycler, Object obj, boolean z) {
        this.d = bufferRecycler;
        this.f434a = obj;
        this.c = z;
    }

    public void a(JsonEncoding jsonEncoding) {
        this.b = jsonEncoding;
    }

    public Object a() {
        return this.f434a;
    }

    public JsonEncoding b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public com.fasterxml.jackson.core.util.b d() {
        return new com.fasterxml.jackson.core.util.b(this.d);
    }

    public byte[] e() {
        if (this.e != null) {
            throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
        }
        this.e = this.d.a(BufferRecycler.ByteBufferType.READ_IO_BUFFER);
        return this.e;
    }

    public byte[] f() {
        if (this.f != null) {
            throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
        }
        this.f = this.d.a(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER);
        return this.f;
    }

    public char[] g() {
        if (this.h != null) {
            throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
        }
        this.h = this.d.a(BufferRecycler.CharBufferType.TOKEN_BUFFER);
        return this.h;
    }

    public char[] h() {
        if (this.i != null) {
            throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
        }
        this.i = this.d.a(BufferRecycler.CharBufferType.CONCAT_BUFFER);
        return this.i;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr != this.e) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.e = null;
            this.d.a(BufferRecycler.ByteBufferType.READ_IO_BUFFER, bArr);
        }
    }

    public void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr != this.f) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.f = null;
            this.d.a(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER, bArr);
        }
    }

    public void a(char[] cArr) {
        if (cArr != null) {
            if (cArr != this.h) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.h = null;
            this.d.a(BufferRecycler.CharBufferType.TOKEN_BUFFER, cArr);
        }
    }

    public void b(char[] cArr) {
        if (cArr != null) {
            if (cArr != this.i) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.i = null;
            this.d.a(BufferRecycler.CharBufferType.CONCAT_BUFFER, cArr);
        }
    }

    public void c(char[] cArr) {
        if (cArr != null) {
            if (cArr != this.j) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.j = null;
            this.d.a(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, cArr);
        }
    }
}
