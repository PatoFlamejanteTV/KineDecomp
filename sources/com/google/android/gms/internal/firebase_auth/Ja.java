package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public final class Ja {

    /* renamed from: a */
    private static final Logger f12974a = Logger.getLogger(Ja.class.getName());

    /* renamed from: b */
    private static final Unsafe f12975b = d();

    /* renamed from: c */
    private static final Class<?> f12976c = C1246e.b();

    /* renamed from: d */
    private static final boolean f12977d = d(Long.TYPE);

    /* renamed from: e */
    private static final boolean f12978e = d(Integer.TYPE);

    /* renamed from: f */
    private static final d f12979f;

    /* renamed from: g */
    private static final boolean f12980g;

    /* renamed from: h */
    private static final boolean f12981h;
    private static final long i;
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
    private static final boolean w;

    /* loaded from: classes2.dex */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, byte b2) {
            this.f12982a.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final boolean c(Object obj, long j) {
            return this.f12982a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final float d(Object obj, long j) {
            return this.f12982a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final double e(Object obj, long j) {
            return this.f12982a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final byte f(Object obj, long j) {
            return this.f12982a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, boolean z) {
            this.f12982a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, float f2) {
            this.f12982a.putFloat(obj, j, f2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, double d2) {
            this.f12982a.putDouble(obj, j, d2);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a */
        Unsafe f12982a;

        d(Unsafe unsafe) {
            this.f12982a = unsafe;
        }

        public final int a(Object obj, long j) {
            return this.f12982a.getInt(obj, j);
        }

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d2);

        public abstract void a(Object obj, long j, float f2);

        public abstract void a(Object obj, long j, boolean z);

        public final long b(Object obj, long j) {
            return this.f12982a.getLong(obj, j);
        }

        public abstract boolean c(Object obj, long j);

        public abstract float d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract byte f(Object obj, long j);

        public final void a(Object obj, long j, int i) {
            this.f12982a.putInt(obj, j, i);
        }

        public final void a(Object obj, long j, long j2) {
            this.f12982a.putLong(obj, j, j2);
        }
    }

    static {
        d dVar;
        d dVar2 = null;
        if (f12975b != null) {
            if (C1246e.a()) {
                if (f12977d) {
                    dVar2 = new b(f12975b);
                } else if (f12978e) {
                    dVar2 = new a(f12975b);
                }
            } else {
                dVar2 = new c(f12975b);
            }
        }
        f12979f = dVar2;
        f12980g = f();
        f12981h = e();
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
        Field g2 = g();
        v = (g2 == null || (dVar = f12979f) == null) ? -1L : dVar.f12982a.objectFieldOffset(g2);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private Ja() {
    }

    public static <T> T a(Class<T> cls) {
        try {
            return (T) f12975b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static boolean b() {
        return f12981h;
    }

    public static boolean c() {
        return f12980g;
    }

    public static float d(Object obj, long j2) {
        return f12979f.d(obj, j2);
    }

    public static double e(Object obj, long j2) {
        return f12979f.e(obj, j2);
    }

    public static Object f(Object obj, long j2) {
        return f12979f.f12982a.getObject(obj, j2);
    }

    private static Field g() {
        Field a2;
        if (C1246e.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, "address");
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
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

    private static int b(Class<?> cls) {
        if (f12981h) {
            return f12979f.f12982a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int c(Class<?> cls) {
        if (f12981h) {
            return f12979f.f12982a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Unsafe d() {
        try {
            return (Unsafe) AccessController.doPrivileged(new Ka());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean e() {
        Unsafe unsafe = f12975b;
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
            if (C1246e.a()) {
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
            Logger logger = f12974a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, byte b2) {
            if (!Ja.w) {
                Ja.d(obj, j, b2);
            } else {
                Ja.c(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final boolean c(Object obj, long j) {
            return Ja.w ? Ja.m(obj, j) : Ja.n(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final float d(Object obj, long j) {
            return Float.intBitsToFloat(a(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(b(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final byte f(Object obj, long j) {
            if (!Ja.w) {
                return Ja.l(obj, j);
            }
            return Ja.k(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, boolean z) {
            if (Ja.w) {
                Ja.d(obj, j, z);
            } else {
                Ja.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* loaded from: classes2.dex */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, byte b2) {
            if (!Ja.w) {
                Ja.d(obj, j, b2);
            } else {
                Ja.c(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final boolean c(Object obj, long j) {
            return Ja.w ? Ja.m(obj, j) : Ja.n(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final float d(Object obj, long j) {
            return Float.intBitsToFloat(a(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(b(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final byte f(Object obj, long j) {
            if (!Ja.w) {
                return Ja.l(obj, j);
            }
            return Ja.k(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, boolean z) {
            if (Ja.w) {
                Ja.d(obj, j, z);
            } else {
                Ja.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.firebase_auth.Ja.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    public static int a(Object obj, long j2) {
        return f12979f.a(obj, j2);
    }

    private static boolean f() {
        Unsafe unsafe = f12975b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (g() == null) {
                return false;
            }
            if (C1246e.a()) {
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
            Logger logger = f12974a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    public static void a(Object obj, long j2, int i2) {
        f12979f.a(obj, j2, i2);
    }

    public static long b(Object obj, long j2) {
        return f12979f.b(obj, j2);
    }

    public static boolean c(Object obj, long j2) {
        return f12979f.c(obj, j2);
    }

    private static boolean d(Class<?> cls) {
        if (!C1246e.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f12976c;
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

    public static void a(Object obj, long j2, long j3) {
        f12979f.a(obj, j2, j3);
    }

    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    public static void a(Object obj, long j2, boolean z) {
        f12979f.a(obj, j2, z);
    }

    public static void a(Object obj, long j2, float f2) {
        f12979f.a(obj, j2, f2);
    }

    public static void a(Object obj, long j2, double d2) {
        f12979f.a(obj, j2, d2);
    }

    public static void a(Object obj, long j2, Object obj2) {
        f12979f.f12982a.putObject(obj, j2, obj2);
    }

    public static byte a(byte[] bArr, long j2) {
        return f12979f.f(bArr, i + j2);
    }

    public static void a(byte[] bArr, long j2, byte b2) {
        f12979f.a((Object) bArr, i + j2, b2);
    }

    private static Field a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
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

    public static void e(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }
}
