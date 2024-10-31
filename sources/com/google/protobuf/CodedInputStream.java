package com.google.protobuf;

import android.support.v7.widget.ActivityChooserView;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class CodedInputStream {

    /* renamed from: a */
    private final byte[] f18398a;

    /* renamed from: b */
    private final boolean f18399b;

    /* renamed from: c */
    private int f18400c;

    /* renamed from: d */
    private int f18401d;

    /* renamed from: e */
    private int f18402e;

    /* renamed from: f */
    private final InputStream f18403f;

    /* renamed from: g */
    private int f18404g;

    /* renamed from: h */
    private boolean f18405h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private a n;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    private CodedInputStream(byte[] bArr, int i, int i2, boolean z) {
        this.f18405h = false;
        this.j = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.l = 100;
        this.m = 67108864;
        this.n = null;
        this.f18398a = bArr;
        this.f18400c = i2 + i;
        this.f18402e = i;
        this.i = -i;
        this.f18403f = null;
        this.f18399b = z;
    }

    private void B() {
        this.f18400c += this.f18401d;
        int i = this.i;
        int i2 = this.f18400c;
        int i3 = i + i2;
        int i4 = this.j;
        if (i3 > i4) {
            this.f18401d = i3 - i4;
            this.f18400c = i2 - this.f18401d;
        } else {
            this.f18401d = 0;
        }
    }

    private void C() throws IOException {
        int i = this.f18400c;
        int i2 = this.f18402e;
        if (i - i2 >= 10) {
            byte[] bArr = this.f18398a;
            int i3 = 0;
            while (i3 < 10) {
                int i4 = i2 + 1;
                if (bArr[i2] >= 0) {
                    this.f18402e = i4;
                    return;
                } else {
                    i3++;
                    i2 = i4;
                }
            }
        }
        D();
    }

    private void D() throws IOException {
        for (int i = 0; i < 10; i++) {
            if (l() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream a(InputStream inputStream) {
        return new CodedInputStream(inputStream, 4096);
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public void A() throws IOException {
        int x;
        do {
            x = x();
            if (x == 0) {
                return;
            }
        } while (f(x));
    }

    public boolean b() throws IOException {
        return this.f18402e == this.f18400c && !k(1);
    }

    public boolean c() throws IOException {
        return p() != 0;
    }

    public ByteString d() throws IOException {
        ByteString copyFrom;
        int o = o();
        int i = this.f18400c;
        int i2 = this.f18402e;
        if (o > i - i2 || o <= 0) {
            if (o == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(h(o));
        }
        if (this.f18399b && this.f18405h) {
            copyFrom = ByteString.wrap(this.f18398a, i2, o);
        } else {
            copyFrom = ByteString.copyFrom(this.f18398a, this.f18402e, o);
        }
        this.f18402e += o;
        return copyFrom;
    }

    public double e() throws IOException {
        return Double.longBitsToDouble(n());
    }

    public boolean f(int i) throws IOException {
        int b2 = WireFormat.b(i);
        if (b2 == 0) {
            C();
            return true;
        }
        if (b2 == 1) {
            g(8);
            return true;
        }
        if (b2 == 2) {
            g(o());
            return true;
        }
        if (b2 == 3) {
            A();
            a(WireFormat.a(WireFormat.a(i), 4));
            return true;
        }
        if (b2 == 4) {
            return false;
        }
        if (b2 == 5) {
            g(4);
            return true;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public int g() throws IOException {
        return m();
    }

    public long h() throws IOException {
        return n();
    }

    public float i() throws IOException {
        return Float.intBitsToFloat(m());
    }

    public int j() throws IOException {
        return o();
    }

    public long k() throws IOException {
        return p();
    }

    public byte l() throws IOException {
        if (this.f18402e == this.f18400c) {
            i(1);
        }
        byte[] bArr = this.f18398a;
        int i = this.f18402e;
        this.f18402e = i + 1;
        return bArr[i];
    }

    public int m() throws IOException {
        int i = this.f18402e;
        if (this.f18400c - i < 4) {
            i(4);
            i = this.f18402e;
        }
        byte[] bArr = this.f18398a;
        this.f18402e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long n() throws IOException {
        int i = this.f18402e;
        if (this.f18400c - i < 8) {
            i(8);
            i = this.f18402e;
        }
        byte[] bArr = this.f18398a;
        this.f18402e = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:            if (r2[r3] < 0) goto L72;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int o() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f18402e
            int r1 = r5.f18400c
            if (r1 != r0) goto L7
            goto L6a
        L7:
            byte[] r2 = r5.f18398a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.f18402e = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L18
            goto L6a
        L18:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L24
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L70
        L24:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L31
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2f:
            r1 = r3
            goto L70
        L31:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L70
        L3f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L70
        L6a:
            long r0 = r5.q()
            int r1 = (int) r0
            return r1
        L70:
            r5.f18402e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.o():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:            if (r2[r0] < 0) goto L86;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long p() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.p():long");
    }

    long q() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((l() & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int r() throws IOException {
        return m();
    }

    public long s() throws IOException {
        return n();
    }

    public int t() throws IOException {
        return b(o());
    }

    public long u() throws IOException {
        return a(p());
    }

    public String v() throws IOException {
        int o = o();
        int i = this.f18400c;
        int i2 = this.f18402e;
        if (o <= i - i2 && o > 0) {
            String str = new String(this.f18398a, i2, o, Internal.f18617a);
            this.f18402e += o;
            return str;
        }
        if (o == 0) {
            return "";
        }
        if (o <= this.f18400c) {
            i(o);
            String str2 = new String(this.f18398a, this.f18402e, o, Internal.f18617a);
            this.f18402e += o;
            return str2;
        }
        return new String(h(o), Internal.f18617a);
    }

    public String w() throws IOException {
        byte[] h2;
        int o = o();
        int i = this.f18402e;
        int i2 = 0;
        if (o <= this.f18400c - i && o > 0) {
            h2 = this.f18398a;
            this.f18402e = i + o;
            i2 = i;
        } else {
            if (o == 0) {
                return "";
            }
            if (o <= this.f18400c) {
                i(o);
                h2 = this.f18398a;
                this.f18402e = o + 0;
            } else {
                h2 = h(o);
            }
        }
        if (Utf8.b(h2, i2, i2 + o)) {
            return new String(h2, i2, o, Internal.f18617a);
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int x() throws IOException {
        if (b()) {
            this.f18404g = 0;
            return 0;
        }
        this.f18404g = o();
        if (WireFormat.a(this.f18404g) != 0) {
            return this.f18404g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int y() throws IOException {
        return o();
    }

    public long z() throws IOException {
        return p();
    }

    public static CodedInputStream a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private byte[] h(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return Internal.f18619c;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.i;
        int i3 = this.f18402e;
        int i4 = i2 + i3 + i;
        if (i4 <= this.m) {
            int i5 = this.j;
            if (i4 <= i5) {
                InputStream inputStream = this.f18403f;
                if (inputStream != null) {
                    int i6 = this.f18400c;
                    int i7 = i6 - i3;
                    this.i = i2 + i6;
                    this.f18402e = 0;
                    this.f18400c = 0;
                    int i8 = i - i7;
                    if (i8 >= 4096 && i8 > inputStream.available()) {
                        ArrayList<byte[]> arrayList = new ArrayList();
                        while (i8 > 0) {
                            byte[] bArr = new byte[Math.min(i8, 4096)];
                            int i9 = 0;
                            while (i9 < bArr.length) {
                                int read = this.f18403f.read(bArr, i9, bArr.length - i9);
                                if (read == -1) {
                                    throw InvalidProtocolBufferException.truncatedMessage();
                                }
                                this.i += read;
                                i9 += read;
                            }
                            i8 -= bArr.length;
                            arrayList.add(bArr);
                        }
                        byte[] bArr2 = new byte[i];
                        System.arraycopy(this.f18398a, i3, bArr2, 0, i7);
                        for (byte[] bArr3 : arrayList) {
                            System.arraycopy(bArr3, 0, bArr2, i7, bArr3.length);
                            i7 += bArr3.length;
                        }
                        return bArr2;
                    }
                    byte[] bArr4 = new byte[i];
                    System.arraycopy(this.f18398a, i3, bArr4, 0, i7);
                    while (i7 < bArr4.length) {
                        int read2 = this.f18403f.read(bArr4, i7, i - i7);
                        if (read2 == -1) {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                        this.i += read2;
                        i7 += read2;
                    }
                    return bArr4;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            g((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    }

    private void i(int i) throws IOException {
        if (!k(i)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void j(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.i;
            int i3 = this.f18402e;
            int i4 = i2 + i3 + i;
            int i5 = this.j;
            if (i4 <= i5) {
                int i6 = this.f18400c;
                int i7 = i6 - i3;
                this.f18402e = i6;
                i(1);
                while (true) {
                    int i8 = i - i7;
                    int i9 = this.f18400c;
                    if (i8 > i9) {
                        i7 += i9;
                        this.f18402e = i9;
                        i(1);
                    } else {
                        this.f18402e = i8;
                        return;
                    }
                }
            } else {
                g((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private boolean k(int i) throws IOException {
        int i2 = this.f18402e;
        if (i2 + i > this.f18400c) {
            if (this.i + i2 + i > this.j) {
                return false;
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f18403f != null) {
                int i3 = this.f18402e;
                if (i3 > 0) {
                    int i4 = this.f18400c;
                    if (i4 > i3) {
                        byte[] bArr = this.f18398a;
                        System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                    }
                    this.i += i3;
                    this.f18400c -= i3;
                    this.f18402e = 0;
                }
                InputStream inputStream = this.f18403f;
                byte[] bArr2 = this.f18398a;
                int i5 = this.f18400c;
                int read = inputStream.read(bArr2, i5, bArr2.length - i5);
                if (read == 0 || read < -1 || read > this.f18398a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                }
                if (read > 0) {
                    this.f18400c += read;
                    if ((this.i + i) - this.m <= 0) {
                        B();
                        if (this.f18400c >= i) {
                            return true;
                        }
                        return k(i);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
        throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
    }

    public void c(int i) {
        this.j = i;
        B();
    }

    public int e(int i) {
        if (i >= 0) {
            int i2 = this.m;
            this.m = i;
            return i2;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i);
    }

    public void g(int i) throws IOException {
        int i2 = this.f18400c;
        int i3 = this.f18402e;
        if (i <= i2 - i3 && i >= 0) {
            this.f18402e = i3 + i;
        } else {
            j(i);
        }
    }

    public static CodedInputStream a(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2, false);
    }

    public static CodedInputStream a(byte[] bArr, int i, int i2, boolean z) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i, i2, z);
        try {
            codedInputStream.d(i2);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public void a(int i) throws InvalidProtocolBufferException {
        if (this.f18404g != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public void a(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.k;
        if (i2 < this.l) {
            this.k = i2 + 1;
            builder.a(this, extensionRegistryLite);
            a(WireFormat.a(i, 4));
            this.k--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int d(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i2 = i + this.i + this.f18402e;
            int i3 = this.j;
            if (i2 <= i3) {
                this.j = i2;
                B();
                return i3;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public int f() throws IOException {
        return o();
    }

    private CodedInputStream(InputStream inputStream, int i) {
        this.f18405h = false;
        this.j = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.l = 100;
        this.m = 67108864;
        this.n = null;
        this.f18398a = new byte[i];
        this.f18402e = 0;
        this.i = 0;
        this.f18403f = inputStream;
        this.f18399b = false;
    }

    public void a(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int o = o();
        if (this.k < this.l) {
            int d2 = d(o);
            this.k++;
            builder.a(this, extensionRegistryLite);
            a(0);
            this.k--;
            c(d2);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public <T extends MessageLite> T a(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int o = o();
        if (this.k < this.l) {
            int d2 = d(o);
            this.k++;
            T b2 = parser.b(this, extensionRegistryLite);
            a(0);
            this.k--;
            c(d2);
            return b2;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int a() {
        int i = this.j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.i + this.f18402e);
    }
}
