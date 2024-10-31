package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: Metadata.java */
@NotThreadSafe
/* loaded from: classes3.dex */
public final class P {

    /* renamed from: a */
    public static final d<byte[]> f27116a = new N();

    /* renamed from: b */
    public static final b<String> f27117b = new O();

    /* renamed from: c */
    private byte[][] f27118c;

    /* renamed from: d */
    private int f27119d;

    /* compiled from: Metadata.java */
    /* loaded from: classes3.dex */
    public static class a<T> extends e<T> {

        /* renamed from: e */
        private final b<T> f27120e;

        /* synthetic */ a(String str, boolean z, b bVar, N n) {
            this(str, z, bVar);
        }

        @Override // io.grpc.P.e
        byte[] a(T t) {
            return this.f27120e.a((b<T>) t).getBytes(Charsets.f15076a);
        }

        private a(String str, boolean z, b<T> bVar) {
            super(str, z, null);
            Preconditions.a(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            Preconditions.a(bVar, "marshaller");
            this.f27120e = bVar;
        }

        @Override // io.grpc.P.e
        T a(byte[] bArr) {
            return this.f27120e.a(new String(bArr, Charsets.f15076a));
        }
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes3.dex */
    public interface b<T> {
        T a(String str);

        String a(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Metadata.java */
    /* loaded from: classes3.dex */
    public static class c<T> extends e<T> {

        /* renamed from: e */
        private final d<T> f27121e;

        /* synthetic */ c(String str, d dVar, N n) {
            this(str, dVar);
        }

        @Override // io.grpc.P.e
        byte[] a(T t) {
            return this.f27121e.toBytes(t);
        }

        private c(String str, d<T> dVar) {
            super(str, false, null);
            Preconditions.a(str.endsWith("-bin"), "Binary header is named %s. It must end with %s", str, "-bin");
            Preconditions.a(str.length() > 4, "empty key name");
            Preconditions.a(dVar, "marshaller is null");
            this.f27121e = dVar;
        }

        @Override // io.grpc.P.e
        T a(byte[] bArr) {
            return this.f27121e.a(bArr);
        }
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes3.dex */
    public interface d<T> {
        T a(byte[] bArr);

        byte[] toBytes(T t);
    }

    /* compiled from: Metadata.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static abstract class e<T> {

        /* renamed from: a */
        private static final BitSet f27122a = c();

        /* renamed from: b */
        private final String f27123b;

        /* renamed from: c */
        private final String f27124c;

        /* renamed from: d */
        private final byte[] f27125d;

        /* synthetic */ e(String str, boolean z, N n) {
            this(str, z);
        }

        public static <T> e<T> a(String str, d<T> dVar) {
            return new c(str, dVar, null);
        }

        private static BitSet c() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
                bitSet.set(c2);
            }
            for (char c3 = 'a'; c3 <= 'z'; c3 = (char) (c3 + 1)) {
                bitSet.set(c3);
            }
            return bitSet;
        }

        abstract T a(byte[] bArr);

        abstract byte[] a(T t);

        public final String b() {
            return this.f27124c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f27124c.equals(((e) obj).f27124c);
        }

        public int hashCode() {
            return this.f27124c.hashCode();
        }

        public String toString() {
            return "Key{name='" + this.f27124c + "'}";
        }

        private e(String str, boolean z) {
            Preconditions.a(str, "name");
            this.f27123b = str;
            String lowerCase = this.f27123b.toLowerCase(Locale.ROOT);
            a(lowerCase, z);
            this.f27124c = lowerCase;
            this.f27125d = this.f27124c.getBytes(Charsets.f15076a);
        }

        public static <T> e<T> a(String str, b<T> bVar) {
            return a(str, false, (b) bVar);
        }

        static <T> e<T> a(String str, boolean z, b<T> bVar) {
            return new a(str, z, bVar, null);
        }

        public static <T> e<T> a(String str, boolean z, g<T> gVar) {
            return new f(str, z, gVar, null);
        }

        private static String a(String str, boolean z) {
            Preconditions.a(str, "name");
            Preconditions.a(!str.isEmpty(), "token must have at least 1 tchar");
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!z || charAt != ':' || i != 0) {
                    Preconditions.a(f27122a.get(charAt), "Invalid character '%s' in key name '%s'", charAt, (Object) str);
                }
            }
            return str;
        }

