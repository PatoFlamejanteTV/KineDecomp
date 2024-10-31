package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public abstract class DowngradeableSafeParcel implements SafeParcelable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f995a = new Object();
    private static ClassLoader b = null;
    private static Integer c = null;
    private boolean d = false;

    private static boolean a(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException e) {
            return false;
        } catch (NoSuchFieldException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(String str) {
        ClassLoader b_ = b_();
        if (b_ == null) {
            return true;
        }
        try {
            return a(b_.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader b_() {
        ClassLoader classLoader;
        synchronized (f995a) {
            classLoader = b;
        }
        return classLoader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Integer c_() {
        Integer num;
        synchronized (f995a) {
            num = c;
        }
        return num;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d_() {
        return this.d;
    }
}
