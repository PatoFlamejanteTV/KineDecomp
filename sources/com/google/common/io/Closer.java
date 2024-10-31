package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Deque;
import java.util.logging.Level;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class Closer implements Closeable {

    /* renamed from: a */
    private static final c f15959a;

    /* renamed from: b */
    @VisibleForTesting
    final c f15960b;

    /* renamed from: c */
    private final Deque<Closeable> f15961c;

    /* renamed from: d */
    private Throwable f15962d;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class a implements c {

        /* renamed from: a */
        static final a f15963a = new a();

        a() {
        }

        @Override // com.google.common.io.Closer.c
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            Closeables.f15958a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class b implements c {

        /* renamed from: a */
        static final b f15964a = new b();

        /* renamed from: b */
        static final Method f15965b = b();

        b() {
        }

        static boolean a() {
            return f15965b != null;
        }

        private static Method b() {
            try {
                return Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.google.common.io.Closer.c
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                f15965b.invoke(th, th2);
            } catch (Throwable unused) {
                a.f15963a.a(closeable, th, th2);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    interface c {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        f15959a = b.a() ? b.f15964a : a.f15963a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th = this.f15962d;
        while (!this.f15961c.isEmpty()) {
            Closeable removeFirst = this.f15961c.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f15960b.a(removeFirst, th, th2);
                }
            }
        }
        if (this.f15962d != null || th == null) {
            return;
        }
        Throwables.b(th, IOException.class);
        throw new AssertionError(th);
    }
}
