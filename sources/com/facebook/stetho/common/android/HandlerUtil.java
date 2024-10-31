package com.facebook.stetho.common.android;

import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

/* loaded from: classes.dex */
public final class HandlerUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.stetho.common.android.HandlerUtil$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1<V> extends WaitableRunnable<V> {
        AnonymousClass1() {
        }

        @Override // com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable
        protected V onRun() {
            return (V) UncheckedCallable.this.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.stetho.common.android.HandlerUtil$2 */
    /* loaded from: classes.dex */
    public static class AnonymousClass2 extends WaitableRunnable<Void> {
        final /* synthetic */ Runnable val$r;

        AnonymousClass2(Runnable runnable) {
            runnable = runnable;
        }

        @Override // com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable
        public Void onRun() {
            runnable.run();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class WaitableRunnable<V> implements Runnable {
        private Exception mException;
        private boolean mIsDone;
        private V mValue;

        protected WaitableRunnable() {
        }

        private void join() {
            synchronized (this) {
                while (!this.mIsDone) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        public V invoke(Handler handler) {
            if (handler.post(this)) {
                join();
                Exception exc = this.mException;
                if (exc == null) {
                    return this.mValue;
                }
                throw new RuntimeException(exc);
            }
            throw new RuntimeException("Handler.post() returned false");
        }

        protected abstract V onRun();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    this.mValue = onRun();
                    this.mException = null;
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                    }
                } catch (Exception e2) {
                    this.mValue = null;
                    this.mException = e2;
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                    }
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.mIsDone = true;
                    notifyAll();
                    throw th;
                }
            }
        }
    }

    private HandlerUtil() {
    }

    public static boolean checkThreadAccess(Handler handler) {
        return Looper.myLooper() == handler.getLooper();
    }

    public static <V> V postAndWait(Handler handler, UncheckedCallable<V> uncheckedCallable) {
        if (checkThreadAccess(handler)) {
            try {
                return uncheckedCallable.call();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return new WaitableRunnable<V>() { // from class: com.facebook.stetho.common.android.HandlerUtil.1
            AnonymousClass1() {
            }

            @Override // com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable
            protected V onRun() {
                return (V) UncheckedCallable.this.call();
            }
        }.invoke(handler);
    }

    public static void verifyThreadAccess(Handler handler) {
        Util.throwIfNot(checkThreadAccess(handler));
    }

    public static void postAndWait(Handler handler, Runnable runnable) {
        if (checkThreadAccess(handler)) {
            try {
                runnable.run();
                return;
            } catch (RuntimeException e2) {
                throw new RuntimeException(e2);
            }
        }
        new WaitableRunnable<Void>() { // from class: com.facebook.stetho.common.android.HandlerUtil.2
            final /* synthetic */ Runnable val$r;

            AnonymousClass2(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable
            public Void onRun() {
                runnable.run();
                return null;
            }
        }.invoke(handler);
    }
}
