package io.reactivex.a.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.r;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler.java */
/* loaded from: classes3.dex */
final class c extends r {

    /* renamed from: b, reason: collision with root package name */
    private final Handler f28094b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f28095c;

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes3.dex */
    private static final class a extends r.b {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f28096a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f28097b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f28098c;

        a(Handler handler, boolean z) {
            this.f28096a = handler;
            this.f28097b = z;
        }

        @Override // io.reactivex.r.b
        @SuppressLint({"NewApi"})
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit != null) {
                if (this.f28098c) {
                    return io.reactivex.disposables.c.a();
                }
                b bVar = new b(this.f28096a, io.reactivex.f.a.a(runnable));
                Message obtain = Message.obtain(this.f28096a, bVar);
                obtain.obj = this;
                if (this.f28097b) {
                    obtain.setAsynchronous(true);
                }
                this.f28096a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.f28098c) {
                    return bVar;
                }
                this.f28096a.removeCallbacks(bVar);
                return io.reactivex.disposables.c.a();
            }
            throw new NullPointerException("unit == null");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28098c = true;
            this.f28096a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28098c;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes3.dex */
    private static final class b implements Runnable, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f28099a;

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f28100b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f28101c;

        b(Handler handler, Runnable runnable) {
            this.f28099a = handler;
            this.f28100b = runnable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28099a.removeCallbacks(this);
            this.f28101c = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28101c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f28100b.run();
            } catch (Throwable th) {
                io.reactivex.f.a.b(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Handler handler, boolean z) {
        this.f28094b = handler;
        this.f28095c = z;
    }

    @Override // io.reactivex.r
    @SuppressLint({"NewApi"})
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit != null) {
            b bVar = new b(this.f28094b, io.reactivex.f.a.a(runnable));
            Message obtain = Message.obtain(this.f28094b, bVar);
            if (this.f28095c) {
                obtain.setAsynchronous(true);
            }
            this.f28094b.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            return bVar;
        }
        throw new NullPointerException("unit == null");
    }

    @Override // io.reactivex.r
    public r.b a() {
        return new a(this.f28094b, this.f28095c);
    }
}
