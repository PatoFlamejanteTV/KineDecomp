package com.flurry.sdk;

import java.lang.Thread;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name */
    private static am f460a;
    private final Map<Thread.UncaughtExceptionHandler, Void> c = new WeakHashMap();
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

    public static synchronized am a() {
        am amVar;
        synchronized (am.class) {
            if (f460a == null) {
                f460a = new am();
            }
            amVar = f460a;
        }
        return amVar;
    }

    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        synchronized (this.c) {
            this.c.put(uncaughtExceptionHandler, null);
        }
    }

    private Set<Thread.UncaughtExceptionHandler> b() {
        Set<Thread.UncaughtExceptionHandler> keySet;
        synchronized (this.c) {
            keySet = this.c.keySet();
        }
        return keySet;
    }

    private am() {
        Thread.setDefaultUncaughtExceptionHandler(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Thread thread, Throwable th) {
        Iterator<Thread.UncaughtExceptionHandler> it = b().iterator();
        while (it.hasNext()) {
            try {
                it.next().uncaughtException(thread, th);
            } catch (Throwable th2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Thread thread, Throwable th) {
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }

    /* loaded from: classes.dex */
    final class a implements Thread.UncaughtExceptionHandler {
        private a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            am.this.a(thread, th);
            am.this.b(thread, th);
        }
    }
}
