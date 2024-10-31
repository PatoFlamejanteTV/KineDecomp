package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public final class La {

    /* renamed from: a */
    private static final Logger f12792a = Logger.getLogger(La.class.getName());

    /* renamed from: b */
    private static final Unsafe f12793b = d();

    /* renamed from: c */
    private static final Class<?> f12794c = C1211m.b();

    /* renamed from: d */
    private static final boolean f12795d = c(Long.TYPE);

    /* renamed from: e */
    private static final boolean f12796e = c(Integer.TYPE);

    /* renamed from: f */
    private static final d f12797f;

    /* renamed from: g */
    private static final boolean f12798g;

    /* renamed from: h */
    private static final boolean f12799h;
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
    private static final long w;
    private static final boolean x;

    /* loaded from: classes2.dex */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(long j, byte b2) {
            Memory.pokeByte((int) (j & (-1)), b2);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, byte b2) {
            if (La.x) {
                La.c(obj, j, b2);
            } else {
                La.d(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, boolean z) {
            if (La.x) {
                La.d(obj, j, z);
            } else {
                La.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & (-1)), bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final boolean c(Object obj, long j) {
            return La.x ? La.m(obj, j) : La.n(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final float d(Object obj, long j) {
            return Float.intBitsToFloat(a(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(b(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final byte f(Object obj, long j) {
            return La.x ? La.k(obj, j) : La.l(obj, j);
        }
    }

    /* loaded from: classes2.dex */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(long j, byte b2) {
            Memory.pokeByte(j, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, byte b2) {
            if (La.x) {
                La.c(obj, j, b2);
            } else {
                La.d(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, boolean z) {
            if (La.x) {
                La.d(obj, j, z);
            } else {
                La.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final boolean c(Object obj, long j) {
            return La.x ? La.m(obj, j) : La.n(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final float d(Object obj, long j) {
            return Float.intBitsToFloat(a(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(b(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final byte f(Object obj, long j) {
            return La.x ? La.k(obj, j) : La.l(obj, j);
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(long j, byte b2) {
            this.f12800a.putByte(j, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, byte b2) {
            this.f12800a.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, double d2) {
            this.f12800a.putDouble(obj, j, d2);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, float f2) {
            this.f12800a.putFloat(obj, j, f2);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(Object obj, long j, boolean z) {
            this.f12800a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            this.f12800a.copyMemory(bArr, La.i + j, (Object) null, j2, j3);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final boolean c(Object obj, long j) {
            return this.f12800a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final float d(Object obj, long j) {
            return this.f12800a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final double e(Object obj, long j) {
            return this.f12800a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.La.d
        public final byte f(Object obj, long j) {
            return this.f12800a.getByte(obj, j);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a */
        Unsafe f12800a;

        d(Unsafe unsafe) {
            this.f12800a = unsafe;
        }

        public final int a(Object obj, long j) {
            return this.f12800a.getInt(obj, j);
        }

        public final long a(Field field) {
            return this.f12800a.objectFieldOffset(field);
        }

        public abstract void a(long j, byte b2);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d2);

        public abstract void a(Object obj, long j, float f2);

        public final void a(Object obj, long j, int i) {
            this.f12800a.putInt(obj, j, i);
        }

        public final void a(Object obj, long j, long j2) {
            this.f12800a.putLong(obj, j, j2);
        }

        public abstract void a(Object obj, long j, boolean z);

        public abstract void a(byte[] bArr, long j, long j2, long j3);

        public final long b(Object obj, long j) {
            return this.f12800a.getLong(obj, j);
        }

        public abstract boolean c(Object obj, long j);

        public abstract float d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract byte f(Object obj, long j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0105  */
    static {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.La.<clinit>():void");
    }

    private La() {
    }

    public static byte a(byte[] bArr, long j2) {
        return f12797f.f(bArr, i + j2);
    }

    private static int a(Class<?> cls) {
        if (f12799h) {
            return f12797f.f12800a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int a(Object obj, long j2) {
        return f12797f.a(obj, j2);
    }

    public static long a(Field field) {
        return f12797f.a(field);
    }

    public static long a(ByteBuffer byteBuffer) {
        return f12797f.b(byteBuffer, v);
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

    public static void a(long j2, byte b2) {
        f12797f.a(j2, b2);
    }

    public static void a(Object obj, long j2, double d2) {
        f12797f.a(obj, j2, d2);
    }

    public static void a(Object obj, long j2, float f2) {
        f12797f.a(obj, j2, f2);
    }

    public static void a(Object obj, long j2, int i2) {
        f12797f.a(obj, j2, i2);
    }

    public static void a(Object obj, long j2, long j3) {
        f12797f.a(obj, j2, j3);
    }

    public static void a(Object obj, long j2, Object obj2) {
        f12797f.f12800a.putObject(obj, j2, obj2);
    }

    public static void a(Object obj, long j2, boolean z) {
        f12797f.a(obj, j2, z);
    }

    public static void a(byte[] bArr, long j2, byte b2) {
        f12797f.a((Object) bArr, i + j2, b2);
    }

    public static void a(byte[] bArr, long j2, long j3, long j4) {
        f12797f.a(bArr, j2, j3, j4);
    }

    private static int b(Class<?> cls) {
        if (f12799h) {
            return f12797f.f12800a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static long b(Object obj, long j2) {
        return f12797f.b(obj, j2);
    }

    private static long b(Field field) {
        d dVar;
        if (field == null || (dVar = f12797f) == null) {
            return -1L;
        }
        return dVar.a(field);
    }

    public static boolean b() {
        return f12799h;
    }

    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    public static boolean c() {
        return f12798g;
    }

    private static boolean c(Class<?> cls) {
        if (!C1211m.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f12794c;
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

    public static boolean c(Object obj, long j2) {
        return f12797f.c(obj, j2);
    }

    public static float d(Object obj, long j2) {
        return f12797f.d(obj, j2);
    }

    public static Unsafe d() {
        try {
            return (Unsafe) AccessController.doPrivileged(new Ma());
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

    public static double e(Object obj, long j2) {
        return f12797f.e(obj, j2);
    }

    public static void e(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static Object f(Object obj, long j2) {
        return f12797f.f12800a.getObject(obj, j2);
    }

    private static boolean f() {
        Unsafe unsafe = f12793b;
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
            if (C1211m.a()) {
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
            Logger logger = f12792a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean g() {
        Unsafe unsafe = f12793b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (h() == null) {
                return false;
            }
            if (C1211m.a()) {
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
            Logger logger = f12792a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field h() {
        Field a2;
        if (C1211m.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
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
}
