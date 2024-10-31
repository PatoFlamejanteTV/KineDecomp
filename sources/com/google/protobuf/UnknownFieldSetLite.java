package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class UnknownFieldSetLite {

    /* renamed from: a, reason: collision with root package name */
    private static final UnknownFieldSetLite f18723a = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: b, reason: collision with root package name */
    private int f18724b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f18725c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f18726d;

    /* renamed from: e, reason: collision with root package name */
    private int f18727e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18728f;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite a(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i = unknownFieldSetLite.f18724b + unknownFieldSetLite2.f18724b;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.f18725c, i);
        System.arraycopy(unknownFieldSetLite2.f18725c, 0, copyOf, unknownFieldSetLite.f18724b, unknownFieldSetLite2.f18724b);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.f18726d, i);
        System.arraycopy(unknownFieldSetLite2.f18726d, 0, copyOf2, unknownFieldSetLite.f18724b, unknownFieldSetLite2.f18724b);
        return new UnknownFieldSetLite(i, copyOf, copyOf2, true);
    }

    public static UnknownFieldSetLite b() {
        return f18723a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite e() {
        return new UnknownFieldSetLite();
    }

    private void f() {
        int i = this.f18724b;
        if (i == this.f18725c.length) {
            int i2 = this.f18724b + (i < 4 ? 8 : i >> 1);
            this.f18725c = Arrays.copyOf(this.f18725c, i2);
            this.f18726d = Arrays.copyOf(this.f18726d, i2);
        }
    }

    public int c() {
        int c2;
        int i = this.f18727e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18724b; i3++) {
            int i4 = this.f18725c[i3];
            int a2 = WireFormat.a(i4);
            int b2 = WireFormat.b(i4);
            if (b2 == 0) {
                c2 = CodedOutputStream.c(a2, ((Long) this.f18726d[i3]).longValue());
            } else if (b2 == 1) {
                c2 = CodedOutputStream.a(a2, ((Long) this.f18726d[i3]).longValue());
            } else if (b2 == 2) {
                c2 = CodedOutputStream.a(a2, (ByteString) this.f18726d[i3]);
            } else if (b2 == 3) {
                c2 = (CodedOutputStream.i(a2) * 2) + ((UnknownFieldSetLite) this.f18726d[i3]).c();
            } else if (b2 == 5) {
                c2 = CodedOutputStream.b(a2, ((Integer) this.f18726d[i3]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
            }
            i2 += c2;
        }
        this.f18727e = i2;
        return i2;
    }

    public void d() {
        this.f18728f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        return this.f18724b == unknownFieldSetLite.f18724b && Arrays.equals(this.f18725c, unknownFieldSetLite.f18725c) && Arrays.deepEquals(this.f18726d, unknownFieldSetLite.f18726d);
    }

    public int hashCode() {
        return ((((527 + this.f18724b) * 31) + Arrays.hashCode(this.f18725c)) * 31) + Arrays.deepHashCode(this.f18726d);
    }

    private UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f18727e = -1;
        this.f18724b = i;
        this.f18725c = iArr;
        this.f18726d = objArr;
        this.f18728f = z;
    }

    void a() {
        if (!this.f18728f) {
            throw new UnsupportedOperationException();
        }
    }

    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18724b; i++) {
            int i2 = this.f18725c[i];
            int a2 = WireFormat.a(i2);
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                codedOutputStream.f(a2, ((Long) this.f18726d[i]).longValue());
            } else if (b2 == 1) {
                codedOutputStream.d(a2, ((Long) this.f18726d[i]).longValue());
            } else if (b2 == 2) {
                codedOutputStream.b(a2, (ByteString) this.f18726d[i]);
            } else if (b2 == 3) {
                codedOutputStream.h(a2, 3);
                ((UnknownFieldSetLite) this.f18726d[i]).a(codedOutputStream);
                codedOutputStream.h(a2, 4);
            } else if (b2 == 5) {
                codedOutputStream.f(a2, ((Integer) this.f18726d[i]).intValue());
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f18724b; i2++) {
            J.a(sb, i, String.valueOf(WireFormat.a(this.f18725c[i2])), this.f18726d[i2]);
        }
    }

    private void a(int i, Object obj) {
        f();
        int[] iArr = this.f18725c;
        int i2 = this.f18724b;
        iArr[i2] = i;
        this.f18726d[i2] = obj;
        this.f18724b = i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, CodedInputStream codedInputStream) throws IOException {
        a();
        int a2 = WireFormat.a(i);
        int b2 = WireFormat.b(i);
        if (b2 == 0) {
            a(i, Long.valueOf(codedInputStream.k()));
            return true;
        }
        if (b2 == 1) {
            a(i, Long.valueOf(codedInputStream.h()));
            return true;
        }
        if (b2 == 2) {
            a(i, codedInputStream.d());
            return true;
        }
        if (b2 == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.a(codedInputStream);
            codedInputStream.a(WireFormat.a(a2, 4));
            a(i, unknownFieldSetLite);
            return true;
        }
        if (b2 == 4) {
            return false;
        }
        if (b2 == 5) {
            a(i, Integer.valueOf(codedInputStream.g()));
            return true;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldSetLite a(int i, int i2) {
        a();
        if (i != 0) {
            a(WireFormat.a(i, 0), Long.valueOf(i2));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    private UnknownFieldSetLite a(CodedInputStream codedInputStream) throws IOException {
        int x;
        do {
            x = codedInputStream.x();
            if (x == 0) {
                break;
            }
        } while (a(x, codedInputStream));
        return this;
    }
}
