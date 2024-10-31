package com.squareup.wire;

import android.support.v7.widget.ActivityChooserView;
import com.umeng.commonsdk.proguard.ap;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WireInput.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f25743a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final okio.i f25744b;

    /* renamed from: c, reason: collision with root package name */
    private int f25745c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f25746d = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* renamed from: e, reason: collision with root package name */
    public int f25747e;

    /* renamed from: f, reason: collision with root package name */
    private int f25748f;

    private u(okio.i iVar) {
        this.f25744b = iVar;
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static u a(byte[] bArr) {
        okio.g gVar = new okio.g();
        gVar.write(bArr);
        return new u(gVar);
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    private boolean j() throws IOException {
        if (a() == this.f25746d) {
            return true;
        }
        return this.f25744b.l();
    }

    public ByteString b() throws IOException {
        return e(g());
    }

    public int c() throws IOException {
        this.f25745c += 4;
        return this.f25744b.n();
    }

    public long d() throws IOException {
        this.f25745c += 8;
        return this.f25744b.j();
    }

    public String e() throws IOException {
        int g2 = g();
        this.f25745c += g2;
        return this.f25744b.a(g2, f25743a);
    }

    public int f() throws IOException {
        if (j()) {
            this.f25748f = 0;
            return 0;
        }
        this.f25748f = g();
        int i = this.f25748f;
        if (i != 0) {
            return i;
        }
        throw new IOException("Protocol message contained an invalid tag (zero).");
    }

    public int g() throws IOException {
        int i;
        this.f25745c++;
        byte readByte = this.f25744b.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i2 = readByte & Byte.MAX_VALUE;
        this.f25745c++;
        byte readByte2 = this.f25744b.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            i2 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.f25745c++;
            byte readByte3 = this.f25744b.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << ap.l;
            } else {
                i2 |= (readByte3 & Byte.MAX_VALUE) << 14;
                this.f25745c++;
                byte readByte4 = this.f25744b.readByte();
                if (readByte4 < 0) {
                    int i3 = i2 | ((readByte4 & Byte.MAX_VALUE) << 21);
                    this.f25745c++;
                    byte readByte5 = this.f25744b.readByte();
                    int i4 = i3 | (readByte5 << 28);
                    if (readByte5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.f25745c++;
                        if (this.f25744b.readByte() >= 0) {
                            return i4;
                        }
                    }
                    throw new IOException("WireInput encountered a malformed varint.");
                }
                i = readByte4 << 21;
            }
        }
        return i2 | i;
    }

    public long h() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            this.f25745c++;
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((this.f25744b.readByte() & 128) == 0) {
                return j;
            }
        }
        throw new IOException("WireInput encountered a malformed varint.");
    }

    public void i() throws IOException {
        int f2;
        do {
            f2 = f();
            if (f2 == 0) {
                return;
            }
        } while (!f(f2));
    }

    public static u a(InputStream inputStream) {
        return new u(okio.s.a(okio.s.a(inputStream)));
    }

    private void b(long j) throws IOException {
        this.f25745c = (int) (this.f25745c + j);
        this.f25744b.skip(j);
    }

    public void a(int i) throws IOException {
        if (this.f25748f != i) {
            throw new IOException("Protocol message end-group tag did not match expected tag.");
        }
    }

    public void c(int i) {
        this.f25746d = i;
    }

    public int d(int i) throws IOException {
        if (i >= 0) {
            int i2 = i + this.f25745c;
            int i3 = this.f25746d;
            if (i2 <= i3) {
                this.f25746d = i2;
                return i3;
            }
            throw new EOFException("The input ended unexpectedly in the middle of a field");
        }
        throw new IOException("Encountered a negative size");
    }

    public ByteString e(int i) throws IOException {
        this.f25745c += i;
        long j = i;
        this.f25744b.c(j);
        return this.f25744b.e(j);
    }

    public long a() {
        return this.f25745c;
    }

    private boolean f(int i) throws IOException {
        switch (t.f25742a[WireType.valueOf(i).ordinal()]) {
            case 1:
                h();
                return false;
            case 2:
                c();
                return false;
            case 3:
                d();
                return false;
            case 4:
                b(g());
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
}
