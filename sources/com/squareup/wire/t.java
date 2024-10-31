package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import okio.ByteString;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WireInput.java */
/* loaded from: classes.dex */
public final class t {
    private static final Charset b = Charset.forName(Keyczar.DEFAULT_ENCODING);

    /* renamed from: a, reason: collision with root package name */
    public int f4871a;
    private final okio.d c;
    private int d = 0;
    private int e = Integer.MAX_VALUE;
    private int f;

    public static t a(byte[] bArr) {
        return new t(new okio.b().b(bArr));
    }

    public static t a(InputStream inputStream) {
        return new t(okio.e.a(okio.e.a(inputStream)));
    }

    public int a() throws IOException {
        if (j()) {
            this.f = 0;
            return 0;
        }
        this.f = d();
        if (this.f == 0) {
            throw new IOException("Protocol message contained an invalid tag (zero).");
        }
        return this.f;
    }

    public void a(int i) throws IOException {
        if (this.f != i) {
            throw new IOException("Protocol message end-group tag did not match expected tag.");
        }
    }

    public String b() throws IOException {
        int d = d();
        this.d += d;
        return this.c.a(d, b);
    }

    public ByteString c() throws IOException {
        return b(d());
    }

    public ByteString b(int i) throws IOException {
        this.d += i;
        this.c.a(i);
        return this.c.b(i);
    }

    public int d() throws IOException {
        this.d++;
        byte c = this.c.c();
        if (c < 0) {
            int i = c & Byte.MAX_VALUE;
            this.d++;
            byte c2 = this.c.c();
            if (c2 >= 0) {
                return i | (c2 << 7);
            }
            int i2 = i | ((c2 & Byte.MAX_VALUE) << 7);
            this.d++;
            byte c3 = this.c.c();
            if (c3 >= 0) {
                return i2 | (c3 << 14);
            }
            int i3 = i2 | ((c3 & Byte.MAX_VALUE) << 14);
            this.d++;
            byte c4 = this.c.c();
            if (c4 >= 0) {
                return i3 | (c4 << 21);
            }
            int i4 = i3 | ((c4 & Byte.MAX_VALUE) << 21);
            this.d++;
            byte c5 = this.c.c();
            int i5 = i4 | (c5 << 28);
            if (c5 < 0) {
                for (int i6 = 0; i6 < 5; i6++) {
                    this.d++;
                    if (this.c.c() >= 0) {
                        return i5;
                    }
                }
                throw new IOException("WireInput encountered a malformed varint.");
            }
            return i5;
        }
        return c;
    }

    public long e() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            this.d++;
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((this.c.c() & 128) == 0) {
                return j;
            }
        }
        throw new IOException("WireInput encountered a malformed varint.");
    }

    public int f() throws IOException {
        this.d += 4;
        return this.c.f();
    }

    public long g() throws IOException {
        this.d += 8;
        return this.c.g();
    }

    public static int c(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long a(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private t(okio.d dVar) {
        this.c = dVar;
    }

    public int d(int i) throws IOException {
        if (i < 0) {
            throw new IOException("Encountered a negative size");
        }
        int i2 = this.d + i;
        int i3 = this.e;
        if (i2 > i3) {
            throw new EOFException("The input ended unexpectedly in the middle of a field");
        }
        this.e = i2;
        return i3;
    }

    public void e(int i) {
        this.e = i;
    }

    private boolean j() throws IOException {
        if (h() == this.e) {
            return true;
        }
        return this.c.b();
    }

    public long h() {
        return this.d;
    }

    public void i() throws IOException {
        int a2;
        do {
            a2 = a();
            if (a2 == 0) {
                return;
            }
        } while (!f(a2));
    }

    private boolean f(int i) throws IOException {
        switch (u.f4872a[WireType.valueOf(i).ordinal()]) {
            case 1:
                e();
                return false;
            case 2:
                f();
                return false;
            case 3:
                g();
                return false;
            case 4:
                b(d());
                return false;
            case 5:
                i();
                a((i & (-8)) | WireType.END_GROUP.value());
                return false;
            case 6:
                return true;
            default:
                throw new AssertionError();
        }
    }

    private void b(long j) throws IOException {
        this.d = (int) (this.d + j);
        this.c.d(j);
    }
}