        @VisibleForTesting
        byte[] a() {
            return this.f27125d;
        }
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes3.dex */
    public static final class f<T> extends e<T> {

        /* renamed from: e */
        private final g<T> f27126e;

        /* synthetic */ f(String str, boolean z, g gVar, N n) {
            this(str, z, gVar);
        }

        @Override // io.grpc.P.e
        byte[] a(T t) {
            return this.f27126e.a((g<T>) t);
        }

        private f(String str, boolean z, g<T> gVar) {
            super(str, z, null);
            Preconditions.a(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            Preconditions.a(gVar, "marshaller");
            this.f27126e = gVar;
        }

        @Override // io.grpc.P.e
        T a(byte[] bArr) {
            return this.f27126e.a(bArr);
        }
    }

    /* compiled from: Metadata.java */
    @Immutable
    /* loaded from: classes3.dex */
    public interface g<T> {
        T a(byte[] bArr);

        byte[] a(T t);
    }

    public P(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    private void a(int i, byte[] bArr) {
        this.f27118c[i * 2] = bArr;
    }

    private byte[] b(int i) {
        return this.f27118c[i * 2];
    }

    private byte[] c(int i) {
        return this.f27118c[(i * 2) + 1];
    }

    private boolean d() {
        return this.f27119d == 0;
    }

    private int e() {
        return this.f27119d * 2;
    }

    private void f() {
        if (e() == 0 || e() == c()) {
            a(Math.max(e() * 2, 8));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i = 0; i < this.f27119d; i++) {
            if (i != 0) {
                sb.append(',');
            }
            String str = new String(b(i), Charsets.f15076a);
            sb.append(str);
            sb.append('=');
            if (str.endsWith("-bin")) {
                sb.append(BaseEncoding.b().a(c(i)));
            } else {
                sb.append(new String(c(i), Charsets.f15076a));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    P(int i, byte[]... bArr) {
        this.f27119d = i;
        this.f27118c = bArr;
    }

    private void b(int i, byte[] bArr) {
        this.f27118c[(i * 2) + 1] = bArr;
    }

    private int c() {
        byte[][] bArr = this.f27118c;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public int a() {
        return this.f27119d;
    }

    public <T> void a(e<T> eVar, T t) {
        Preconditions.a(eVar, "key");
        Preconditions.a(t, "value");
        f();
        a(this.f27119d, eVar.a());
        b(this.f27119d, eVar.a((e<T>) t));
        this.f27119d++;
    }

    @Nullable
    public <T> T b(e<T> eVar) {
        for (int i = this.f27119d - 1; i >= 0; i--) {
            if (a(eVar.a(), b(i))) {
                return eVar.a(c(i));
            }
        }
        return null;
    }

    public P() {
    }

    @Nullable
    public byte[][] b() {
        if (e() == c()) {
            return this.f27118c;
        }
        byte[][] bArr = new byte[e()];
        System.arraycopy(this.f27118c, 0, bArr, 0, e());
        return bArr;
    }

    private void a(int i) {
        byte[][] bArr = new byte[i];
        if (!d()) {
            System.arraycopy(this.f27118c, 0, bArr, 0, e());
        }
        this.f27118c = bArr;
    }

    public <T> void a(e<T> eVar) {
        if (d()) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f27119d; i2++) {
            if (!a(eVar.a(), b(i2))) {
                a(i, b(i2));
                b(i, c(i2));
                i++;
            }
        }
        Arrays.fill(this.f27118c, i * 2, e(), (Object) null);
        this.f27119d = i;
    }

    public void a(P p) {
        if (p.d()) {
            return;
        }
        int c2 = c() - e();
        if (d() || c2 < p.e()) {
            a(e() + p.e());
        }
        System.arraycopy(p.f27118c, 0, this.f27118c, e(), p.e());
        this.f27119d += p.f27119d;
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }
}
