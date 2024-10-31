package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class FinalizableReferenceQueue {
    private static final Logger c = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    private static final Method d = a(a(new d(), new a(), new b()));

    /* renamed from: a, reason: collision with root package name */
    final ReferenceQueue<Object> f2578a;
    final boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface c {
        Class<?> a();
    }

    public FinalizableReferenceQueue() {
        ReferenceQueue<Object> referenceQueue;
        boolean z;
        try {
            referenceQueue = (ReferenceQueue) d.invoke(null, FinalizableReference.class, this);
            z = true;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (Throwable th) {
            c.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
            referenceQueue = new ReferenceQueue<>();
            z = false;
        }
        this.f2578a = referenceQueue;
        this.b = z;
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
    static class d implements c {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        static boolean f2579a;

        d() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.c
        public Class<?> a() {
            if (f2579a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader == null) {
                    return null;
                }
                try {
                    return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                } catch (ClassNotFoundException e) {
                    return null;
                }
            } catch (SecurityException e2) {
                FinalizableReferenceQueue.c.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    static class a implements c {
        a() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.c
        public Class<?> a() {
            try {
                return a(b()).loadClass("com.google.common.base.internal.Finalizer");
            } catch (Exception e) {
                FinalizableReferenceQueue.c.log(Level.WARNING, "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.", (Throwable) e);
                return null;
            }
        }

        URL b() throws IOException {
            String str = "com.google.common.base.internal.Finalizer".replace('.', '/') + ".class";
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            }
            String url = resource.toString();
            if (!url.endsWith(str)) {
                throw new IOException("Unsupported path style: " + url);
            }
            return new URL(resource, url.substring(0, url.length() - str.length()));
        }

        URLClassLoader a(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    /* loaded from: classes2.dex */
    static class b implements c {
        b() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.c
        public Class<?> a() {
            try {
                return Class.forName("com.google.common.base.internal.Finalizer");
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
    }

    static Method a(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, Object.class);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }
}
