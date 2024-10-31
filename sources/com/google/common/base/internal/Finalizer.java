package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class Finalizer implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2589a = Logger.getLogger(Finalizer.class.getName());
    private static final Field e = a();
    private final WeakReference<Class<?>> b;
    private final PhantomReference<Object> c;
    private final ReferenceQueue<Object> d;

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                a(this.d.remove());
            } catch (ShutDown e2) {
                return;
            } catch (InterruptedException e3) {
            }
        }
    }

    private void a(Reference<?> reference) throws ShutDown {
        Method b = b();
        do {
            reference.clear();
            if (reference == this.c) {
                throw new ShutDown();
            }
            try {
                b.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                f2589a.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.d.poll();
        } while (reference != null);
    }

    private Method b() throws ShutDown {
        Class<?> cls = this.b.get();
        if (cls == null) {
            throw new ShutDown();
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
    }

    public static Field a() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            f2589a.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ShutDown extends Exception {
        private ShutDown() {
        }
    }
}
