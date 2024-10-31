package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtIncompatible
/* loaded from: classes2.dex */
public class FinalizableReferenceQueue implements Closeable {

    /* renamed from: a */
    private static final Logger f15085a = Logger.getLogger(FinalizableReferenceQueue.class.getName());

    /* renamed from: b */
    private static final Method f15086b = a(a(new d(), new a(), new b()));

    /* renamed from: c */
    final ReferenceQueue<Object> f15087c = new ReferenceQueue<>();

    /* renamed from: d */
    final PhantomReference<Object> f15088d = new PhantomReference<>(this, this.f15087c);

    /* renamed from: e */
    final boolean f15089e;

    /* loaded from: classes2.dex */
    static class b implements c {
        b() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.c
        public Class<?> a() {
            try {
                return Class.forName("com.google.common.base.internal.Finalizer");
            } catch (ClassNotFoundException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        @Nullable
        Class<?> a();
    }

    /* loaded from: classes2.dex */
    static class d implements c {

        /* renamed from: a */
        @VisibleForTesting
        static boolean f15090a;

        d() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.c
        @Nullable
        public Class<?> a() {
            if (f15090a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.f15085a.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public FinalizableReferenceQueue() {
        boolean z = true;
        try {
            f15086b.invoke(null, FinalizableReference.class, this.f15087c, this.f15088d);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (Throwable th) {
            f15085a.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
            z = false;
        }
        this.f15089e = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b() {
        if (this.f15089e) {
            return;
        }
        while (true) {
            Reference<? extends Object> poll = this.f15087c.poll();
            if (poll == 0) {
                return;
            }
            poll.clear();
            try {
                ((FinalizableReference) poll).a();
            } catch (Throwable th) {
                f15085a.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15088d.enqueue();
        b();
    }

    private static Class<?> a(c... cVarArr) {
        for (c cVar : cVarArr) {
            Class<?> a2 = cVar.a();
            if (a2 != null) {
                return a2;
            }
        }
        throw new AssertionError();
    }

    /* loaded from: classes2.dex */
    static class a implements c {
        a() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.c
        @Nullable
        public Class<?> a() {
            try {
                return a(b()).loadClass("com.google.common.base.internal.Finalizer");
            } catch (Exception e2) {
                FinalizableReferenceQueue.f15085a.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", (Throwable) e2);
                return null;
            }
        }

        URL b() throws IOException {
            String str = "com.google.common.base.internal.Finalizer".replace('.', '/') + ".class";
            URL resource = a.class.getClassLoader().getResource(str);
            if (resource != null) {
                String url = resource.toString();
                if (url.endsWith(str)) {
                    return new URL(resource, url.substring(0, url.length() - str.length()));
                }
                throw new IOException("Unsupported path style: " + url);
            }
            throw new FileNotFoundException(str);
        }

        URLClassLoader a(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    static Method a(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
    }
}
