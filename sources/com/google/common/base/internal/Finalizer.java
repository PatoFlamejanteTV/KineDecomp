package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class Finalizer implements Runnable {

    /* renamed from: a */
    private static final Logger f15136a = Logger.getLogger(Finalizer.class.getName());

    /* renamed from: b */
    private static final Field f15137b = b();

    /* renamed from: c */
    private final WeakReference<Class<?>> f15138c;

    /* renamed from: d */
    private final PhantomReference<Object> f15139d;

    /* renamed from: e */
    private final ReferenceQueue<Object> f15140e;

    private boolean a(Reference<?> reference) {
        Method c2 = c();
        if (c2 == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.f15139d) {
                return false;
            }
            try {
                c2.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                f15136a.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.f15140e.poll();
        } while (reference != null);
        return true;
    }

    @Nullable
    public static Field b() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f15136a.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    @Nullable
    private Method c() {
        Class<?> cls = this.f15138c.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f15140e.remove())) {
        }
    }
}
