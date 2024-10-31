package com.google.android.gms.internal.gtm;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public final class ub {

    /* renamed from: a */
    private static final Logger f13304a = Logger.getLogger(ub.class.getName());

    /* renamed from: b */
    private static final Unsafe f13305b = c();

    /* renamed from: c */
    private static final Class<?> f13306c = Z.b();

    /* renamed from: d */
    private static final boolean f13307d = d(Long.TYPE);

    /* renamed from: e */
    private static final boolean f13308e = d(Integer.TYPE);

    /* renamed from: f */
    private static final d f13309f;

    /* renamed from: g */
    private static final boolean f13310g;

    /* renamed from: h */
    private static final boolean f13311h;
    static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final int w;
    static final boolean x;

    /* loaded from: classes2.dex */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(long j, byte b2) {
            Memory.pokeByte((int) (j & (-1)), b2);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final boolean c(Object obj, long j) {
            return ub.x ? ub.m(obj, j) : ub.n(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final float d(Object obj, long j) {
            return Float.intBitsToFloat(a(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(b(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final byte f(Object obj, long j) {
            return ub.x ? ub.k(obj, j) : ub.l(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, byte b2) {
            if (!ub.x) {
                ub.d(obj, j, b2);
            } else {
                ub.c(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, boolean z) {
            if (ub.x) {
                ub.d(obj, j, z);
            } else {
                ub.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & (-1)), bArr, (int) j, (int) j3);
        }
    }

    /* loaded from: classes2.dex */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(long j, byte b2) {
            Memory.pokeByte(j, b2);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final boolean c(Object obj, long j) {
            return ub.x ? ub.m(obj, j) : ub.n(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final float d(Object obj, long j) {
            return Float.intBitsToFloat(a(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(b(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final byte f(Object obj, long j) {
            return ub.x ? ub.k(obj, j) : ub.l(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, byte b2) {
            if (!ub.x) {
                ub.d(obj, j, b2);
            } else {
                ub.c(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, boolean z) {
            if (ub.x) {
                ub.d(obj, j, z);
            } else {
                ub.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(long j, byte b2) {
            this.f13312a.putByte(j, b2);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final boolean c(Object obj, long j) {
            return this.f13312a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final float d(Object obj, long j) {
            return this.f13312a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final double e(Object obj, long j) {
            return this.f13312a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final byte f(Object obj, long j) {
            return this.f13312a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, byte b2) {
            this.f13312a.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, boolean z) {
            this.f13312a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, float f2) {
            this.f13312a.putFloat(obj, j, f2);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(Object obj, long j, double d2) {
            this.f13312a.putDouble(obj, j, d2);
        }

        @Override // com.google.android.gms.internal.gtm.ub.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            this.f13312a.copyMemory(bArr, ub.i + j, (Object) null, j2, j3);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a */
        Unsafe f13312a;

        d(Unsafe unsafe) {
            this.f13312a = unsafe;
        }

        public final int a(Object obj, long j) {
            return this.f13312a.getInt(obj, j);
        }

        public abstract void a(long j, byte b2);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d2);

        public abstract void a(Object obj, long j, float f2);

        public abstract void a(Object obj, long j, boolean z);

        public abstract void a(byte[] bArr, long j, long j2, long j3);

        public final long b(Object obj, long j) {
            return this.f13312a.getLong(obj, j);
        }

        public abstract boolean c(Object obj, long j);

        public abstract float d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract byte f(Object obj, long j);

        public final void a(Object obj, long j, int i) {
            this.f13312a.putInt(obj, j, i);
        }

        public final void a(Object obj, long j, long j2) {
            this.f13312a.putLong(obj, j, j2);
        }
    }

    static {
        d dVar;
        d dVar2 = null;
        if (f13305b != null) {
            if (Z.a()) {
                if (f13307d) {
                    dVar2 = new b(f13305b);
                } else if (f13308e) {
                    dVar2 = new a(f13305b);
                }
            } else {
                dVar2 = new c(f13305b);
            }
        }
        f13309f = dVar2;
        f13310g = e();
        f13311h = d();
        i = b(byte[].class);
        j = b(boolean[].class);
        k = c(boolean[].class);
        l = b(int[].class);
        m = c(int[].class);
        n = b(long[].class);
        o = c(long[].class);
        p = b(float[].class);
        q = c(float[].class);
        r = b(double[].class);
        s = c(double[].class);
        t = b(Object[].class);
        u = c(Object[].class);
        Field f2 = f();
        v = (f2 == null || (dVar = f13309f) == null) ? -1L : dVar.f13312a.objectFieldOffset(f2);
        w = (int) (i & 7);
        x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private ub() {
    }

    public static boolean a() {
        return f13311h;
    }

    public static boolean b() {
        return f13310g;
    }

    private static int c(Class<?> cls) {
        if (f13311h) {
            return f13309f.f13312a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static float d(Object obj, long j2) {
        return f13309f.d(obj, j2);
    }

    public static double e(Object obj, long j2) {
        return f13309f.e(obj, j2);
    }

    public static Object f(Object obj, long j2) {
        return f13309f.f13312a.getObject(obj, j2);
    }

    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) (((j2 ^ (-1)) & 3) << 3)));
    }

    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    public static boolean m(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    public static boolean n(Object obj, long j2) {
        return l(obj, j2) != 0;
    }

    public static <T> T a(Class<T> cls) {
        try {
            return (T) f13305b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (f13311h) {
            return f13309f.f13312a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static boolean d() {
        Unsafe unsafe = f13305b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (Z.a()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f13304a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean e() {
        Unsafe unsafe = f13305b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (f() == null) {
                return false;
            }
            if (Z.a()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f13304a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    public static boolean c(Object obj, long j2) {
        return f13309f.c(obj, j2);
    }

    private static Field f() {
        Field a2;
        if (Z.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, "address");
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    public static int a(Object obj, long j2) {
        return f13309f.a(obj, j2);
    }

    public static long b(Object obj, long j2) {
        return f13309f.b(obj, j2);
    }

    public static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new vb());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Object obj, long j2, int i2) {
        f13309f.a(obj, j2, i2);
    }

    public static void a(Object obj, long j2, long j3) {
        f13309f.a(obj, j2, j3);
    }

    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    public static void a(Object obj, long j2, boolean z) {
        f13309f.a(obj, j2, z);
    }

    public static void a(Object obj, long j2, float f2) {
        f13309f.a(obj, j2, f2);
    }

    public static void a(Object obj, long j2, double d2) {
        f13309f.a(obj, j2, d2);
    }

    public static void a(Object obj, long j2, Object obj2) {
        f13309f.f13312a.putObject(obj, j2, obj2);
    }

    public static byte a(byte[] bArr, long j2) {
        return f13309f.f(bArr, i + j2);
    }

    public static void a(byte[] bArr, long j2, byte b2) {
        f13309f.a((Object) bArr, i + j2, b2);
    }

    public static void a(byte[] bArr, long j2, long j3, long j4) {
        f13309f.a(bArr, j2, j3, j4);
    }

    public static void a(long j2, byte b2) {
        f13309f.a(j2, b2);
    }

    public static long a(ByteBuffer byteBuffer) {
        return f13309f.b(byteBuffer, v);
    }

    public static int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int numberOfTrailingZeros;
        if (i2 >= 0 && i3 >= 0 && i4 >= 0 && i2 + i4 <= bArr.length && i3 + i4 <= bArr2.length) {
            int i5 = 0;
            if (f13311h) {
                for (int i6 = (w + i2) & 7; i5 < i4 && (i6 & 7) != 0; i6++) {
                    if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                        return i5;
                    }
                    i5++;
                }
                int i7 = ((i4 - i5) & (-8)) + i5;
                while (i5 < i7) {
                    long j2 = i5;
                    long b2 = b(bArr, i + i2 + j2);
                    long b3 = b(bArr2, i + i3 + j2);
                    if (b2 != b3) {
                        if (x) {
                            numberOfTrailingZeros = Long.numberOfLeadingZeros(b2 ^ b3);
                        } else {
                            numberOfTrailingZeros = Long.numberOfTrailingZeros(b2 ^ b3);
                        }
                        return i5 + (numberOfTrailingZeros >> 3);
                    }
                    i5 += 8;
                }
            }
            while (i5 < i4) {
                if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void e(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    private static boolean d(Class<?> cls) {
        if (!Z.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f13306c;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    public static void d(Object obj, long j2, boolean z) {
        c(obj, j2, z ? (byte) 1 : (byte) 0);
    }
}
