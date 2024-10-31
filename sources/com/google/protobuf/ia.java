package com.google.protobuf;

import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* compiled from: UnsafeUtil.java */
/* loaded from: classes2.dex */
final class ia {

    /* renamed from: a */
    private static final Unsafe f18782a = e();

    /* renamed from: b */
    private static final boolean f18783b = g();

    /* renamed from: c */
    private static final boolean f18784c = f();

    /* renamed from: d */
    private static final long f18785d = d();

    /* renamed from: e */
    private static final long f18786e = a(a((Class<?>) Buffer.class, "address"));

    public static long a() {
        return f18785d;
    }

    public static boolean b() {
        return f18784c;
    }

    public static boolean c() {
        return f18783b;
    }

    private static int d() {
        if (f18784c) {
            return f18782a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static Unsafe e() {
        try {
            return (Unsafe) AccessController.doPrivileged(new ha());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean f() {
        Unsafe unsafe = f18782a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("getByte", Object.class, Long.TYPE);
                cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean g() {
        Unsafe unsafe = f18782a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("getByte", Long.TYPE);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
                cls.getMethod("getLong", Long.TYPE);
                cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static byte a(byte[] bArr, long j) {
        return f18782a.getByte(bArr, j);
    }

    public static long b(byte[] bArr, long j) {
        return f18782a.getLong(bArr, j);
    }

    public static void a(byte[] bArr, long j, byte b2) {
        f18782a.putByte(bArr, j, b2);
    }

    private static long a(java.lang.reflect.Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = f18782a) == null) {
            return -1L;
        }
        return unsafe.objectFieldOffset(field);
    }

    private static java.lang.reflect.Field a(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
