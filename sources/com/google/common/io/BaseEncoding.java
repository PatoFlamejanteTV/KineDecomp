package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class BaseEncoding {

    /* renamed from: a */
    private static final BaseEncoding f15949a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* renamed from: b */
    private static final BaseEncoding f15950b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* renamed from: c */
    private static final BaseEncoding f15951c = new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* renamed from: d */
    private static final BaseEncoding f15952d = new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* renamed from: e */
    private static final BaseEncoding f15953e = new b("base16()", "0123456789ABCDEF");

    /* loaded from: classes2.dex */
    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }

        DecodingException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a extends CharMatcher {
        private final String o;
        private final char[] p;
        final int q;
        final int r;
        final int s;
        final int t;
        private final byte[] u;
        private final boolean[] v;

        a(String str, char[] cArr) {
            Preconditions.a(str);
            this.o = str;
            Preconditions.a(cArr);
            this.p = cArr;
            try {
                this.r = IntMath.a(cArr.length, RoundingMode.UNNECESSARY);
                int min = Math.min(8, Integer.lowestOneBit(this.r));
                try {
                    this.s = 8 / min;
                    this.t = this.r / min;
                    this.q = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c2 = cArr[i];
                        Preconditions.a(CharMatcher.b().d(c2), "Non-ASCII character: %s", c2);
                        Preconditions.a(bArr[c2] == -1, "Duplicate character: %s", c2);
                        bArr[c2] = (byte) i;
                    }
                    this.u = bArr;
                    boolean[] zArr = new boolean[this.s];
                    for (int i2 = 0; i2 < this.t; i2++) {
                        zArr[IntMath.a(i2 * 8, this.r, RoundingMode.CEILING)] = true;
                    }
                    this.v = zArr;
                } catch (ArithmeticException e2) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e2);
                }
            } catch (ArithmeticException e3) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e3);
            }
        }

        private boolean r() {
            for (char c2 : this.p) {
                if (Ascii.a(c2)) {
                    return true;
                }
            }
            return false;
        }

        private boolean s() {
            for (char c2 : this.p) {
                if (Ascii.b(c2)) {
                    return true;
                }
            }
            return false;
        }

        boolean b(int i) {
            return this.v[i % this.s];
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return CharMatcher.b().d(c2) && this.u[c2] != -1;
        }

        int e(char c2) throws DecodingException {
            Object valueOf;
            if (c2 <= 127) {
                byte[] bArr = this.u;
                if (bArr[c2] != -1) {
                    return bArr[c2];
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized character: ");
            if (CharMatcher.e().d(c2)) {
                valueOf = "0x" + Integer.toHexString(c2);
            } else {
                valueOf = Character.valueOf(c2);
            }
            sb.append(valueOf);
            throw new DecodingException(sb.toString());
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(this.p, ((a) obj).p);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.p);
        }

        a p() {
            if (!s()) {
                return this;
            }
            Preconditions.b(!r(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.p.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.p;
                if (i < cArr2.length) {
                    cArr[i] = Ascii.c(cArr2[i]);
                    i++;
                } else {
                    return new a(this.o + ".lowerCase()", cArr);
                }
            }
        }

        a q() {
            if (!r()) {
                return this;
            }
            Preconditions.b(!s(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.p.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.p;
                if (i < cArr2.length) {
                    cArr[i] = Ascii.d(cArr2[i]);
                    i++;
                } else {
                    return new a(this.o + ".upperCase()", cArr);
                }
            }
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.o;
        }

        char a(int i) {
            return this.p[i];
        }
    }

    /* loaded from: classes2.dex */
    static final class b extends d {
        final char[] j;

        b(String str, String str2) {
            this(new a(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.a(appendable);
            Preconditions.a(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.j[i4]);
                appendable.append(this.j[i4 | 256]);
            }
        }

        private b(a aVar) {
            super(aVar, null);
            this.j = new char[512];
            Preconditions.a(aVar.p.length == 16);
            for (int i = 0; i < 256; i++) {
                this.j[i] = aVar.a(i >>> 4);
                this.j[i | 256] = aVar.a(i & 15);
            }
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.a(bArr);
            if (charSequence.length() % 2 != 1) {
                int i = 0;
                int i2 = 0;
                while (i < charSequence.length()) {
                    bArr[i2] = (byte) ((this.f15954f.e(charSequence.charAt(i)) << 4) | this.f15954f.e(charSequence.charAt(i + 1)));
                    i += 2;
                    i2++;
                }
                return i2;
            }
            throw new DecodingException("Invalid input length " + charSequence.length());
        }

        @Override // com.google.common.io.BaseEncoding.d
        BaseEncoding a(a aVar, @Nullable Character ch) {
            return new b(aVar);
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends d {
        c(String str, String str2, @Nullable Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.a(appendable);
            int i3 = i + i2;
            Preconditions.a(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                appendable.append(this.f15954f.a(i6 >>> 18));
                appendable.append(this.f15954f.a((i6 >>> 12) & 63));
                appendable.append(this.f15954f.a((i6 >>> 6) & 63));
                appendable.append(this.f15954f.a(i6 & 63));
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                b(appendable, bArr, i, i3 - i);
            }
        }

        private c(a aVar, @Nullable Character ch) {
            super(aVar, ch);
            Preconditions.a(aVar.p.length == 64);
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.a(bArr);
            String f2 = d().f(charSequence);
            if (this.f15954f.b(f2.length())) {
                int i = 0;
                int i2 = 0;
                while (i < f2.length()) {
                    int i3 = i + 1;
                    int i4 = i3 + 1;
                    int e2 = (this.f15954f.e(f2.charAt(i)) << 18) | (this.f15954f.e(f2.charAt(i3)) << 12);
                    int i5 = i2 + 1;
                    bArr[i2] = (byte) (e2 >>> 16);
                    if (i4 < f2.length()) {
                        int i6 = i4 + 1;
                        int e3 = e2 | (this.f15954f.e(f2.charAt(i4)) << 6);
                        i2 = i5 + 1;
                        bArr[i5] = (byte) ((e3 >>> 8) & 255);
                        if (i6 < f2.length()) {
                            i4 = i6 + 1;
                            i5 = i2 + 1;
                            bArr[i2] = (byte) ((e3 | this.f15954f.e(f2.charAt(i6))) & 255);
                        } else {
                            i = i6;
                        }
                    }
                    i2 = i5;
                    i = i4;
                }
                return i2;
            }
            throw new DecodingException("Invalid input length " + f2.length());
        }

        @Override // com.google.common.io.BaseEncoding.d
        BaseEncoding a(a aVar, @Nullable Character ch) {
            return new c(aVar, ch);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d extends BaseEncoding {

        /* renamed from: f */
        final a f15954f;

        /* renamed from: g */
        @Nullable
        final Character f15955g;

        /* renamed from: h */
        private transient BaseEncoding f15956h;
        private transient BaseEncoding i;

        d(String str, String str2, @Nullable Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.a(appendable);
            Preconditions.a(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                b(appendable, bArr, i + i3, Math.min(this.f15954f.t, i2 - i3));
                i3 += this.f15954f.t;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        int b(int i) {
            a aVar = this.f15954f;
            return aVar.s * IntMath.a(i, aVar.t, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding c() {
            BaseEncoding baseEncoding = this.i;
            if (baseEncoding == null) {
                a p = this.f15954f.p();
                baseEncoding = p == this.f15954f ? this : a(p, this.f15955g);
                this.i = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        CharMatcher d() {
            Character ch = this.f15955g;
            return ch == null ? CharMatcher.m() : CharMatcher.b(ch.charValue());
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding e() {
            BaseEncoding baseEncoding = this.f15956h;
            if (baseEncoding == null) {
                a q = this.f15954f.q();
                baseEncoding = q == this.f15954f ? this : a(q, this.f15955g);
                this.f15956h = baseEncoding;
            }
            return baseEncoding;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f15954f.equals(dVar.f15954f) && Objects.a(this.f15955g, dVar.f15955g);
        }

        public int hashCode() {
            return this.f15954f.hashCode() ^ Objects.a(this.f15955g);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f15954f.toString());
            if (8 % this.f15954f.r != 0) {
                if (this.f15955g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f15955g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        d(a aVar, @Nullable Character ch) {
            Preconditions.a(aVar);
            this.f15954f = aVar;
            Preconditions.a(ch == null || !aVar.d(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f15955g = ch;
        }

        void b(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.a(appendable);
            Preconditions.a(i, i + i2, bArr.length);
            int i3 = 0;
            Preconditions.a(i2 <= this.f15954f.t);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | (bArr[i + i4] & 255)) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.f15954f.r;
            while (i3 < i2 * 8) {
                a aVar = this.f15954f;
                appendable.append(aVar.a(((int) (j >>> (i5 - i3))) & aVar.q));
                i3 += this.f15954f.r;
            }
            if (this.f15955g != null) {
                while (i3 < this.f15954f.t * 8) {
                    appendable.append(this.f15955g.charValue());
                    i3 += this.f15954f.r;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        int a(int i) {
            return (int) (((this.f15954f.r * i) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            a aVar;
            Preconditions.a(bArr);
            String f2 = d().f(charSequence);
            if (this.f15954f.b(f2.length())) {
                int i = 0;
                int i2 = 0;
                while (i < f2.length()) {
                    long j = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        aVar = this.f15954f;
                        if (i3 >= aVar.s) {
                            break;
                        }
                        j <<= aVar.r;
                        if (i + i3 < f2.length()) {
                            j |= this.f15954f.e(f2.charAt(i4 + i));
                            i4++;
                        }
                        i3++;
                    }
                    int i5 = aVar.t;
                    int i6 = (i5 * 8) - (i4 * aVar.r);
                    int i7 = (i5 - 1) * 8;
                    while (i7 >= i6) {
                        bArr[i2] = (byte) ((j >>> i7) & 255);
                        i7 -= 8;
                        i2++;
                    }
                    i += this.f15954f.s;
                }
                return i2;
            }
            throw new DecodingException("Invalid input length " + f2.length());
        }

        BaseEncoding a(a aVar, @Nullable Character ch) {
            return new d(aVar, ch);
        }
    }

    BaseEncoding() {
    }

    abstract int a(int i);

    abstract int a(byte[] bArr, CharSequence charSequence) throws DecodingException;

    public String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    abstract void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int b(int i);

    final byte[] b(CharSequence charSequence) throws DecodingException {
        String f2 = d().f(charSequence);
        byte[] bArr = new byte[a(f2.length())];
        return a(bArr, a(bArr, f2));
    }

    public abstract BaseEncoding c();

    abstract CharMatcher d();

    public abstract BaseEncoding e();

    public final String a(byte[] bArr, int i, int i2) {
        Preconditions.a(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(b(i2));
        try {
            a(sb, bArr, i, i2);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public static BaseEncoding b() {
        return f15949a;
    }

    private static byte[] a(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public final byte[] a(CharSequence charSequence) {
        try {
            return b(charSequence);
        } catch (DecodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static BaseEncoding a() {
        return f15953e;
    }
}
