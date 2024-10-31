package io.reactivex.d.a;

import io.reactivex.c.c;

/* compiled from: ObjectHelper.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    static final c<Object, Object> f28113a = new a();

    /* compiled from: ObjectHelper.java */
    /* loaded from: classes3.dex */
    static final class a implements c<Object, Object> {
        a() {
        }
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
